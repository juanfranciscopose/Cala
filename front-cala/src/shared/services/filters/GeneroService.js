import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllGenero = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/gender/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getGeneroOptions = async () => {
    return listAllGenero()
}

export default {getGeneroOptions};

/*const getGeneroOptions = [
    {
        value: 'M', 
        label: 'Masculino'
    },
    {
        value: 'F', 
        label: 'Femenino'
    },
    {
        value: 'O',
        label: 'Otro'
    }
];

export default getGeneroOptions*/