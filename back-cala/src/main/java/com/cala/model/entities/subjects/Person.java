package com.cala.model.entities.subjects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.configurations.AgeGroup;
import com.cala.model.entities.filters.Gender;
import com.cala.model.entities.filters.Ideology;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.vo.subjects.PersonVo;

@Entity
@DiscriminatorValue(value = "PERSON")
public class Person extends Subject implements Auditable{
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="document")
	private String document;
	
	@Column(name="type_document")
	private String typeDocument;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="job")
	private String job;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name = "kids")
	private boolean kids;
	
	@Column(name="kids_names")
	private String kidsNames;
	
	@Column(name = "disability")
	private boolean disability;
	
	@Column(name="disability_name")
	private String disabilityName;
		
	@ManyToOne
	@JoinColumn(name="gender_id")
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name="type_job_id")
	private TypeJob typeJob;

	@ManyToOne
	@JoinColumn(name="age_group_id")
	private AgeGroup ageGroup;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Ideology> ideologies;
	
	public Person() {}
	
	public Person(PersonVo person) {
		setName(person.getName());
		setEmail(person.getEmail());
		setBirthday(person.getBirthday());
		setDiscord(person.getDiscord());
		setFacebook(person.getFacebook());
		setInstagram(person.getInstagram());
		setTwitter(person.getTwitter());
		setPhone(person.getPhone());
		setHighlight(person.isHighlight());		
		this.surname = person.getSurname();
		this.document = person.getDocument();
		this.typeDocument = person.getTypeDocument();
		this.nickname = person.getNickname();
		this.job = person.getJob();
		this.profession = person.getProfession();
		this.kids = person.isKids();
		this.kidsNames = person.getKidsNames();
		this.disability = person.isDisability();
		this.disabilityName = person.getDisabilityName();
	}

	public void update(PersonVo person) {
		setName(person.getName());
		setEmail(person.getEmail());
		setBirthday(person.getBirthday());
		setDiscord(person.getDiscord());
		setFacebook(person.getFacebook());
		setInstagram(person.getInstagram());
		setTwitter(person.getTwitter());
		setPhone(person.getPhone());
		setHighlight(person.isHighlight());		
		this.surname = person.getSurname();
		this.document = person.getDocument();
		this.typeDocument = person.getTypeDocument();
		this.nickname = person.getNickname();
		this.job = person.getJob();
		this.profession = person.getProfession();
		this.kids = person.isKids();
		this.kidsNames = person.getKidsNames();
		this.disability = person.isDisability();
		this.disabilityName = person.getDisabilityName();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public boolean isKids() {
		return kids;
	}

	public void setKids(boolean kids) {
		this.kids = kids;
	}

	public String getKidsNames() {
		return kidsNames;
	}

	public void setKidsNames(String kidsNames) {
		this.kidsNames = kidsNames;
	}

	public boolean isDisability() {
		return disability;
	}

	public void setDisability(boolean disability) {
		this.disability = disability;
	}

	public String getDisabilityName() {
		return disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	public TypeJob getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(TypeJob typeJob) {
		this.typeJob = typeJob;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	public List<Ideology> getIdeologies() {
		return ideologies;
	}

	public void setIdeologies(List<Ideology> ideologies) {
		this.ideologies = ideologies;
	}
	
	@Override
	public String generateLog(String method) {
		return method +"-> " + "{id:" + getId() + ", nombre:" + getName() + ", apellido:" + getSurname() +"}";
	}

}
