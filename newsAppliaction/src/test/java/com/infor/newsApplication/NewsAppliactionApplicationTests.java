/*
 * package com.infor.newsApplication;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.MockitoJUnitRunner;
 * 
 * import com.infor.newsApplication.entity.Section; import
 * com.infor.newsApplication.entity.SectionDetails; import
 * com.infor.newsApplication.model.SectionResponse; import
 * com.infor.newsApplication.repository.SectionRepository;
 * 
 * import com.infor.newsApplication.serviceImpl.SectionServiceImpl;
 * 
 * //@SpringBootTest
 * 
 * @RunWith(MockitoJUnitRunner.class) public class
 * NewsAppliactionApplicationTests {
 * 
 * @Mock SectionRepository sectionRepositoryTest;
 * 
 * @InjectMocks SectionServiceImpl serviceImplTest;
 * 
 * @Test public void getBySectionNameTest() { SectionDetails sectionDetails =
 * new SectionDetails(102, 1000, "Chili Chicken", "Increases fat, crabs",
 * "Hello"); Section section = new Section(1000, "Food", "12-09-2019",
 * "20-08-2019", "02-09-2019", "Shuvam", "Shuvam Kumar", sectionDetails);
 * when(sectionRepositoryTest.findBySectionName("Food")).thenReturn(section);
 * assertEquals(section, serviceImplTest.getBySectionName("Food")); }
 * 
 * 
 * 
 * }
 */