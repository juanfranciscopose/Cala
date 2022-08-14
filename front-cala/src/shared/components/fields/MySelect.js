import React from 'react';
import { useField, useFormikContext } from 'formik';
import TextField from '@mui/material/TextField'
import MenuItem from '@mui/material/MenuItem'
import Service from './../../services/FilterService'

const MySelect = ({
    name,
    label,
    options,
    disabled,
    customChange,
    needEvento,
    allowEmpty = false,
    mapeoProps,
    filter,
    needFilter=false,
    hideDesc=false,
    ...props
}) => {
    const [field, meta] = useField(name);
    const { setFieldValue } = useFormikContext();
    const [isBussy, setIsBussy] = React.useState(true)
    const [listado, setListado] = React.useState([])

    const onChangeValue = (event) => {
        if (!disabled) {
          //field.onChange(event.target.value);
          setFieldValue(name, event.target.value);
          if (customChange) needEvento ? customChange(event) : customChange();
        }
    }

    React.useEffect(() => {
      let isMounted = true
      if (isMounted){
        if (!needFilter){
          setListado(options)
          setIsBussy(false)
        }else{
          Service.execute(filter).then(response => {
            //console.log(response);
            const list = response.data.json
            setListado(list)
            setIsBussy(false)
          })
        }
      }
      return () => {isMounted = false}
    }, [])

    const getDescription = (item) => {
        return hideDesc || item.value === -1
            ? item[mapeoProps.desc]
            : `${item[mapeoProps.value]} - ${item[mapeoProps.desc]}`
    }

    return (
        <TextField
          {...field}
          {...props}
          name= {name}
          select
          disabled={disabled}
          label={label}
          value={field.value === undefined ? '' : field.value}
          onChange={event => onChangeValue(event)}
          error={meta.error && meta.touched}
          InputLabelProps={{ shrink: true }}
          fullWidth
        >
            <MenuItem disabled={!allowEmpty} value=''><em>None</em></MenuItem>
            {isBussy ? [] : listado && listado.map((item, key) =>
            <MenuItem 
              key={key} 
              value={item[mapeoProps.value]}
            >
                {getDescription(item)}
            </MenuItem>
          )}
        </TextField>
    );
}

export default MySelect;