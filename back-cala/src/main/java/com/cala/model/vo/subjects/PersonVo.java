package com.cala.model.vo.subjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.dto.subjects.PersonDto;
import com.cala.model.entities.subjects.Person;
import com.cala.model.vo.configurations.AgeGroupVo;
import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.filters.IdeologyVo;
import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.TypeJobVo;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class PersonVo extends SubjectVo {
	
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
	
	private TypeJobVo typeJob;
	
	private GenderVo gender;
	
	private AgeGroupVo ageGroup;
	
	private List<GenericFilterVo> ideologies;
	
	public static List<PersonVo> createListVo(List<Person> list) {
		return list.stream().map(person -> new PersonVo(person)).collect(Collectors.toList());
	}
	
	public static List<PersonDto> createListDto(List<PersonVo> listVo) {
		return listVo.stream().map(person -> {
			return person.toDTO();
		}).collect(Collectors.toList());
	}

	public static PersonVo createVo(Person person) {
		if (person != null) {
			return new PersonVo(person);
		}
		return null;
	}

	public PersonVo() {}
	
	public PersonVo(Person person) {
		setId(person.getId());
		setName(person.getName());
		setEmail(person.getEmail());
		setBirthday(person.getBirthday());
		setDiscord(person.getDiscord());
		setFacebook(person.getFacebook());
		setInstagram(person.getInstagram());
		setTwitter(person.getTwitter());
		setPhone(person.getPhone());
		setHighlight(person.isHighlight());		
		setInterests(InterestVo.createListInterestsVo(person.getInterests()));
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
		this.typeJob = TypeJobVo.createVo(person.getTypeJob());
		this.gender = GenderVo.createVo(person.getGender());
		this.ageGroup = AgeGroupVo.createVo(person.getAgeGroup());
		this.ideologies = IdeologyVo.createListVo(person.getIdeologies());
		setTypeParticipation(TypeParticipationVo.createListTypeParticipationVo(person.getTypeParticipation()));
		setNexusManagement(NexusManagementVo.createListNexusManagementVo(person.getNexusManagement()));
		setTopics(TopicVo.createListTopicVo(person.getTopics()));
	}
	
	public PersonVo(String name, String email, Date birthday, String discord, String facebook, String instagram,String twitter,
			String phone, boolean highlight, String surname, String document, String typeDocument, String nickname, String job,
			String profession, boolean kids, String kidsNames, boolean disability, String disabilityName) {
		setName(name);
		setEmail(email);
		setBirthday(birthday);
		setDiscord(discord);
		setFacebook(facebook);
		setInstagram(instagram);
		setTwitter(twitter);
		setPhone(phone);
		setTopics(null);
		setDescriptions(null);
		setTypeParticipation(null);
		setInterests(null);
		setNexusManagement(null);
		setHighlight(highlight);		
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
		this.typeJob = null;
		this.gender = null;
		this.ageGroup = null;
		this.ideologies = null;
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

	public TypeJobVo getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(TypeJobVo typeJob) {
		this.typeJob = typeJob;
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
	
	public PersonDto toDTO() {
		PersonDto personDto = new PersonDto();
		personDto.setId(getId());
		personDto.setHighlight(isHighlight());
		personDto.setSurname(getSurname());
		personDto.setDocument(getDocument());
		personDto.setTypeDocument(getTypeDocument());
		personDto.setNickname(getNickname());
		personDto.setJob(getJob());
		personDto.setProfession(getProfession());
		personDto.setKids(isKids());
		personDto.setKidsNames(getKidsNames());
		personDto.setDisability(isDisability());
		personDto.setDisabilityName(getDisabilityName());
		personDto.setName(getName());
		personDto.setEmail(getEmail());
		personDto.setBirthday(getBirthday());
		personDto.setDiscord(getDiscord());
		personDto.setFacebook(getFacebook());
		personDto.setInstagram(getInstagram());
		personDto.setTwitter(getTwitter());
		personDto.setPhone(getPhone());
		if (getGender() != null) {
			personDto.setGender(getGender().getCode());
		}
		if (getTypeJob() != null) {
			personDto.setTypeJob(getTypeJob().getCode());
		}
		if (getInterests() != null) {
			ArrayList<String> array = new ArrayList<String>();
			for (InterestVo intrest: getInterests()) {
				array.add(intrest.getCode());
			}
			String[] stringArray = array.toArray(new String[10]);
			personDto.setInterests(stringArray);
		}
		// TODO: refactor!! horrible
		if (getNexusManagement() != null) {
			ArrayList<String> array = new ArrayList<String>();
			for (NexusManagementVo nm: getNexusManagement()) {
				array.add(nm.getCode());
			}
			String[] stringArray = array.toArray(new String[10]);
			personDto.setNexusManagement(stringArray);
		}
		if (getTopics() != null) {
			ArrayList<String> array = new ArrayList<String>();
			for (TopicVo topic: getTopics()) {
				array.add(topic.getCode());
			}
			String[] stringArray = array.toArray(new String[10]);
			personDto.setTopics(stringArray);
		}
		if (getIdeologies() != null) {
			ArrayList<String> array = new ArrayList<String>();
			for (GenericFilterVo ideology: getIdeologies()) {
				array.add(ideology.getCode());
			}
			String[] stringArray = array.toArray(new String[10]);
			personDto.setIdeologies(stringArray);
		}
		if (getTypeParticipation() != null) {
			ArrayList<String> array = new ArrayList<String>();
			for (TypeParticipationVo type: getTypeParticipation()) {
				array.add(type.getCode());
			}
			String[] stringArray = array.toArray(new String[10]);
			personDto.setTypeParticipation(stringArray);
		}
		return personDto;				
	}
	
}
