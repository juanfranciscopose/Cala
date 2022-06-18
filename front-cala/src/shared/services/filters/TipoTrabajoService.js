import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllTipoTrabajo = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/type-job/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getTipoTrabajoOptions = async () => {
    return listAllTipoTrabajo()
}

export default {getTipoTrabajoOptions};

/*const getTipoTrabajoOptions = [
    {
        value: 'PUB', 
        label: 'Público'
    },
    {
        value: 'PRI', 
        label: 'Privado'
    },
    {
        value: 'MON',
        label: 'Monotributista'
    },
    {
        value: 'DES',
        label: 'Desempleado'
    },
    {
        value: 'EST',
        label: 'Estudiante'
    }
];

export default getTipoTrabajoOptions*/