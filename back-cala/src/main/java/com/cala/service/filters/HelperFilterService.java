package com.cala.service.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.filters.FilterDto;
import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.filters.IdeologyVo;
import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.TypeInstitutionVo;
import com.cala.model.vo.filters.TypeJobVo;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.service.global.DataTypeValidationService;
import com.cala.util.messages.MessageError;

@Service
public class HelperFilterService implements I_HelperFilterService{

	private static final String GENDER = "gender";
	private static final String IDEOLOGY = "ideology";
	private static final String INTEREST = "interest";
	private static final String NEXUS_MANAGEMENT = "nexus-management";
	private static final String TOPIC = "topic";
	private static final String TYPE_INSTITUTION = "type-institution";
	private static final String TYPE_JOB = "type-job";
	private static final String TYPE_PARTICIPATION = "type-participation";
	
	@Autowired
	private I_FilterDao<GenderVo> genderDao;
	
	@Autowired
	private I_FilterDao<IdeologyVo> IdeologyDao;
	
	@Autowired
	private I_FilterDao<InterestVo> InterestDao;
	
	@Autowired
	private I_FilterDao<NexusManagementVo> nexusManagementDao;
	
	@Autowired
	private I_FilterDao<TopicVo> topicDao;
	
	@Autowired
	private I_FilterDao<TypeInstitutionVo> typeInstitutionDao;
	
	@Autowired
	private I_FilterDao<TypeJobVo> typeJobDao;
	
	@Autowired
	private I_FilterDao<TypeParticipationVo> typeParticipationDao;
	
	public void validateDataTypeForFindById(Long id) throws AppDataTypeValidationException {
		DataTypeValidationService.checkId(id, MessageError.ERR_ID);		
	}
	
	public GenericFilterVo findByIdFilter(String type, Long id) throws AppBussinessValidationException {
		switch (type) {
		
			// -- 1 --
			case GENDER :
				//// business validations
				GenderVo genderVo = getGenderDao().findById(id);
				if (genderVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return genderVo;
			
			// -- 2 --
			case IDEOLOGY :
				//// business validations
				IdeologyVo ideologyVo = getIdeologyDao().findById(id);
				if (ideologyVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return ideologyVo;
			
			// -- 3 --
			case INTEREST :
				//// business validations
				InterestVo interestVo = getInterestDao().findById(id);
				if (interestVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return interestVo;
			
			// -- 4 --
			case NEXUS_MANAGEMENT :
				//// business validations
				NexusManagementVo nmVo = getNexusManagementDao().findById(id);
				if (nmVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return nmVo;
			
			// -- 5 --
			case TOPIC :
				//// business validations
				TopicVo topicVo = getTopicDao().findById(id);
				if (topicVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return topicVo;
			
			// -- 6 --
			case TYPE_INSTITUTION :
				//// business validations
				TypeInstitutionVo typeInstitutionVo = getTypeInstitutionDao().findById(id);
				if (typeInstitutionVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return typeInstitutionVo;	
			
			// -- 7 --
			case TYPE_JOB :
				//// business validations
				TypeJobVo typeJobVo = getTypeJobDao().findById(id);
				if (typeJobVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return typeJobVo;
				
			// -- 8 --
			case TYPE_PARTICIPATION :
				//// business validations
				TypeParticipationVo typeParticipationVo = getTypeParticipationDao().findById(id);
				if (typeParticipationVo == null) {
					throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
				}
				return typeParticipationVo;
					
		}// end switch
		return null;
	}
	
	public void validateDataTypeForRemove(Long id) throws AppDataTypeValidationException {
		DataTypeValidationService.checkId(id, MessageError.ERR_ID);		
	}

	public GenericFilterVo deleteFilter(String type, Long id) throws AppBussinessValidationException {
		switch (type) {
		
		// -- 1 --
		case GENDER :
			//// business validations
			GenderVo genderVo = getGenderDao().findById(id);
			if (genderVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getGenderDao().disable(id);
		
		// -- 2 --
		case IDEOLOGY :
			//// business validations
			IdeologyVo ideologyVo = getIdeologyDao().findById(id);
			if (ideologyVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getIdeologyDao().disable(id);
		
		// -- 3 --
		case INTEREST :
			//// business validations
			InterestVo interestVo = getInterestDao().findById(id);
			if (interestVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getInterestDao().disable(id);
		
		// -- 4 --
		case NEXUS_MANAGEMENT :
			//// business validations
			NexusManagementVo nmVo = getNexusManagementDao().findById(id);
			if (nmVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getNexusManagementDao().disable(id);
		
		// -- 5 --
		case TOPIC :
			//// business validations
			TopicVo topicVo = getTopicDao().findById(id);
			if (topicVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getTopicDao().disable(id);
		
		// -- 6 --
		case TYPE_INSTITUTION :
			//// business validations
			TypeInstitutionVo typeInstitutionVo = getTypeInstitutionDao().findById(id);
			if (typeInstitutionVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getTypeInstitutionDao().disable(id);	
		
		// -- 7 --
		case TYPE_JOB :
			//// business validations
			TypeJobVo typeJobVo = getTypeJobDao().findById(id);
			if (typeJobVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getTypeJobDao().disable(id);
			
		// -- 8 --
		case TYPE_PARTICIPATION :
			//// business validations
			TypeParticipationVo typeParticipationVo = getTypeParticipationDao().findById(id);
			if (typeParticipationVo == null) {
				throw new AppBussinessValidationException(MessageError.ERR_FILTER_NOT_EXIST);
			}
			// delete
			return getTypeParticipationDao().disable(id);
				
	}// end switch
	return null;
	}

	public void validateDataTypeForCreation(FilterDto filter) throws AppDataTypeValidationException {
		DataTypeValidationService.checkString(filter.getName(), MessageError.ERR_ENTER_NAME);
		DataTypeValidationService.checkNull(filter.isActive(), MessageError.ERR_ENTER_STATE);
		
		DataTypeValidationService.exceptionIf(filter.getName().length() >= 255, MessageError.ERR_ENTER_NAME_MAX);
		DataTypeValidationService.exceptionIf(filter.getName().length() < 2, MessageError.ERR_ENTER_NAME_MIN);		
	}

	public GenericFilterVo generateFilter(String type, FilterDto filterDto) throws AppBussinessValidationException {
		switch (type) {
		
			// -- 1 --
			case GENDER :
				//// business validations
				GenderVo genderVo = getGenderDao().findByName(filterDto.getName());
				if (genderVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				genderVo = GenderVo.createVo(filterDto.getName(), filterDto.isActive());
				return getGenderDao().store(genderVo);
			
			// -- 2 --
			case IDEOLOGY :
				//// business validations
				IdeologyVo ideologyVo = getIdeologyDao().findByName(filterDto.getName());
				if (ideologyVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				ideologyVo = IdeologyVo.createVo(filterDto.getName(), filterDto.isActive());
				return getIdeologyDao().store(ideologyVo);
			
			// -- 3 --
			case INTEREST :
				//// business validations
				InterestVo interestVo = getInterestDao().findByName(filterDto.getName());
				if (interestVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				interestVo = InterestVo.createVo(filterDto.getName(), filterDto.isActive());
				return getInterestDao().store(interestVo);
			
			// -- 4 --
			case NEXUS_MANAGEMENT :
				//// business validations
				NexusManagementVo nmVo = getNexusManagementDao().findByName(filterDto.getName());
				if (nmVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				nmVo = NexusManagementVo.createVo(filterDto.getName(), filterDto.isActive());
				return getNexusManagementDao().store(nmVo);
			
			// -- 5 --
			case TOPIC :
				//// business validations
				TopicVo topicVo = getTopicDao().findByName(filterDto.getName());
				if (topicVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				topicVo = TopicVo.createVo(filterDto.getName(), filterDto.isActive());
				return getTopicDao().store(topicVo);
			
			// -- 6 --
			case TYPE_INSTITUTION :
				//// business validations
				TypeInstitutionVo typeInstitutionVo = getTypeInstitutionDao().findByName(filterDto.getName());
				if (typeInstitutionVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				typeInstitutionVo = TypeInstitutionVo.createVo(filterDto.getName(), filterDto.isActive());
				return getTypeInstitutionDao().store(typeInstitutionVo);		
			
			// -- 7 --
			case TYPE_JOB :
				//// business validations
				TypeJobVo typeJobVo = getTypeJobDao().findByName(filterDto.getName());
				if (typeJobVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				typeJobVo = TypeJobVo.createVo(filterDto.getName(), filterDto.isActive());
				return getTypeJobDao().store(typeJobVo);
				
			// -- 8 --
			case TYPE_PARTICIPATION :
				//// business validations
				TypeParticipationVo typeParticipationVo = getTypeParticipationDao().findByName(filterDto.getName());
				if (typeParticipationVo != null) {
					throw new AppBussinessValidationException(MessageError.ERR_NAME_NOT_UNIQUE);
				}
				// store
				typeParticipationVo = TypeParticipationVo.createVo(filterDto.getName(), filterDto.isActive());
				return getTypeParticipationDao().store(typeParticipationVo);
					
		}// end switch
		return null;
	}

	public I_FilterDao<GenderVo> getGenderDao() {
		return genderDao;
	}

	public I_FilterDao<IdeologyVo> getIdeologyDao() {
		return IdeologyDao;
	}

	public I_FilterDao<InterestVo> getInterestDao() {
		return InterestDao;
	}

	public I_FilterDao<NexusManagementVo> getNexusManagementDao() {
		return nexusManagementDao;
	}

	public I_FilterDao<TopicVo> getTopicDao() {
		return topicDao;
	}

	public I_FilterDao<TypeInstitutionVo> getTypeInstitutionDao() {
		return typeInstitutionDao;
	}

	public I_FilterDao<TypeJobVo> getTypeJobDao() {
		return typeJobDao;
	}

	public I_FilterDao<TypeParticipationVo> getTypeParticipationDao() {
		return typeParticipationDao;
	}

}
