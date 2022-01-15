package com.cala.dao.subjects;

import java.util.List;

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

public interface I_PersonDao{
	public List<PersonVo> findAll(SearchPersonFilterVo filter, PaginationVo pagination);
	public PersonVo setTypeJob(Long id, TypeJobVo type);
	public PersonVo setAgeGroup(Long id, AgeGroupVo config);
	public PersonVo setGender(Long id, GenderVo gender);
	public PersonVo setIdeologies(Long id, List<IdeologyVo> filters);
	public PersonVo setTopics(Long id, List<TopicVo> filters);
	public PersonVo setTypeParticipations(Long id, List<TypeParticipationVo> filters);
	public PersonVo setInterests(Long id, List<InterestVo> filters);
	public PersonVo setNexusManagement(Long id, List<NexusManagementVo> filters);
	public PersonVo setDescription (Long id, List<DescriptionVo> descriptions);
	public PersonVo update(PersonVo person);
}
