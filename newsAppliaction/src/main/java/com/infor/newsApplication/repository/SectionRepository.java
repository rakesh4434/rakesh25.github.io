package com.infor.newsApplication.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.infor.newsApplication.entity.Section;

/*
	@author 1822780
*/

@Repository
public interface SectionRepository extends MongoRepository<Section, Integer> {
	Optional<Section> findBySectionName(String sectionName);
}
