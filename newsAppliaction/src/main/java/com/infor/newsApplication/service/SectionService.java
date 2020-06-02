package com.infor.newsApplication.service;

import java.util.List;
import java.util.Optional;

import com.infor.newsApplication.entity.Section;
import com.infor.newsApplication.exception.SectionNotFoundException;
import com.infor.newsApplication.model.SectionResponse;

/*
	@author 1822780
*/

public interface SectionService {
	public SectionResponse createSections(Section s);
	public SectionResponse updateSection(Section s);
	public SectionResponse deleteSection(Section s);
	//public void addMultipleSections(List<Section> lsec);
	public Optional<Section> getBySectionName(String sectionName) throws SectionNotFoundException;
	
}
