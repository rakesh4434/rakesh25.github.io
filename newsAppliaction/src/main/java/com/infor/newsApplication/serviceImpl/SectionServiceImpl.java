package com.infor.newsApplication.serviceImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.infor.newsApplication.constant.NewsApplicationConstant;
import com.infor.newsApplication.entity.Section;
import com.infor.newsApplication.entity.SectionDetails;
import com.infor.newsApplication.exception.SectionNotFoundException;
import com.infor.newsApplication.model.SectionResponse;
import com.infor.newsApplication.repository.SectionDetailsRepository;
import com.infor.newsApplication.repository.SectionRepository;
import com.infor.newsApplication.service.SectionService;
import com.mongodb.DBCollection;
import com.mongodb.DBRef;
import com.mongodb.DBRefCodec;
import com.mongodb.DuplicateKeyException;

/*
		@author 1822780
 */

@Service
public class SectionServiceImpl implements SectionService{
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	MongoTemplate template;
	
	
	@Autowired
	SectionResponse sectionResponse;
	
	public SectionResponse createSections(Section section) {
		try { 
			//if(section == null)
				//throw new NullPointerException("Section is Null");
			
			sectionRepository.insert(section);
			sectionResponse.setMsg("Record Inserted"); 
			sectionResponse.setStatus(NewsApplicationConstant.CREATED);
			sectionResponse.setStatusCode(NewsApplicationConstant.STATUS_CODE_CREATED);
		
		  }
		  
		  catch (DuplicateKeyException mwe) { 
			  sectionResponse.setMsg(mwe.getMessage());
			  sectionResponse.setStatus(NewsApplicationConstant.BAD_REQUEST);
			  sectionResponse.setStatusCode(NewsApplicationConstant.STATUS_CODE_BAD_REQUEST
		  ); }
		return sectionResponse;
	}
	
	public SectionResponse updateSection(Section section) {
		try {
			sectionRepository.save(section);
			sectionResponse.setMsg("Record Inserted");
			sectionResponse.setStatus(NewsApplicationConstant.OK);
			sectionResponse.setStatusCode(NewsApplicationConstant.STATUS_CODE_OK);
		}catch (IllegalArgumentException e) {
			sectionResponse.setMsg(e.getMessage());
			sectionResponse.setStatus(NewsApplicationConstant.INTERNAL_SERVER_ERROR);
			sectionResponse.setStatusCode(NewsApplicationConstant.STATUS_CODE_INTERNAL_SERVER_ERROR);
		}
		return sectionResponse;
	}
	  
	public SectionResponse deleteSection(Section section) {
		try {
			sectionRepository.delete(section);
			sectionResponse.setMsg("Record deleted"); 
			sectionResponse.setStatus("OK");
			sectionResponse.setStatusCode(200);
	}catch (IllegalArgumentException e) {
		sectionResponse.setMsg(e.getMessage());
		sectionResponse.setStatus(NewsApplicationConstant.INTERNAL_SERVER_ERROR);
		sectionResponse.setStatusCode(NewsApplicationConstant.STATUS_CODE_INTERNAL_SERVER_ERROR);
	}	
		return sectionResponse;
	}
	
	public Optional<Section> getBySectionName(String sectionName) throws SectionNotFoundException{
		//System.out.println(sectionName);
		//DBRef db = new DBRef("sectionDetails",104);
		//System.out.println(db.toString()); 
		//Query query = new Query();
		//query.addCriteria(Criteria.where("sectionName")
				//.is(sectionName).and("sectionDetails.$id").is(new Integer("104")));
		Optional<Section> section=sectionRepository.findBySectionName(sectionName);
		
		if(!section.isPresent()) {
			try {
			throw new SectionNotFoundException("No Section Found From the given Section Name");
			}
			catch (SectionNotFoundException e) {
				//throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}
		}
		//Section rr = sectionRepository.save(dbSection);
		//System.out.println(dbSection.getSectionId()+"------------");
		//SectionDetails sectionDetails = sectionDetailsRepository.findBySectionId(dbSection.getSectionId());
		//System.out.println(sectionDetails.getSectionDetId()+"++++++++++++++++++");
		//dbSection.setSectionDetails(sectionDetails);
		return section;
				
	}
}
