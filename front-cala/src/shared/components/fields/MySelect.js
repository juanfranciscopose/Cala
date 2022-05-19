import React from 'react';
import { useField, useFormikContext } from 'formik';
import TextField from '@mui/material/TextField'
import MenuItem from '@mui/material/MenuItem'

const MySelect = ({
    name,
    label,
    options,
    disabled,
    hideId,
    customChange,
    needEvento,
    allowEmpty = false,
    ...props
}) => {
    const [field, meta] = useField(name);
    const { setFieldValue } = useFormikContext();

    const onChangeValue = (event) => {
        if (!disabled) {
          //field.onChange(event.target.value);
          setFieldValue(name, event.target.value);
          if (customChange) needEvento ? customChange(event) : customChange();
        }
    }
    
    const getDescription = (item) => {
        return hideId || item.value === -1
            ? item.label
            : `${item.value} - ${item.label}`
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
            fullWidth>
            <MenuItem disabled={!allowEmpty} value=''><em>None</em></MenuItem>
            {options && options.map((item, key) =>
                <MenuItem key={key} value={item.value}>{getDescription(item)}</MenuItem>
            )}
        </TextField>
    );
}

export default MySelect;