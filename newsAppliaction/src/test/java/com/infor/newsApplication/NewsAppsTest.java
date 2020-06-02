package com.infor.newsApplication;

import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infor.newsApplication.constant.NewsApplicationConstant;
import com.infor.newsApplication.entity.Section;
import com.infor.newsApplication.exception.SectionNotFoundException;
import com.infor.newsApplication.repository.SectionRepository;
import com.infor.newsApplication.service.SectionService;
import com.infor.newsApplication.serviceImpl.SectionServiceImpl;
import com.mongodb.DuplicateKeyException;

@RunWith(SpringRunner.class)
//@WebMvcTest( value =SectionController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NewsAppsTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMaper;

	@MockBean
	private SectionRepository sectionRepositoryTest;
	
	// SectionDetails sectionDetails = new SectionDetails(102, 1000, "Chili
	// Chicken", "Increases fat, crabs", "Hello");
	// Section section = new Section(1000, "Food", "12-09-2019", "20-08-2019",
	// "02-09-2019", "Shuvam", "Shuvam Kumar", sectionDetails);

	private <T> T getJSONResponse(String fileName, Class<?> c) throws Exception {

		T t = (T) objectMaper.readValue(new File(fileName), c);

		// For returning list from json file
		// JavaType type =
		// objectMaper.getTypeFactory().constructCollectionType(List.class,
		// Section.class);
		// objectMaper.readValue(new File(fileName),type );

		return t;
	}

	private String asJsonString(final Object obj) throws Exception {

		return objectMaper.writeValueAsString(obj);
	}

	@Test 
	public void getBySectionNameTest() throws Exception {
	  
	  Section section = getJSONResponse("logs/section.json", Section.class);
	  
	  Mockito.when(sectionRepositoryTest.findBySectionName(Mockito.anyString())).thenReturn( Optional.of(section)); 
	  RequestBuilder requestBuilder = MockMvcRequestBuilders
	  //.get("/sectionNews/{sectionName}", section.getSectionName())
	  .get("/sectionNews/Food").accept(MediaType.APPLICATION_JSON);
	  
	  mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk
	  ());
	  
	  // JSONAssert.assertEquals(result.getResponse().getContentAsString(),result.getResponse().getContentAsString(),true);
	  
	  } 
	
	@Test(expected = ResponseStatusException.class)
	public void getBySectionNameTest_SectionNotFound() throws Exception {
	   Section section = new Section();
	  Mockito.when(sectionRepositoryTest.findBySectionName(Mockito.anyString())).thenReturn(Optional.of( section ));
	  //.thenThrow(SectionNotFoundException.class); 
	  RequestBuilder requestBuilder = MockMvcRequestBuilders
	  //.get("/sectionNews/{sectionName}", section.getSectionName())
	  .get("/sectionNews/Food").accept(MediaType.APPLICATION_JSON); 
	  
	  //mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
	  
	  // JSONAssert.assertEquals(result.getResponse().getContentAsString(),result.getResponse().getContentAsString(),true);
	  
	  }

	@Test
	public void createSectionTest() throws Exception {

		Mockito.when(sectionRepositoryTest.insert(Mockito.any(Section.class))) // it is used to call the method of that
																				// class which we have mocked
				.thenReturn(getJSONResponse("logs/section.json", Section.class)); // returns the value that we require
																					// after mocking

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(NewsApplicationConstant.CREATE_SECTION_ENDPOINT) // url
				.content(asJsonString(getJSONResponse("logs/section.json", Section.class))) // it is used to pass a
																							// value or object that our
																							// method requires
				.contentType(MediaType.APPLICATION_JSON);// here we are specifying the type of file that we contain

		mockMvc.perform(requestBuilder)
				// .andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());

	}
	
	/*
	@Test(expected = NullPointerException.class)
	public void testForNullPointerException_CreateSection() throws Exception {
		
		SectionService sectionService = mock(SectionServiceImpl.class);
		Mockito.doThrow(NullPointerException.class).when(sectionService).createSections(Mockito.any(Section.class)); //
		Mockito.when(sectionRepositoryTest.insert(Mockito.any(Section.class))).thenThrow(DuplicateKeyException.class);
		String s = null;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(NewsApplicationConstant.CREATE_SECTION_ENDPOINT).content(s)
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNoContent());

	}
	*/
	 
	@Test
	public void createSectionExceptionTest() throws Exception {

		Mockito.doThrow(DuplicateKeyException.class).when(sectionRepositoryTest).insert(Mockito.any(Section.class));
		// Mockito.when(sectionRepositoryTest.insert(Mockito.any(Section.class))).thenThrow(DuplicateKeyException.class);

		RequestBuilder requestBuilder;
		requestBuilder = MockMvcRequestBuilders.post(NewsApplicationConstant.CREATE_SECTION_ENDPOINT)
				.content(asJsonString(getJSONResponse("logs/section.json", Section.class)))
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public void updateSectionTest() throws Exception {
		Mockito.when(sectionRepositoryTest.save(Mockito.any(Section.class)))
				.thenReturn(getJSONResponse("logs/section.json", Section.class));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(NewsApplicationConstant.UPDATE_SECTION_ENDPOINT)
				.content(asJsonString(getJSONResponse("logs/section.json", Section.class)))
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void updateSectionExceptionTest() throws Exception {

		Mockito.doThrow(IllegalArgumentException.class).when(sectionRepositoryTest).save(Mockito.any(Section.class));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(NewsApplicationConstant.UPDATE_SECTION_ENDPOINT)
				.content(asJsonString(getJSONResponse("logs/section2.json", Section.class)))
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isInternalServerError());

	} 

	@Test
	public void deleteSectionTest() throws Exception {

		Mockito.doNothing().when(sectionRepositoryTest).delete(Mockito.any(Section.class));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(NewsApplicationConstant.DELETE_SECTION_ENDPOINT)
				.content(asJsonString(getJSONResponse("logs/section.json", Section.class)))
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void deleteSectionExceptionTest() throws Exception {

		Mockito.doThrow(IllegalArgumentException.class).when(sectionRepositoryTest).delete(Mockito.any(Section.class));
		// Mockito.when(sectionRepositoryTest.delete(Mockito.any(Section.class))).thenThrow(DuplicateKeyException.class);
		// error as delete() method's return type is a void so in this case we have to
		// use doThrow() instead of thenThrow()

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(NewsApplicationConstant.DELETE_SECTION_ENDPOINT)
				.content(asJsonString(this.getJSONResponse("logs/section2.json", Section.class)))
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isInternalServerError());

	}

}
