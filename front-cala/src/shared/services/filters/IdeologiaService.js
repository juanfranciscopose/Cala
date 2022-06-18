import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllIdeologia = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/ideology/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getIdeologiaOptions = async () => {
    return listAllIdeologia()
}

export default {getIdeologiaOptions};

/*const getIdeologiaOptions = [
    {
        value: 'KIS', 
        label: 'Kirchnerismo'
    },
    {
        value: 'MAC', 
        label: 'Macrista'
    },
    {
        value: 'RAD',
        label: 'Radical'
    },
    {
        value: 'DER',
        label: 'Derecha'
    },
    {
        value: 'TRO',
        label: 'Trosko'
    }
];

export default getIdeologiaOptions*/