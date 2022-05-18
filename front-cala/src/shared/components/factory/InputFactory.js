import React from "react"
import TYPE_FIELDS from './../../../constants/typeFields'
import MyTextField from "./../fields/MyTextField";
import MySelect from "./../fields/MySelect";
import {ErrorMessage} from 'formik'
import { Grid } from '@mui/material';

const InputFactory = ({field, xs}) => {
  
  const getInput = () => {
    if (TYPE_FIELDS.some(type => type === field.type)){
      switch (field.type) {
        case 'Text':
          return(
            <MyTextField
              label={field.label}
              name={field.name}
            />
          );
        case 'Select':
          return(
            <MySelect
              label={field.label}
              name={field.name}
              options ={field.options}
              allowEmpty={true}
            />
          );
        case 'Numeric':
          console.log('NUMERIC');
          break;
        case 'Date':
          console.log('DATE');
          break;
        case 'Boolean':
          console.log('BOOLEAN');
          break;
        default:
          console.log('Error en type field',field.type);
          break;
      }
    }
  } 

  return (
      <React.Fragment>
          <Grid item xs={xs}>
              {getInput()}
              <ErrorMessage name={field.name}>
                {msg => <span style={{color: 'red'}}>{msg}</span>}
              </ErrorMessage>
          </Grid>
      </React.Fragment>
  )
}

export default InputFactory
