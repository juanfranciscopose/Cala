package com.cala.model.vo.subjects;

import java.util.Date;
import java.util.List;

import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.global.AbstractVo;

public abstract class SubjectVo extends AbstractVo {
	
	private String name;
	
	private String email;
	
	private Date birthday;
	
	private String discord;
	
	private String facebook;
	
	private String instagram;
	
	private String twitter;
	
	private String phone;
	
	private boolean highlight;
	
	private List<TopicVo> topics;
	
	private List<TypeParticipationVo> typeParticipation;
	
	private List<InterestVo> interests;
	
	private List<NexusManagementVo> nexusManagement;
	
	private List<DescriptionVo> descriptions;
	
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

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
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
		
}
