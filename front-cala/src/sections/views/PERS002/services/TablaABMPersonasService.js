import axios from 'axios';
import {apiConstant} from './../../../../constants/apiConstant';

const config = {
  headers: { 'Content-Type': 'application/json; charset=utf-8'},
  withCredentials: false
};

const getTable = async () => {
  try {
    const response = axios.get(
      `${apiConstant.ABMPersonas}/listAll?page=0&size=25`,
      {},
      config
    );
    return response
  } catch (error) {
    throw error;
  }
};

export default { getTable };
