import * as React from 'react';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Chip from '@mui/material/Chip';
import { useField, useFormikContext } from 'formik';
import Service from './../../services/filters/InteresService'

const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};

const names = [
  'Oliver Hansen',
  'Van Henry',
  'April Tucker',
  'Ralph Hubbard',
  'Omar Alexander',
  'Carlos Abbott',
  'Miriam Wagner',
  'Bradley Wilkerson',
  'Virginia Andrews',
  'Kelly Snyder',
];

function getStyles(name, personName, theme) {
  return {
    fontWeight:
      personName.indexOf(name) === -1
        ? theme.typography.fontWeightRegular
        : theme.typography.fontWeightMedium,
  };
}

const MyMultiSelect = ({
    name,
    label,
    options,
    disabled = false,
    hideId = false,
    customChange,
    needEvento = true,
    mapeoProps,
    filter,
    needFilter,
    ...props
}) => {
  const { setFieldValue } = useFormikContext();
  const [field, meta] = useField(name);
  const theme = useTheme();
  const [personName, setPersonName] = React.useState([]);
  const [isBussy, setIsBussy] = React.useState(true)
  const [listado, setListado] = React.useState([])

  React.useEffect(() => {
    let isMounted = true
    if (isMounted){
      if (!needFilter){
        setListado(options)
        setIsBussy(false)
      }else{
        Service.getInteresOptions().then(response => {
          //console.log(response);
          const list = response.data.json
          setListado(list)
          setIsBussy(false)
        })
      }
    }
    return () => {isMounted = false}
  }, [])

  const onChangeValue = (event) => {
    if (!disabled) {
        const {
        target: { value },
        } = event;
        setPersonName(
        // On autofill we get a stringified value.
        typeof value === 'string' ? value.split(',') : value,
        );
        
        setFieldValue(name, event.target.value)
        if (customChange) needEvento ? customChange(event) : customChange();
    }
  };

  const getDescription = (item) => {
    return hideId || item.value === -1
        ? item[mapeoProps.desc]
        : `${item[mapeoProps.value]} - ${item[mapeoProps.desc]}`
    }

  return (
    <div>
      <FormControl fullWidth>
        <InputLabel id="multiple-chip-label">{label}</InputLabel>
        <Select
          {...field}
          {...props}
          id="multiple-chip"
          fullWidth
          name={name}
          disabled={disabled}
          multiple
          value={personName}
          onChange={event => onChangeValue(event)}
          input={<OutlinedInput id="multiple-chip" label={label} />}
          renderValue={(selected) => (
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
              {selected.map((value) => (
                <Chip key={value} label={value} />
              ))}
            </Box>
          )}
          MenuProps={MenuProps}
        >
          {isBussy ? [] : listado && listado.map((item, key) =>
            <MenuItem 
              style={getStyles(name, personName, theme)} 
              key={key} 
              value={item[mapeoProps.value]}
            >
                {getDescription(item)}
                
            </MenuItem>
          )}
        </Select>
      </FormControl>
    </div>
  );
}

export default MyMultiSelect
