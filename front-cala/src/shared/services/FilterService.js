import React from "react"
import InteresService from './filters/InteresService'
import IdeologiaService from './filters/IdeologiaService'
import TipoParticipacionService from './filters/TipoParticipacionService'
import TematicaService from './filters/TematicaService'
import NexoGestionService from './filters/NexoGestionService'

const execute = (filter) => {
      switch (filter) {
        case 'interest':
          return InteresService.getInteresOptions()
        
        case 'ideology':
          return IdeologiaService.getIdeologiaOptions()
        
        case 'type-participation':
          return TipoParticipacionService.getTipoParticipacionOptions()

        case 'topic':
          return TematicaService.getTematicaOptions()

        case 'nexus-management':
          return NexoGestionService.getNexoGestionOptions()
                  
        default:
          console.log('Error en filter');
          break;
      }
    }

    export default { execute };