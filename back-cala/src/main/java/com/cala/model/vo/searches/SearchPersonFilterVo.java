package com.cala.model.vo.searches;

import java.util.Date;
import java.util.List;

import com.cala.model.entities.configurations.AgeGroup;
import com.cala.model.entities.filters.Gender;
import com.cala.model.entities.filters.Ideology;
import com.cala.model.entities.filters.Interest;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.entities.filters.Topic;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.entities.filters.TypeParticipation;

public class SearchPersonFilterVo {
	//person
	private String name;
	private Boolean kids;
	private Boolean disability;
	private Gender gender;
	private TypeJob job;
	private AgeGroup group;
	private List<Ideology> ideologies;
	//subject
	private String surname;
	private Date birthdayFrom;
	private Date birthdayUntil;
	private List<Topic> topics;
	private List<TypeParticipation> typeParticipation;
	private List<Interest> interests;
	private List<NexusManagement> nexusManagement;
	
	
	public SearchPersonFilterVo(String name, String surname, Boolean kids, Boolean disability, Gender gender,
			TypeJob job, AgeGroup group, List<Ideology> ideologies, List<Topic> topics, List<TypeParticipation> typeParticipation,
			List<Interest> interests, List<NexusManagement> nexusManagement, Date birthdayFrom, Date birthdayUntil) {
		this.name = name;
		this.surname = surname;
		this.kids = kids;
		this.disability = disability;
		this.gender = gender;
		this.job = job;
		this.group = group;
		this.ideologies = ideologies;
		this.topics = topics;
		this.typeParticipation = typeParticipation;
		this.interests = interests;
		this.nexusManagement = nexusManagement;
		this.birthdayFrom = birthdayFrom;
		this.birthdayUntil = birthdayUntil;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Boolean isKids() {
		return kids;
	}
	public void setKids(Boolean kids) {
		this.kids = kids;
	}
	public Boolean isDisability() {
		return disability;
	}
	public void setDisability(Boolean disability) {
		this.disability = disability;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public TypeJob getJob() {
		return job;
	}

	public void setJob(TypeJob job) {
		this.job = job;
	}

	public AgeGroup getGroup() {
		return group;
	}

	public void setGroup(AgeGroup group) {
		this.group = group;
	}

	public List<Ideology> getIdeologies() {
		return ideologies;
	}

	public void setIdeologies(List<Ideology> ideologies) {
		this.ideologies = ideologies;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<TypeParticipation> getTypeParticipation() {
		return typeParticipation;
	}

	public void setTypeParticipation(List<TypeParticipation> typeParticipation) {
		this.typeParticipation = typeParticipation;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public List<NexusManagement> getNexusManagement() {
		return nexusManagement;
	}

	public void setNexusManagement(List<NexusManagement> nexusManagement) {
		this.nexusManagement = nexusManagement;
	}

	public Date getBirthdayFrom() {
		return birthdayFrom;
	}

	public void setBirthdayFrom(Date birthdayFrom) {
		this.birthdayFrom = birthdayFrom;
	}

	public Date getBirthdayUntil() {
		return birthdayUntil;
	}

	public void setBirthdayUntil(Date birthdayUntil) {
		this.birthdayUntil = birthdayUntil;
	}
	
			
}
