import React from "react"
import { Grid, Typography, Collapse, Paper } from '@mui/material'
import SeccionBuilder from './../../../../shared/components/build/SeccionBuilder'
import getGeneroOptions from './../../../../shared/services/filters/GeneroService'
import getFranjaEtariaOptions from './../../../../shared/services/filters/FranjaEtariaService'
import getIdeologiaOptions from './../../../../shared/services/filters/IdeologiaService'
import getInteresOptions from './../../../../shared/services/filters/InteresService'
import getNexoGestionOptions from './../../../../shared/services/filters/NexoGestionService'
import getTematicaOptions from './../../../../shared/services/filters/TematicaService'
import getTipoParticipacionOptions from './../../../../shared/services/filters/TipoParticipacionService'
import getTipoTrabajoOptions from './../../../../shared/services/filters/TipoTrabajoService'
import MyButton from "../../../../shared/components/buttons/MyButton"

const TITLE = 'Filtro Tabla Personas'

const arrayFiltros = [
    {
        id: 'filtroGenero',
        name: 'filtroGenero',
        label: 'Genero',
        type: 'Select',
        options: getGeneroOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroFranjaEtaria',
        name: 'filtroFranjaEtaria',
        label: 'Franja Etaria',
        type: 'Select',
        options: getFranjaEtariaOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroIdeologia',
        name: 'filtroIdeologia',
        label: 'Ideologia',
        type: 'Select',
        options: getIdeologiaOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroInteres',
        name: 'filtroInteres',
        label: 'Interés',
        type: 'Select',
        options: getInteresOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroNexoGestion',
        name: 'filtroNexoGestion',
        label: 'Nexo Gestion',
        type: 'Select',
        options: getNexoGestionOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroTematica',
        name: 'filtroTematica',
        label: 'Temática',
        type: 'Select',
        options: getTematicaOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroTipoParticipacion',
        name: 'filtroTipoParticipacion',
        label: 'Tipo Participación',
        type: 'Select',
        options: getTipoParticipacionOptions,
        validation: '',
        initialValue: ''
    },
    {
        id: 'filtroTipoTrabajo',
        name: 'filtroTipoTrabajo',
        label: 'Tipo Trabajo',
        type: 'Select',
        options: getTipoTrabajoOptions,
        validation: '',
        initialValue: ''
    }
];

const componentHeaderABMPersona = () => {
    
    return (
        <React.Fragment>
            <Paper variant='elevation' elevation={3}>
                <Grid container p={1} justifyContent="flex-start" alignItems="center">
                    <Grid item >
                        <Typography variant="h6" >
                            {TITLE} 
                        </Typography>
                    </Grid>
                </Grid>
                <Grid container alignItems="center" justify="center" spacing={2} p={1}>
                    <SeccionBuilder xs={3} items={arrayFiltros}/>
                    <Grid item >
                        <MyButton
                          type={"submit"}
                          label={'Filtrar'}
                          color={'error'}
                        />
                    </Grid>
                </Grid>       
            </Paper>
        </React.Fragment>
    );
}

export default {componentHeaderABMPersona,  arrayFiltros}