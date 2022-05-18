import React from "react"
import { Grid, Typography, Collapse, Paper } from '@mui/material'
import KeyboardControlKeyIcon from '@mui/icons-material/KeyboardControlKey'
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown'
import SeccionBuilder from './../../../../../shared/components/build/SeccionBuilder'
import { makeStyles } from '@mui/styles'
import * as Yup from 'yup'
import getGeneroOptions from './../../../../../shared/services/filters/GeneroService'

const useStyles = makeStyles(theme => ({
    paper: {
        padding: theme.spacing(2),
        borderRadius: 5
    }
}));

const TITLE = 'Datos Personales'

const arrayDatosPersonales = [
    {
        id: 'nombre',   
        name: 'nombre', //formik
        label: 'Nombre',//input label
        type: 'Text',   // seccionBuilder y inputFactory
        validation: Yup.string().required('El campo es requerido'), // yup formik
        initialValue: '' // formik (edit)
    },
    {
        id: 'apellido',
        name: 'apellido',
        label: 'Apellido',
        type: 'Text',
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'genero',
        name: 'genero',
        label: 'Genero',
        type: 'Select',
        options: getGeneroOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    }
];

const componentDatosPersonales = () => {
    //const classes = useStyles();
    //const [seccionCollapse, setSeccionCollapse] = React.useState(true);

    return (
        <React.Fragment>
            <Paper variant='elevation' elevation={3}> {/*className={classes.paper}>*/}
                <Grid p={1}>
                    <Typography variant="h6" > {/*onClick={setSeccionCollapse(!seccionCollapse)}>*/}
                        {TITLE} {/*{seccionCollapse ? <KeyboardControlKeyIcon/> : <KeyboardArrowDownIcon/>}*/}
                    </Typography>
                </Grid>
                {/*<Collapse orientation="horizontal" in={seccionCollapse}>*/}
                    <Grid container alignItems="center" justify="center" spacing={2} p={1}>
                        <SeccionBuilder xs={4} items={arrayDatosPersonales}/>
                    </Grid>            
               {/*</Collapse>*/}
            </Paper>
        </React.Fragment>
    )
}

export default {componentDatosPersonales, arrayDatosPersonales }