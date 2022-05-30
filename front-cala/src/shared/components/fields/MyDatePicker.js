import * as React from 'react';
import TextField from '@mui/material/TextField';
import { useField, useFormikContext } from 'formik';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';

const MyDatePicker = ({
    name,
    label,
    disabled=false,
    customChange,
    ...props
}) => {
    const [field, meta] = useField(name);
    const { setFieldValue } = useFormikContext();
    const today = React.useState(new Date());

    const onChangeValue = newValue => {
        if (!disabled) {
            setFieldValue(name, newValue);
            customChange && customChange();
        }
    }

  return (
    <LocalizationProvider dateAdapter={AdapterDateFns}>
        <DesktopDatePicker
          {...field}
          {...props}
          name= {name}
          disabled={disabled}
          label={label}
          value={field.value === undefined ? today : field.value}
          minDate={new Date('1900-01-01')}
          onChange={(newValue) => {
            onChangeValue(newValue);
          }}
          fullWidth
          renderInput={(params) => <TextField {...params} />}
        />
    </LocalizationProvider>
  );
}

export default MyDatePicker;
