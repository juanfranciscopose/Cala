package com.cala.model.dto.subjects;

import java.util.Date;

public class PersonDto {

	private Long id;
	
	private boolean highlight;

	private String surname;
	
	private String document;

	private String typeDocument;

	private String nickname;

	private String job;
	
	private String profession;
	
	private boolean kids;

	private String kidsNames;

	private boolean disability;

	private String disabilityName;
	
	private String name;
	
	private String email;
	
	private Date birthday;
	
	private String discord;
	
	private String facebook;
	
	private String instagram;

	private String twitter;
	
	private String phone;
	
	private String gender;
	
	private String ageGroup;
	
	private String[] ideologies;
	
	private String[] topics;
	
	private String[] typeParticipation;

	private String[] interests;
	
	private String typeJob;

	private String[] nexusManagement;
	
	private String[] descriptions;
	
	public PersonDto() {}

	/*public PersonDto(PersonVo person) {
		new PersonDto(person.getId(), person.isHighlight(), person.getSurname(), person.getDocument(), person.getTypeDocument(),
				person.getNickname(), person.getJob(), person.getProfession(), person.isKids(), person.getKidsNames(), person.isDisability(),
				person.getDisabilityName(), person.getName(), person.getEmail(), person.getBirthday(), person.getDiscord(), person.getFacebook(),
				person.getInstagram(), person.getTwitter(), person.getPhone(), person.getGender(), person.getAgeGroup(), person.getIdeologies(), 
				person.getTopics(), person.getTypeParticipation(), person.getInterests(), person.getTypeJob(), person.getNexusManagement(), 
				person.getDescriptions());
	}*/

	public PersonDto(Long id, boolean highlight, String surname, String document, String typeDocument, String nickname, String job,
			String profession, boolean kids, String kidsNames, boolean disability, String disabilityName, String name,
			String email, Date birthday, String discord, String facebook, String instagram, String twitter,
			String phone, String gender, String ageGroup, String[] ideologies, String[] topics,
			String[] typeParticipation, String[] interests, String typeJob,
			String[] nexusManagement, String[] descriptions) {
		this.id = id;
		this.highlight = highlight;
		this.surname = surname;
		this.document = document;
		this.typeDocument = typeDocument;
		this.nickname = nickname;
		this.job = job;
		this.profession = profession;
		this.kids = kids;
		this.kidsNames = kidsNames;
		this.disability = disability;
		this.disabilityName = disabilityName;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.discord = discord;
		this.facebook = facebook;
		this.instagram = instagram;
		this.twitter = twitter;
		this.phone = phone;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.ideologies = ideologies;
		this.topics = topics;
		this.typeParticipation = typeParticipation;
		this.interests = interests;
		this.typeJob = typeJob;
		this.nexusManagement = nexusManagement;
		this.descriptions = descriptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDiscord() {
		return discord;
	}

	public void setDiscord(String discord) {
		this.discord = discord;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String[] getIdeologies() {
		return ideologies;
	}

	public void setIdeologies(String[] ideologies) {
		this.ideologies = ideologies;
	}

	public String[] getTopics() {
		return topics;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public String[] getTypeParticipation() {
		return typeParticipation;
	}

	public void setTypeParticipation(String[] typeParticipation) {
		this.typeParticipation = typeParticipation;
	}

	public String[] getInterests() {
		return interests;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}

	public String getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
	}

	public String[] getNexusManagement() {
		return nexusManagement;
	}

	public void setNexusManagement(String[] nexusManagement) {
		this.nexusManagement = nexusManagement;
	}

	public String[] getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String[] descriptions) {
		this.descriptions = descriptions;
	}

	public String generateLog() {
		return "{id=" + id + ", surname=" + surname + ", document=" + document + ", typeDocument="
				+ typeDocument + ", nickname=" + nickname + ", job=" + job + ", profession=" + profession + ", kids="
				+ kids + ", kidsNames=" + kidsNames + ", disability=" + disability + ", disabilityName="
				+ disabilityName + ", name=" + name + ", email=" + email + ", birthday=" + birthday + ", discord="
				+ discord + ", facebook=" + facebook + ", instagram=" + instagram + ", twitter=" + twitter + ", phone="
				+ phone + ", gender=" + gender + ", ageGroup=" + ageGroup + ", ideologies=" + ideologies + ", topics="
				+ topics + ", typeParticipation=" + typeParticipation + ", interests=" + interests + ", typeJob="
				+ typeJob + ", nexusManagement=" + nexusManagement + ", descriptions=" + descriptions + "}";
	}

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
	
}
