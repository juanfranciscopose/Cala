import React from 'react';
import { useField, useFormikContext } from 'formik';
import Typography from '@mui/material/Typography';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

export default function MyCheckbox({
    name,
    label,
    disabled,
    customChange,
    checklistValue,
    ...props
}) {
    const [field] = useField(name);
    const { setFieldValue } = useFormikContext();

    const onChangeValue = event => {
        if (!disabled) {
            setFieldValue(name, event.target.checked);
            customChange && customChange();
        }
    }

    return (
        <FormControlLabel
            disabled={disabled}
            label={<Typography variant="caption">{label ? label : ""}</Typography>}
            control={
                <Checkbox
                    {...field}
                    {...props}
                    name={name}
                    checked={Boolean(field.value)} 
                    value={checklistValue ? checklistValue : Boolean(field.value)}              
                    onChange={event => onChangeValue(event)}
                />}
        />
    );
}
