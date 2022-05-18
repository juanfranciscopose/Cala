import React from 'react';
import Configuracion from '../sections/views/CONF001/Configuracion';
import ABMPersonas from '../sections/views/PERS002/ABMPersonas';

// Pantallas en Desarrollo
export const desarrollo = [
  { labelMenu: 'Configuración', path: '/CONF001', element: <Configuracion /> },
  { labelMenu: 'Personas', path: '/PERS002', element: <ABMPersonas /> }
];
