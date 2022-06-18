import React from "react"
import InteresService from './filters/InteresService'
import IdeologiaService from './filters/IdeologiaService'

const execute = (filter) => {
      switch (filter) {
        case 'interest':
          return InteresService.getInteresOptions()
        
        case 'ideology':
          return IdeologiaService.getIdeologiaOptions()
          
        default:
          console.log('Error en filter');
          break;
      }
    }

    export default { execute };