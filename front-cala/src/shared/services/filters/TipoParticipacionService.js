import axios from 'axios';
import {apiConstant} from './../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const listAllTipoParticipacion = async () => {
  try {
    const response = axios.get(
      `${apiConstant.Filtros}/type-participation/list?size=100&page=0`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

const getTipoParticipacionOptions = async () => {
    return listAllTipoParticipacion()
}

export default {getTipoParticipacionOptions};

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


/*const getTipoParticipacionOptions = [
    {
        value: 'TIMB', 
        label: 'Timbreo'
    },
    {
        value: 'CONC', 
        label: 'Concejo'
    },
    {
        value: 'CONO',
        label: 'Conocido'
    },
    {
        value: 'KOLI',
        label: 'Kolina'
    },
    {
        value: 'COLI',
        label: 'Colibri'
    }
];

export default getTipoParticipacionOptions*/