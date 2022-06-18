import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllInterest = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/interest/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getInteresOptions = async () => {
    return listAllInterest()
}

export default {getInteresOptions};

// *** HARDCODE ***
/*const getInteresOptions = [
    {
        code: 'HEST', 
        name: 'Hincha Estudiantes'
    },
    {
        code: 'HGIM', 
        name: 'Hincha Gimnasia'
    },
    {
        code: 'MASC',
        name: 'Mascotas'
    },
    {
        code: 'FUTA',
        name: 'Futbol Amateur'
    },
    {
        code: 'FUTL',
        name: 'Liga Amateur Platense'
    }
];

export default getInteresOptions*/