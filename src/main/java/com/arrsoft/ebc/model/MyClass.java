package com.arrsoft.ebc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
public class MyClass {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	private String title;
    private String description;
    @NotNull @NotEmpty
    private String programmingLanguage;
    private String trainer;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="myClass")
    private List<Pembahasan> pembahasan;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public List<Pembahasan> getPembahasan() {
		return pembahasan;
	}
	public void setPembahasan(List<Pembahasan> pembahasan) {
		this.pembahasan = pembahasan;
	}
    
    //setter & getter
    
}
