package com.infor.newsApplication.controller;


import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infor.newsApplication.constant.NewsApplicationConstant;
import com.infor.newsApplication.entity.Section;
import com.infor.newsApplication.exception.SectionNotFoundException;
import com.infor.newsApplication.model.SectionResponse;
import com.infor.newsApplication.service.SectionService;
/*
	@author 1822780
*/

@RestController
public class SectionController extends ResponseEntityExceptionHandler {
	
	@Autowired
	SectionService sectionService;
	
	
	SectionResponse sectionResponse;
	
	@PostMapping(value = NewsApplicationConstant.CREATE_SECTION_ENDPOINT)
	public ResponseEntity<SectionResponse> createSection(@RequestBody Section section) {
		
		sectionResponse=sectionService.createSections(section); 

		return requiredResponse(sectionResponse); 
	}
	
	@GetMapping("/fine")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(value = NewsApplicationConstant.GET_SECTION_ENDPOINT)
	public ResponseEntity<Optional<Section>> getSectionNews(@PathVariable String sectionName) throws SectionNotFoundException{
		//try {
			return new ResponseEntity<Optional<Section>>(sectionService.getBySectionName(sectionName),HttpStatus.OK);
		//}catch(SectionNotFoundException snfe) {
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND,snfe.getMessage());
		//} 
	} 
	
	@PutMapping(value = NewsApplicationConstant.UPDATE_SECTION_ENDPOINT)
	public ResponseEntity<SectionResponse> updateSection(@RequestBody Section section) {
		
		sectionResponse=sectionService.updateSection(section);
		
		return requiredResponse(sectionResponse);
	}
	
	@DeleteMapping(value = NewsApplicationConstant.DELETE_SECTION_ENDPOINT)
	public ResponseEntity<SectionResponse> deleteSection(@RequestBody Section section) {
		
		sectionResponse=sectionService.deleteSection(section);
		
		return requiredResponse(sectionResponse);
	}
	
	private ResponseEntity<SectionResponse> requiredResponse(SectionResponse sectionResponse){
		if(NewsApplicationConstant.STATUS_CODE_OK == sectionResponse.getStatusCode())
		    return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.OK);
		else if(NewsApplicationConstant.STATUS_CODE_CREATED == sectionResponse.getStatusCode())
		    return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.CREATED);
		else if(NewsApplicationConstant.STATUS_CODE_INTERNAL_SERVER_ERROR == sectionResponse.getStatusCode())
			return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		else if(NewsApplicationConstant.STATUS_CODE_NOT_FOUND == sectionResponse.getStatusCode())
			return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.NOT_FOUND);
		else if(NewsApplicationConstant.STATUS_CODE_BAD_REQUEST == sectionResponse.getStatusCode())
			return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.BAD_REQUEST);
		else if(NewsApplicationConstant.STATUS_CODE_UNAUTHORIZED == sectionResponse.getStatusCode())
			return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.UNAUTHORIZED);
		else
			return new ResponseEntity<SectionResponse>(sectionResponse, HttpStatus.NOT_IMPLEMENTED);
	}
}
