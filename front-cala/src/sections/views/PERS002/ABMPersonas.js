import { Add, Edit, Album, NotInterested } from '@mui/icons-material'
import { ButtonGroup, Fab, Tooltip } from '@mui/material'
import React , {useState} from 'react'
import MyABMTable from '../../../shared/components/tables/MyABMTable'
import FormularioPersona from './FormularioPersona/FormularioPersona'
import HeaderABMPersona from './HeaderABMPersona/HeaderABMPersona'
import { Button, Grid, Typography, Stack  } from '@mui/material'
import { Formik, Form } from 'formik';
import MyIconButton from '../../../shared/components/buttons/MyIconButton'
import MyFabButton from '../../../shared/components/buttons/MyFabButton'

const TITLE = 'ABM Personas'

const buildInitialValues = () => {
  let initialValues = {}
  HeaderABMPersona.arrayFiltros.forEach(campo => initialValues[campo.name] = campo.initialValue)
  console.log('initialValues', initialValues)
  return initialValues
}

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

//test edit view
const initPersona = {
  nombre: 'vitto',
  apellido: 'pose',
  genero: 'M',
  tieneHijos: false
}

const ABMPersonas = () => {
  //modals states
  const [openNew, setOpenNew] = useState(false)
  const [openEdit, setOpenEdit] = useState(false)
  const [openView, setOpenView] = useState(false)
  const [showBtnViewUpdate, setShowBtnViewUpdate] = useState(false)
  const [showBtnDelete, setShowBtnVDelete] = useState(false)
  const [selectedPerson, setSelectedPerson] = useState(initPersona)

  const cerrarNew = () => {
    setOpenNew(false)
  }

  const cerrarEdit = () => {
    setOpenEdit(false)
  }

  const cerrarView = () => {
    setOpenView(false)
  }

  const onSelectedRows = (newSelection) => {
    console.log(newSelection)
    if (newSelection.length === 1){
      setShowBtnViewUpdate(true)
      //setSelectedPerson(newSelection[0])
      //console.log(selectedPerson)
    }else{
      setShowBtnViewUpdate(false)
      //setSelectedPerson({})
    }
    if (newSelection.length > 0 ) {
      setShowBtnVDelete(true)
    }else{
      setShowBtnVDelete(false)
    }
  }

  return (
    <React.Fragment>
      {/* 0-titulo */}
      {/* botones 3-editar(on select), 4-borrar(on select), 3-ver(on select), 1-nuevo(siempre) */}
      {/* 5-filtros */}
      {/* 2-tabla */}
      {/* 6-paginacion */}

      <Grid container justifyContent="flex-start" alignItems="center">
        <Grid item xs={3} mt={3} mb={1} p={1}>
          <Typography variant="h5" >
            {TITLE}
          </Typography>
        </Grid>
      </Grid>

      <Grid container justifyContent="center" alignItems="center">
        <Grid item xs={10} m={2} p={1}>
          <Formik
            enableReinitialize
            //validationSchema={validationSchema}
            initialValues={buildInitialValues()}
            onSubmit={values => console.log(values)}
          >
            {({ values, errors}) => 
              <Form>
                <HeaderABMPersona.componentHeaderABMPersona/>
              </Form>
            }
          </Formik>
        </Grid>
      </Grid>

      <Grid container p={1} direction="row" m={1} justifyContent="flex-end" alignItems="center">
        <Grid item xs={2} m={1} p={1}>
          
        </Grid>
          
          <Grid item xs={2} >
            <ButtonGroup variant="outlined" >
                {!showBtnViewUpdate ? '' : (
                <> 
                  <MyIconButton
                    customClick={() => {
                      console.log("click - Ver Persona")
                      setOpenView(true)
                    }}
                    tooltip={"Ver Persona"}
                    icon={'view'}
                  />
                  <MyIconButton
                    customClick={() => {
                      console.log("click - editar persona")
                      setOpenEdit(true)
                    }}
                    tooltip={"Editar Persona"}
                    icon={'edit'}
                  />
                </>
                )}
                {!showBtnDelete ? '' : (
                  <MyIconButton
                    customClick={() => {
                      console.log("click - Eliminar Persona")
                    }}
                    tooltip={"Eliminar Persona"}
                    icon={'delete'}
                  />
                )}
                <MyFabButton
                  customClick={() => {
                    console.log("click - nueva persona")
                    setOpenNew(true)
                  }}
                  color={'error'}
                  tooltip={"Nueva Persona"}
                  icon={'add'}
                />
              </ButtonGroup>
          </Grid>  
      </Grid>

      <Grid container p={2} m={1} alignItems="center" justifyContent="center">
        <Grid item xs={12} >
          <MyABMTable 
            columns={HEADERS_TABLA} 
            rows={HARDCODE_TABLA_VALUES} 
            pageSize={25} 
            height={'max'}
            customSelectionChange={onSelectedRows}
          />
        </Grid>
      </Grid>
      <FormularioPersona open={openNew} close={cerrarNew}/>
      {!showBtnViewUpdate ? '' : (
        <>
          <FormularioPersona open={openEdit} close={cerrarEdit} edit={true} initialValues={selectedPerson}/>
          <FormularioPersona open={openView} close={cerrarView} view={false} initialValues={selectedPerson}/>
        </>
      )}
    </React.Fragment>
  )
};

export default ABMPersonas;
