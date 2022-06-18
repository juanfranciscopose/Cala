import React from "react"
import InteresService from './filters/InteresService'
import IdeologiaService from './filters/IdeologiaService'
import TipoParticipacionService from './filters/TipoParticipacionService'

const execute = (filter) => {
      switch (filter) {
        case 'interest':
          return InteresService.getInteresOptions()
        
        case 'ideology':
          return IdeologiaService.getIdeologiaOptions()
        
        case 'type-participation':
          return TipoParticipacionService.getTipoParticipacionOptions()
           
        default:
          console.log('Error en filter');
          break;
      }
    }

    export default { execute };