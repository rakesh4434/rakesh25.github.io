package com.infor.newsApplication.entity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/*
	@author 1822780
*/

@Document(collection = "sections")
public class Section {
	@Id
	@Indexed
	private int sectionId;
	  
	private String sectionName;
	private String updatedDate;
	private String createdDate;
	private String publishedDate;
	private String updatedBy;
	private String createdBy;
	
	//@DBRef(db="sectionDetails")
	private SectionDetails sectionDetails;
	
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public SectionDetails getSectionDetails() {
		return sectionDetails;
	}
	public void setSectionDetails(SectionDetails sectionDetails) {
		this.sectionDetails = sectionDetails;
	}

	/*
	 * public Section(int sectionId, String sectionName, String updatedDate, String
	 * createdDate, String publishedDate, String updatedBy, String createdBy,
	 * SectionDetails sectionDetails) { super(); this.sectionId = sectionId;
	 * this.sectionName = sectionName; this.updatedDate = updatedDate;
	 * this.createdDate = createdDate; this.publishedDate = publishedDate;
	 * this.updatedBy = updatedBy; this.createdBy = createdBy; this.sectionDetails =
	 * sectionDetails; }
	 */
	public Section() {
		super();
	}
	/*
	 * @Override public String toString() { return "Section [sectionId=" + sectionId
	 * + ", sectionName=" + sectionName + ", updatedDate=" + updatedDate +
	 * ", createdDate=" + createdDate + ", publishedDate=" + publishedDate +
	 * ", updatedBy=" + updatedBy + ", createdBy=" + createdBy + ", sectionDetails="
	 * + sectionDetails + "]"; }
	 */
	
	
	
	
	
	
	
}
