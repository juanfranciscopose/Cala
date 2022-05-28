import { Add, Edit } from '@mui/icons-material';
import { Fab, Tooltip } from '@mui/material';
import React , {useState} from 'react';
import MyABMTable from '../../../shared/components/tables/MyABMTable';
import FormularioPersona from './FormularioPersona/FormularioPersona';

const TITLE = 'ABMPersonas';

const ABMPersonas = () => {
  //modals states
  const [openNew, setOpenNew] = useState(false);
  const [openEdit, setOpenEdit] = useState(false);

  //test edit
  const initPersona = {
    nombre: 'vitto',
    apellido: 'pose',
    genero: 'M',
    tieneHijos: false
  }

  const cerrarNew = () => {
    setOpenNew(false);
  }

  const cerrarEdit = () => {
    setOpenEdit(false);
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

          <Tooltip title="Editar Persona">
            <Fab
             ariant="extended"
             size="medium"
             color="secondary"
             onClick={() => {
               console.log("click - editar persona");
               setOpenEdit(true);
             }} 
            >
              <Edit/>
            </Fab>
          </Tooltip>
          <MyABMTable/>
          <Tooltip title="Nueva Persona">
            <Fab
             ariant="extended"
             size="medium"
             color="secondary"
             onClick={() => {
               console.log("click - nueva persona");
               setOpenNew(true);
             }} 
            >
              <Add/>
            </Fab>
          </Tooltip>

      </div>
      <FormularioPersona open={openNew} close={cerrarNew}/>
      <FormularioPersona open={openEdit} close={cerrarEdit} edit={true} initialValues={initPersona}/>
    </React.Fragment>
  )
};

export default ABMPersonas;
