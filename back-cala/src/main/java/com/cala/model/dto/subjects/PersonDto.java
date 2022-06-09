package com.cala.model.dto.subjects;

import java.util.Date;
import java.util.List;

import com.cala.model.vo.configurations.AgeGroupVo;
import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.TypeJobVo;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.subjects.DescriptionVo;
import com.cala.model.vo.subjects.PersonVo;
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
	
	private GenderVo gender;
	
	private AgeGroupVo ageGroup;
	
	private List<GenericFilterVo> ideologies;
	
	private List<TopicVo> topics;
	
	private List<TypeParticipationVo> typeParticipation;

	private List<InterestVo> interests;
	
	private TypeJobVo typeJob;

	private List<NexusManagementVo> nexusManagement;
	
	private List<DescriptionVo> descriptions;
	
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
			String phone, GenderVo gender, AgeGroupVo ageGroup, List<GenericFilterVo> ideologies, List<TopicVo> topics,
			List<TypeParticipationVo> typeParticipation, List<InterestVo> interests, TypeJobVo typeJob,
			List<NexusManagementVo> nexusManagement, List<DescriptionVo> descriptions) {
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

	public GenderVo getGender() {
		return gender;
	}

	public void setGender(GenderVo gender) {
		this.gender = gender;
	}

	public AgeGroupVo getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroupVo ageGroup) {
		this.ageGroup = ageGroup;
	}

	public List<GenericFilterVo> getIdeologies() {
		return ideologies;
	}

	public void setIdeologies(List<GenericFilterVo> ideologies) {
		this.ideologies = ideologies;
	}

	public List<TopicVo> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicVo> topics) {
		this.topics = topics;
	}

	public List<TypeParticipationVo> getTypeParticipation() {
		return typeParticipation;
	}

	public void setTypeParticipation(List<TypeParticipationVo> typeParticipation) {
		this.typeParticipation = typeParticipation;
	}

	public List<InterestVo> getInterests() {
		return interests;
	}

	public void setInterests(List<InterestVo> interests) {
		this.interests = interests;
	}

	public TypeJobVo getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(TypeJobVo typeJob) {
		this.typeJob = typeJob;
	}

	public List<NexusManagementVo> getNexusManagement() {
		return nexusManagement;
	}

	public void setNexusManagement(List<NexusManagementVo> nexusManagement) {
		this.nexusManagement = nexusManagement;
	}

	public List<DescriptionVo> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<DescriptionVo> descriptions) {
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

	public PersonVo toVo() {
		PersonVo personVo = new PersonVo();
		personVo.setId(getId());
		personVo.setHighlight(isHighlight());
		personVo.setSurname(getSurname());
		personVo.setDocument(getDocument());
		personVo.setTypeDocument(getTypeDocument());
		personVo.setNickname(getNickname());
		personVo.setJob(getJob());
		personVo.setProfession(getProfession());
		personVo.setKids(isKids());
		personVo.setKidsNames(getKidsNames());
		personVo.setDisability(isDisability());
		personVo.setDisabilityName(getDisabilityName());
		personVo.setName(getName());
		personVo.setEmail(getEmail());
		personVo.setBirthday(getBirthday());
		personVo.setDiscord(getDiscord());
		personVo.setFacebook(getFacebook());
		personVo.setInstagram(getInstagram());
		personVo.setTwitter(getTwitter());
		personVo.setPhone(getPhone());
		personVo.setGender(getGender());
		personVo.setAgeGroup(getAgeGroup());
		personVo.setIdeologies(getIdeologies());
		personVo.setTopics(getTopics());
		personVo.setTypeParticipation(getTypeParticipation());
		personVo.setInterests(getInterests());
		personVo.setTypeJob(getTypeJob());
		personVo.setNexusManagement(getNexusManagement());
		personVo.setDescriptions(getDescriptions());
		return personVo;
	}
	
}
