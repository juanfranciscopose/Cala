import React from "react";
import { useField } from "formik";
import { TextField } from "@mui/material";
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles(() => ({
    input: {
        color: 'green !important'
    }
}));
const MyTextField = ({
    label,
    disabled = false,
    customChange,
    name, 
    placeholder,
    ...props

}) => {
    const classes = useStyles();
    const [field] = useField(props);  

    const onChangeValue = (event) => {
        if (!disabled){
            field.onChange(event.target.value)
            if (customChange) customChange(event);
        }
    }

    return (
        <TextField
            {...field}
            {...props}
            onChange={event => onChangeValue(event)}
            disabled={disabled}
            label={label ? label : ''}
            variant="outlined" 
            inputProps={{
                classes: {input: classes.input}
            }}
            fullWidth
            placeholder={placeholder ? placeholder : ''} 
        />
    );
}

export default MyTextField;