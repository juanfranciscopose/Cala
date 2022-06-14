import axios from 'axios';
import {apiConstant} from './../../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const persistirPersona = async (persona) => {
  try {
    const response = axios.post(
      `${apiConstant.ABMPersonas}/create`,
      persona,
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const updatePersona = async (persona) => {
    try {
      const response = axios.put(
        `${apiConstant.ABMPersonas}/updatePerson`,
        persona,
        config
      );
      return response
    } catch (error) {
      throw error;
    }
  };

const altaPersona = (persona) => {
    return persistirPersona(persona)
} 

const editarPersona = (persona) => {
    return updatePersona(persona)
} 
export default { altaPersona, editarPersona };
