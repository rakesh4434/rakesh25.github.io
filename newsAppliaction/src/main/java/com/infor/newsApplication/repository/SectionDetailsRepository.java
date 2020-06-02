package com.infor.newsApplication.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.infor.newsApplication.entity.Section;
import com.infor.newsApplication.entity.SectionDetails;

/*
	@author 1822780
*/

public interface SectionDetailsRepository extends MongoRepository<SectionDetails, Integer> {
		SectionDetails findBySectionId(int id);
}
