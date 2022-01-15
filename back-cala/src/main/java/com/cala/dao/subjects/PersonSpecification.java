package com.cala.dao.subjects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.cala.model.entities.subjects.Person;
import com.cala.model.vo.searches.SearchPersonFilterVo;

public class PersonSpecification {
	
    public static Specification<Person> filter(SearchPersonFilterVo filter) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            //name
            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                        "%" + filter.getName().toLowerCase() + "%"));
            }
            //surname
            if (filter.getSurname() != null && !filter.getSurname().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("surname")),
                        "%" + filter.getSurname().toLowerCase() + "%"));
            }
            //kids
            if(filter.isKids() != null ) {
            	predicates.add(criteriaBuilder.equal(root.get("kids"), filter.isKids().booleanValue()));
            }
            //disability
            if(filter.isDisability() != null ) {
            	predicates.add(criteriaBuilder.equal(root.get("disability"), filter.isDisability().booleanValue()));
            }
            //birthday
            if (filter.getBirthdayFrom() != null && filter.getBirthdayUntil() != null) {
            	//TODO: birthday criteria
            }
            //gender
            if (filter.getGender() != null) {
        	    predicates.add(criteriaBuilder.equal(root.get("gender"), filter.getGender()));
            }
            //type job
            if (filter.getJob() != null) {
        	    predicates.add(criteriaBuilder.equal(root.get("typeJob"), filter.getJob()));
            }
            //age group
            if (filter.getGroup() != null) {
        	    predicates.add(criteriaBuilder.equal(root.get("ageGroup"), filter.getGroup()));
            }
            //ideologies
            if (filter.getIdeologies() != null && !filter.getIdeologies().isEmpty()) {
        	    filter.getIdeologies().forEach( id -> predicates.add(criteriaBuilder.isMember(id, root.get("ideologies"))) );
            }
            //topics
            if (filter.getTopics() != null && !filter.getTopics().isEmpty()) {
        	    filter.getTopics().forEach( topic -> predicates.add(criteriaBuilder.isMember(topic, root.get("topics"))) );
            }
            //type participation
            if (filter.getTypeParticipation() != null && !filter.getTypeParticipation().isEmpty()) {
        	    filter.getTypeParticipation().forEach( type -> predicates.add(criteriaBuilder.isMember(type, root.get("typeParticipation"))) );
            }
            //interests
            if (filter.getInterests() != null && !filter.getInterests().isEmpty()) {
        	    filter.getInterests().forEach( interest -> predicates.add(criteriaBuilder.isMember(interest, root.get("interests"))) );
            }
            //nexus management
            if (filter.getNexusManagement() != null && !filter.getNexusManagement().isEmpty()) {
        	    filter.getNexusManagement().forEach( nexus -> predicates.add(criteriaBuilder.isMember(nexus, root.get("nexusManagement"))) );
            }
            
            query.distinct(true);
            query.orderBy(criteriaBuilder.desc(root.get("id")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
