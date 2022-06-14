import React from 'react'
import * as Yup from 'yup'
import DatosPersonales from './secciones/DatosPersonales'
import ModalABM from '../../../../shared/components/dialogs/MyFormModal'

let buildValidationSchema = () => {
  let validationSchema = {}
  DatosPersonales.arrayDatosPersonales.forEach(campo => validationSchema[campo.name] = campo.validation)
  console.log('validationSchema', validationSchema)
  return Yup.object().shape(validationSchema)
} 

const FormularioPersona = ({ view=true, open, close, edit=false, initialValues={}, onSubmitForm }) => {

  const TITLE = !edit ? 'Nueva Persona' : 'Modificar Persona'

  return (
    <React.Fragment>
      <ModalABM 
        titulo={view ? TITLE : 'Ver Persona'} 
        validationSchema={buildValidationSchema} 
        initialValues={initialValues}
        open={open}
        close={close}
        edit={edit}
        view={view}
        onSubmitForm={onSubmitForm}
        >
          <DatosPersonales.componentDatosPersonales/><br/>
          {/*Datos Laborales*/}
          {/*<DatosLabores/>
          <RedesSociales/>
          <Filtro/>
          <Observaciones/>*/}
      </ModalABM>
    </React.Fragment>
  )
}

export default FormularioPersona
