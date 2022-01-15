package com.cala.dao.subjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cala.model.entities.subjects.Subject;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.model.vo.subjects.SubjectVo;
import com.cala.repository.filters.TopicFilterRepository;
import com.cala.repository.subjects.SubjectRepository;

public abstract class GenericSubjectDao<T extends SubjectVo, K extends Subject> implements I_GenericSubjectDao<T>{

	@Autowired
	private SubjectRepository<K> repository;
	
	@Autowired
	private TopicFilterRepository topicRepository;
	
	public SubjectRepository<K> getRepository() {
		return repository;
	}
	
	public TopicFilterRepository getTopicRepository() {
		return topicRepository;
	}
	
	abstract T createVo(K subject);
	abstract List<T> createListVo(List<K> list);
	abstract K create(T subject);
	abstract void generateLog(K subject);
	
	private List<T> getAllWithHighlight(boolean highlight, PageRequest pageRequest){
		Page<K> subjects = getRepository().findByHighlight(highlight, pageRequest);
		return (!subjects.isEmpty() ? createListVo(subjects.getContent()) : null);
	}
	
	@Override
	public List<T> getAllHighlight(PaginationVo pagination) {
		PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
		return getAllWithHighlight(true, pageRequest);
	}
	
	@Override
	public T store(T subject) {
		K s = create(subject);
		s = getRepository().save(s);
		generateLog(s);
		return createVo(s);
	}
}
