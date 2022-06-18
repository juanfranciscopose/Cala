import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllTematica = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/topic/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getTematicaOptions = async () => {
    return listAllTematica()
}

export default {getTematicaOptions}

/*const getTematicaOptions = [
    {
        value: 'SOC', 
        label: 'Social'
    },
    {
        value: 'POL', 
        label: 'Política'
    },
    {
        value: 'ESP',
        label: 'Espacio Público'
    },
    {
        value: 'SEG',
        label: 'Seguridad'
    },
    {
        value: 'IND',
        label: 'Industrias'
    }
];

export default getTematicaOptions*/