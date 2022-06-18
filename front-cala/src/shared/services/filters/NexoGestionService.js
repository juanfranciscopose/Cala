import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllNexoGestion = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/nexus-management/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getNexoGestionOptions = async () => {
    return listAllNexoGestion()
}

export default {getNexoGestionOptions}

/*const getNexoGestionOptions = [
    {
        value: 'COM', 
        label: 'Comedor'
    },
    {
        value: 'TAR', 
        label: 'Tarifazo'
    },
    {
        value: 'CLT',
        label: 'Cupo Laboral Trans'
    },
    {
        value: 'CAS',
        label: 'Camaras Seguridad'
    },
    {
        value: 'COO',
        label: 'Cooperativa'
    },
    {
        value: 'LOT',
        label: 'Loteo'
    }
];

export default getNexoGestionOptions*/