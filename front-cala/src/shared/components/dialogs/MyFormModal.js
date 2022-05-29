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
import React, { Fragment } from 'react';

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

const ModalABM = ({
  validationSchema,
  initialValues,
  titulo,
  children,
  open, 
  close, 
  view=true, 
  edit=false,
  onSubmitForm
}) => {
  const classes = useStyle();

  const handleSubmitFormik = (values) => {
    console.log("values formulario", values);
    console.log("submit!");
    if (onSubmitForm){
      onSubmitForm(values)
    }
    close()
  }

  return (
    <Fragment>
      <Dialog
        open={open}
        aria-labelledby="form-dialog-title"
        maxWidth="md"
        fullWidth
      >
        <DialogTitle id="form-dialog-title" onClose={close} className={classes.dialogTitle} >
          {titulo}
          {close ? (
            <IconButton aria-label='close' className={classes.closeButton} onClick={close}>
              <CloseIcon />
            </IconButton>
            ) : ''} 
        </DialogTitle>
          <DialogContent>
          <Formik
            enableReinitialize
            validationSchema={validationSchema}
            initialValues={initialValues}
            onSubmit={values => handleSubmitFormik(values)}
          >
            {({ values, errors}) => 
              <Form>
                {children}
                <DialogActions>
                  <Button
                    color="secondary"
                    className={classes.button}
                    onClick={close}
                  >
                    Cancelar
                  </Button>
                  {view ? (
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
                  ): '' }
                </DialogActions>
              </Form>
            }
          </Formik>
        </DialogContent>
      </Dialog>
    </Fragment>
  );
};

export default ModalABM;
