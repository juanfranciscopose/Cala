import React from "react"
import InteresService from './filters/InteresService'

const execute = (filter) => {
      switch (filter) {
        case 'interest':
          return InteresService.getInteresOptions()
        /*case 'Select':
          return(
            <MySelect
              label={field.label}
              name={field.name}
              options ={field.options}
              allowEmpty={true}
              disabled={disableInput}
              mapeoProps={field.mapeoProps}
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
              mapeoProps={field.mapeoProps}
              filter={field.filter}
              needFilter={field.needFilter}
            />
          );*/
        default:
          console.log('Error en filter');
          break;
      }
    }

    export default { execute };