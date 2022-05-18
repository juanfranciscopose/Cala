import { Add } from '@mui/icons-material';
import { Fab, Tooltip } from '@mui/material';
import React , {useState} from 'react';
import FormularioNuevaPersona from './FormularioPersona/FormularioPersona';

const TITLE = 'ABMPersonas';

const ABMPersonas = () => {
  const [open, setOpen] = useState(false);

  const cerrar = () => {
    setOpen(false);
  }

  return (
    <React.Fragment>
      {/* 0-titulo */}
      {/* botones 3-editar(on select), 4-borrar(on select), 3-ver(on select), 1-nuevo(siempre) */}
      {/* 5-filtros */}
      {/* 2-tabla */}
      {/* 6-paginacion */}
      <div>
          {TITLE}
          <Tooltip title="Nueva Persona">
            <Fab
             ariant="extended"
             size="medium"
             color="secondary"
             onClick={() => {
               console.log("click!");
               setOpen(true);
             }} 
            >
              <Add/>
            </Fab>
          </Tooltip>
      </div>
      <FormularioNuevaPersona open={open} close={cerrar}/>
    </React.Fragment>
  )
};

export default ABMPersonas;
