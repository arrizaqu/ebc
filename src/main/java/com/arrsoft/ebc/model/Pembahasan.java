package com.arrsoft.ebc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
public class Pembahasan {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	@NotNull @NotEmpty
	private String sectionTitle;
	private String contentText;
	private String videosUrl;
	private String category;
	@ManyToOne
	private MyClass myClass;
	private String fileUrl;
	private String blogUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSectionTitle() {
		return sectionTitle;
	}
	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	public String getVideosUrl() {
		return videosUrl;
	}
	public void setVideosUrl(String videosUrl) {
		this.videosUrl = videosUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public MyClass getMyClass() {
		return myClass;
	}
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getBlogUrl() {
		return blogUrl;
	}
	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}
	
}
