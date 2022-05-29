import { Add, Edit, Album } from '@mui/icons-material';
import { Fab, Tooltip } from '@mui/material';
import React , {useState} from 'react';
import MyABMTable from '../../../shared/components/tables/MyABMTable';
import FormularioPersona from './FormularioPersona/FormularioPersona';

const TITLE = 'ABMPersonas';

const HEADERS_TABLA = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'firstName', headerName: 'First name', width: 130 },
  { field: 'lastName', headerName: 'Last name', width: 130 },
  { field: 'age', headerName: 'Age', type: 'number', width: 90 },
  {
    field: 'fullName',
    headerName: 'Full name',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
    valueGetter: (params) =>
      `${params.row.firstName || ''} ${params.row.lastName || ''}`,
  },
];

const HARDCODE_TABLA_VALUES = [
  { id: 1, lastName: 'Snow', firstName: 'Jon', age: 35 },
  { id: 2, lastName: 'Lannister', firstName: 'Cersei', age: 42 },
  { id: 3, lastName: 'Lannister', firstName: 'Jaime', age: 45 },
  { id: 4, lastName: 'Stark', firstName: 'Arya', age: 16 },
  { id: 5, lastName: 'Targaryen', firstName: 'Daenerys', age: null },
  { id: 6, lastName: 'Melisandre', firstName: null, age: 150 },
  { id: 7, lastName: 'Clifford', firstName: 'Ferrara', age: 44 },
  { id: 8, lastName: 'Frances', firstName: 'Rossini', age: 36 },
  { id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65 },
];

const ABMPersonas = () => {
  //modals states
  const [openNew, setOpenNew] = useState(false);
  const [openEdit, setOpenEdit] = useState(false);
  const [openView, setOpenView] = useState(false);
  const [showBtnView, setShowBtnView] = useState(false);

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

  const cerrarView = () => {
    setOpenView(false);
  }

  const onSelectedRows = (newSelection) => {
    console.log(newSelection)
    if (newSelection.length === 1){
      setShowBtnView(true)
      //setPersona a ver
      //grisar inputs modal
    }else{
      setShowBtnView(false)
    }
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
          {!showBtnView ? '' :(
          <Tooltip title="Ver Persona">
            <Fab
             ariant="extended"
             size="medium"
             color="secondary"
             onClick={() => {
               console.log("click - ver persona");
               setOpenView(true);
             }} 
            >
              <Album/>
            </Fab>
          </Tooltip>)}

          <MyABMTable 
            columns={HEADERS_TABLA} 
            rows={HARDCODE_TABLA_VALUES} 
            pageSize={25} 
            height={'max'}
            customSelectionChange={onSelectedRows}
          />
          
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
      {!showBtnView ? '' : <FormularioPersona open={openView} close={cerrarView} edit={true} initialValues={initPersona}/>}
    </React.Fragment>
  )
};

export default ABMPersonas;
