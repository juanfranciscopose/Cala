package com.cala.model.entities.subjects;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.cala.model.entities.filters.Interest;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.entities.filters.Topic;
import com.cala.model.entities.filters.TypeParticipation;

@Entity
@Table(name="subjects")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_subject", discriminatorType = DiscriminatorType.STRING)
public abstract class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", length = 150)
	private String name;
	
	@Column(name="email", length = 150)
	private String email;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="discord", length = 150)
	private String discord;
	
	@Column(name="facebook", length = 150)
	private String facebook;
	
	@Column(name="instagram", length = 150)
	private String instagram;
	
	@Column(name="twitter", length = 150)
	private String twitter;
	
	@Column(name="phone", length = 100)
	private String phone;
	
	@Column(name="highlight")
	private boolean highlight;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Topic> topics;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TypeParticipation> typeParticipation;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Interest> interests;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<NexusManagement> nexusManagement;
	
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Description> descriptions;
	
	//@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
	//@LazyCollection(LazyCollectionOption.FALSE)
	//private List<Visit> visits;
	
	//@OneToOne
	//private Georeference georeference;
	
	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	/*public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}*/

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

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	/*public Georeference getGeoreference() {
		return georeference;
	}

	public void setGeoreference(Georeference georeference) {
		this.georeference = georeference;
	}*/
					
}
