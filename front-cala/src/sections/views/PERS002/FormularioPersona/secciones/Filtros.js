import React from "react"
import { Grid, Typography, Collapse, Paper } from '@mui/material'
import KeyboardControlKeyIcon from '@mui/icons-material/KeyboardControlKey'
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown'
import SeccionBuilder from './../../../../../shared/components/build/SeccionBuilder'
import { makeStyles } from '@mui/styles'
import * as Yup from 'yup'
import getGeneroOptions from './../../../../../shared/services/filters/GeneroService'
import getInteresOptions from './../../../../../shared/services/filters/InteresService'
import getIdeologiaOptions from './../../../../../shared/services/filters/IdeologiaService'
import getTipoTrabajoOptions from './../../../../../shared/services/filters/TipoTrabajoService'
import getFranjaEtariaOptions from './../../../../../shared/services/filters/FranjaEtariaService'
import getTipoParticipacionOptions from './../../../../../shared/services/filters/TipoParticipacionService'
import getTematicaOptions from './../../../../../shared/services/filters/TematicaService'
import getNexoGestionOptions from './../../../../../shared/services/filters/NexoGestionService'

const useStyles = makeStyles(theme => ({
    paper: {
        padding: theme.spacing(2),
        borderRadius: 5
    }
}));

const TITLE = 'Filtros'

const arrayFiltros = [
    {
        id: 'franjaEtaria',
        name: 'franjaEtaria',
        label: 'Franja Etaria',
        type: 'Select',
        options: getFranjaEtariaOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },{
        id: 'genero',
        name: 'gender',
        label: 'Genero',
        type: 'Select',
        options: getGeneroOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'interes',
        name: 'interest',
        label: 'Interés',
        type: 'MultiSelect',
        options: getInteresOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'ideologia',
        name: 'ideologia',
        label: 'Ideologías',
        type: 'MultiSelect',
        options: getIdeologiaOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'tipoTrabajo',
        name: 'tipoTrabajo',
        label: 'Tipo Trabajo',
        type: 'Select',
        options: getTipoTrabajoOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'tipoParticipacion',
        name: 'tipoParticipacion',
        label: 'Tipo Participación',
        type: 'MultiSelect',
        options: getTipoParticipacionOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'tematica',
        name: 'tematica',
        label: 'Temática',
        type: 'MultiSelect',
        options: getTematicaOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    },
    {
        id: 'nexoGestion',
        name: 'nexoGestion',
        label: 'Nexo de Gestión',
        type: 'MultiSelect',
        options: getNexoGestionOptions,
        validation: Yup.string().required('El campo es requerido'),
        initialValue: ''
    }
];

const componentFiltros = ({disableSeccion=false}) => {
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
                        <SeccionBuilder xs={4} items={arrayFiltros} disableInputs={disableSeccion}/>
                    </Grid>            
               {/*</Collapse>*/}
            </Paper>
        </React.Fragment>
    )
}

export default {componentFiltros, arrayFiltros }