package com.infor.newsApplication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
	@author 1822780
*/

@Document(collection = "sectionDetails")
public class SectionDetails {
	
	
	@Id
	private int sectionDetId;
	@Indexed
	private int sectionId;
	private String title;
	private String newsAbstract ;
	private String url;
	public int getSectionDetId() {
		return sectionDetId;
	}
	public void setSectionDetId(int sectionDetId) {
		this.sectionDetId = sectionDetId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewsAbstract() {
		return newsAbstract;
	}
	public void setNewsAbstract(String newsAbstract) {
		this.newsAbstract = newsAbstract;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	 
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	
	/*
	 * @PersistenceConstructor public SectionDetails(int sectionDetId, int
	 * sectionId, String title, String newsAbstract, String url) { super();
	 * this.sectionDetId = sectionDetId; this.sectionId = sectionId; this.title =
	 * title; this.newsAbstract = newsAbstract; this.url = url; }
	 */
	public SectionDetails() {
		super();
	}
	
	
	
	
}
