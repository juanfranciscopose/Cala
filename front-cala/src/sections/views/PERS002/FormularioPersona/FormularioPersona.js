import { 
  Button, 
  Dialog, 
  DialogActions, 
  DialogContent,
  DialogTitle,
  IconButton 
} from '@mui/material';
import { Edit, Save } from '@mui/icons-material';
import { Formik, Form } from 'formik';
import { makeStyles } from '@mui/styles';
import CloseIcon from '@mui/icons-material/Close';
import React from 'react';
import * as Yup from 'yup';

import DatosPersonales from './secciones/DatosPersonales';

const useStyle = makeStyles( (theme) => ({
  dialogTitle: {
      margin: 0,
      padding: '16px',
  },
  closeButton: {
      position: 'absolute',
      right: '8px',
      top: '8px',
      color: 'grey',
  },
  button: {
    margin: '8px',
  },
  rightIcon: {
    marginRight: '8px',
  }
}));

const TITLE = 'Formulario Nueva Persona';

let builtValidationSchema = () => {
  let validationSchema = {};
  DatosPersonales.arrayDatosPersonales.forEach(campo => validationSchema[campo.name] = campo.validation)
  console.log('validationSchema', validationSchema);
  return Yup.object().shape(validationSchema);
} 

const FormularioNuevaPersona = ({open, close, view=false, edit=false}) => {
  const classes = useStyle();
 
  return (
    <React.Fragment>
      <Dialog
        open={open}
        aria-labelledby="form-dialog-title"
        maxWidth="md"
        fullWidth
      >
        <DialogTitle id="form-dialog-title" onClose={close} className={classes.dialogTitle} >
          {TITLE}
          {close ? (
            <IconButton aria-label='close' className={classes.closeButton} onClick={close}>
              <CloseIcon />
            </IconButton>
            ) : ''} 
        </DialogTitle>
        <DialogContent>
          <Formik
            //initialValues={fields}
            enableReinitialize
            onSubmit={(values) => {
              console.log(values);
              console.log("submit!");
            }}
            validationSchema={builtValidationSchema()}
          >
            {({ values, errors}) => (
              <Form >
                {/*<Grid container alignItems="center" justify="center" spacing={2}>*/}
                  <DatosPersonales.componentDatosPersonales/><br/>
                  {/*Datos Laborales*/}
                  {/*<DatosLabores/>
                  <RedesSociales/>
                  <Filtro/>
                  <Observaciones/>*/}
                {/*</Grid>*/}
                <DialogActions>
                  <Button
                    color="secondary"
                    className={classes.button}
                    onClick={close}
                  >
                    Cancelar
                  </Button>
                  {!view && (
                    <Button
                      type="submit"
                      variant="contained"
                      color="secondary"
                      className={classes.button}
                    >
                      {edit ? ( 
                        <React.Fragment>
                          <Edit className={classes.rightIcon} />
                          Modificar
                        </React.Fragment>
                      ) : (
                        <React.Fragment>
                          <Save className={classes.rightIcon} />
                          Guardar
                        </React.Fragment>
                      )}
                    </Button>
                  )}
                </DialogActions>
              </Form>
            )}
          </Formik>
        </DialogContent>
      </Dialog>
    </React.Fragment>
  )
};

export default FormularioNuevaPersona;
