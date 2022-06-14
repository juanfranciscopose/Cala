import React from "react"
import TYPE_FIELDS from './../../../constants/typeFields'
import MyTextField from "./../fields/MyTextField"
import MySelect from "./../fields/MySelect"
import {ErrorMessage} from 'formik'
import { Grid } from '@mui/material'
import MyCheckbox from "./../fields/MyCheckbox"
import MyDatePicker from "./../fields/MyDatePicker"
import MyMultiSelect from "./../fields/MyMultiSelect"

const InputFactory = ({field, xs, disableInput=false}) => {
  
  const getInput = () => {
    if (TYPE_FIELDS.some(type => type === field.type)){
      switch (field.type) {
        case 'Text':
          return(
            <MyTextField
              label={field.label}
              name={field.name}
              disabled={disableInput}
            />
          );
        case 'Select':
          return(
            <MySelect
              label={field.label}
              name={field.name}
              options ={field.options}
              allowEmpty={true}
              disabled={disableInput}
            />
          );
        case 'Date':
          return(
            <MyDatePicker
              label={field.label}
              name={field.name}
              disabled={disableInput}
            />
          );
        case 'Checkbox':
          return(
            <MyCheckbox
              label={field.label}
              name={field.name}
              disabled={disableInput}
            />
          );
        case 'MultiSelect':
          return(
            <MyMultiSelect
              label={field.label}
              name={field.name}
              options ={field.options}
              disabled={disableInput}
            />
          );
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
