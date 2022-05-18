package com.cala.dao.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.configurations.AgeGroup;
import com.cala.model.entities.filters.Gender;
import com.cala.model.entities.filters.Ideology;
import com.cala.model.entities.filters.Interest;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.entities.filters.Topic;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.entities.subjects.Description;
import com.cala.model.entities.subjects.Person;
import com.cala.model.vo.configurations.AgeGroupVo;
import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.filters.IdeologyVo;
import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.TypeJobVo;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.model.vo.searches.SearchPersonFilterVo;
import com.cala.model.vo.subjects.DescriptionVo;
import com.cala.model.vo.subjects.PersonVo;
import com.cala.repository.configurations.AgeGroupRepository;
import com.cala.repository.filters.GenderFilterRepository;
import com.cala.repository.filters.IdeologyFilterRepository;
import com.cala.repository.filters.InterestFilterRepository;
import com.cala.repository.filters.NexusManagementFilterRepository;
import com.cala.repository.filters.TopicFilterRepository;
import com.cala.repository.filters.TypeJobFilterRepository;
import com.cala.repository.filters.TypeParticipationFilterRepository;
import com.cala.repository.subjects.PersonRepository;

@Repository
public class PersonDao extends GenericSubjectDao<PersonVo, Person> implements I_PersonDao{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private GenderFilterRepository genderRepository;
	
	@Autowired
	private TypeJobFilterRepository typeJobRepository;
	
	@Autowired
	private IdeologyFilterRepository ideologyRepository;
	
	@Autowired
	private NexusManagementFilterRepository nexusManagementRepository;
	
	@Autowired
	private InterestFilterRepository interestRepository;
	
	@Autowired
	private TypeParticipationFilterRepository typeParticipationRepository;
	
	@Autowired
	private TopicFilterRepository topicRepository;
	
	@Autowired
	private AgeGroupRepository ageGroupRepository;
	
	Logger logger = LoggerFactory.getLogger(PersonDao.class);
	
	@Override
	public List<PersonVo> findAllOrderByHighlightNameSurname(PaginationVo pagination) {
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
			Page<Person> subjects = getPersonRepository().findAllOrderByHighlightDescSurnameAscNameAsc(pageRequest);
			return PersonVo.createListVo(subjects.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo findAllOrderByHighlightNameSurname de PersonDao");
			return null;
		}
	}
	
	@Override
	public PersonVo setDescription(Long id, List<DescriptionVo> descriptions) {
		try {
			if (descriptions != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				List<Description> desc = new ArrayList<>();
				descriptions.stream().forEach(descriptionVo -> {
					Description d = new Description(descriptionVo.getDescription(), descriptionVo.isStatus(), descriptionVo.getStamp());
					desc.add(d);
				});
				if (person.isPresent() && !desc.isEmpty()) {
					person.get().setDescriptions(desc);
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setDescription de PersonDao");
			return null;
		}
	}
	
	@Override
	public List<PersonVo> findAllWithFilters(SearchPersonFilterVo filter, PaginationVo pagination){
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());
			Page<Person> subjects;
			if (filter != null) {
				subjects = getPersonRepository().findAll(PersonSpecification.filter(filter), pageRequest);
			}else {
				subjects = getPersonRepository().findAll(pageRequest);
			}
			return PersonVo.createListVo(subjects.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo findAllWithFilters de PersonDao");
			return null;
		}
	}	

	@Override
	public PersonVo setTopics(Long id, List<TopicVo> filters) {
		try {
			if (filters != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				List<Topic> topics = new ArrayList<>();
				filters.stream().forEach(topicVo -> {
					Optional<Topic> f = getTopicRepository().findByName(topicVo.getName());
					if (f.isPresent()) {
						topics.add(f.get());
					}
				});
				if (person.isPresent() && !topics.isEmpty()) {
					person.get().setTopics(topics);
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setTopics de PersonDao");
			return null;
		}
	}

	@Override
	public PersonVo setTypeParticipations(Long id, List<TypeParticipationVo> filters) {
		try {
			if (filters != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				List<TypeParticipation> types = new ArrayList<>();
				filters.stream().forEach(typeParticipationVo -> {
					Optional<TypeParticipation> f = getTypeParticipationRepository().findByName(typeParticipationVo.getName());
					if (f.isPresent()) {
						types.add(f.get());
					}
				});
				if (person.isPresent() && !types.isEmpty()) {
					person.get().setTypeParticipation(types);
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;	
		} catch (Exception e) {
			logger.error("Error en metodo setTypeParticipations de PersonDao");
			return null;
		}
	}

	@Override
	public PersonVo setInterests(Long id, List<InterestVo> filters) {
		try {
			if (filters != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				List<Interest> interests = new ArrayList<>();
				filters.stream().forEach(interestVo -> {
					Optional<Interest> f = getInterestRepository().findByName(interestVo.getName());
					if (f.isPresent()) {
						interests.add(f.get());
					}
				});
				if (person.isPresent() && !interests.isEmpty()) {
					person.get().setInterests(interests);
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setInterests de PersonDao");
			return null;
		}
	}

	@Override
	public PersonVo setNexusManagement(Long id, List<NexusManagementVo> filters) {
		try {
			if (filters != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				List<NexusManagement> nexus = new ArrayList<>();
				filters.stream().forEach(nexusVo -> {
					Optional<NexusManagement> f = getNexusManagementRepository().findByName(nexusVo.getName());
					if (f.isPresent()) {
						nexus.add(f.get());
					}
				});
				if (person.isPresent() && !nexus.isEmpty()) {
					person.get().setNexusManagement(nexus);
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setNexusManagement de PersonDao");
			return null;
		}
	}
	
	@Override
	public PersonVo setAgeGroup(Long id, AgeGroupVo config) {
		try {
			if (config != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				Optional<AgeGroup> group = getAgeGroupRepository().findByName(config.getName());
				if (person.isPresent() && group.isPresent()) {
					person.get().setAgeGroup(group.get());
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setAgeGroup de PersonDao");
			return null;
		}
	}
	
	@Override
	public PersonVo setIdeologies(Long id, List<IdeologyVo> filters) {
		try {
			if (filters != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				List<Ideology> ideologies = new ArrayList<>();
				filters.stream().forEach(ideologyVo -> {
					Optional<Ideology> f = getIdeologyRepository().findByName(ideologyVo.getName());
					if (f.isPresent()) {
						ideologies.add(f.get());
					}
				});
				if (person.isPresent() && !ideologies.isEmpty()) {
					person.get().setIdeologies(ideologies);
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setIdeologies de PersonDao");
			return null;
		}
	}
	
	@Override
	public PersonVo setTypeJob(Long id, TypeJobVo type) {
		try {
			if (type != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				Optional<TypeJob> typeJob = getTypeJobRepository().findByName(type.getName());
				if (person.isPresent() && typeJob.isPresent()) {
					person.get().setTypeJob(typeJob.get());
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setTypeJob de PersonDao");
			return null;
		}
	}
	
	@Override
	public PersonVo setGender(Long id, GenderVo gender) {
		try {
			if (gender != null && id != null) {
				Optional<Person> person = getRepository().findById(id);
				Optional<Gender> gen = getGenderRepository().findByName(gender.getName());
				if (person.isPresent() && gen.isPresent()) {
					person.get().setGender(gen.get());
					Person p = getRepository().save(person.get());
					return PersonVo.createVo(p);
				}	
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo setGender de PersonDao");
			return null;
		}
	}

	@Override
	public PersonVo update(PersonVo personVo) {
		try {
			Optional<Person> person = getRepository().findById(personVo.getId());
			if(person.isPresent()) {
				Person p = person.get();
				p.update(personVo);
				p = getPersonRepository().save(p);
				return PersonVo.createVo(p);
			}
			return null;		
		} catch (Exception e) {
			logger.error("Error en metodo update de PersonDao");
			return null;
		}
	}
	
	@Override
	public PersonVo findById(Long id) {
		try {
			Optional<Person> person = getRepository().findById(id);
			if(person.isPresent()) {
				return PersonVo.createVo(person.get());
			}
			return null;		
		} catch (Exception e) {
			logger.error("Error en metodo findById de PersonDao");
			return null;
		}
	}

	@Override
	PersonVo createVo(Person subject) {
		return PersonVo.createVo(subject);
	}

	@Override
	List<PersonVo> createListVo(List<Person> list) {
		return PersonVo.createListVo(list);
	}

	@Override
	public Person create(PersonVo person) {
		return new Person(person);
	}

	@Override
	void generateLog(Person person) {
		logger.info(person.generateLog("store"));
	}
	
	public PersonRepository getPersonRepository() {
		return personRepository;
	}
	
	public GenderFilterRepository getGenderRepository() {
		return genderRepository;
	}

	public TypeJobFilterRepository getTypeJobRepository() {
		return typeJobRepository;
	}

	public AgeGroupRepository getAgeGroupRepository() {
		return ageGroupRepository;
	}

	public IdeologyFilterRepository getIdeologyRepository() {
		return ideologyRepository;
	}

	public NexusManagementFilterRepository getNexusManagementRepository() {
		return nexusManagementRepository;
	}
	
	public InterestFilterRepository getInterestRepository() {
		return interestRepository;
	}
	
	public TypeParticipationFilterRepository getTypeParticipationRepository() {
		return typeParticipationRepository;
	}
	
	public TopicFilterRepository getTopicRepository() {
		return topicRepository;
	}

}
