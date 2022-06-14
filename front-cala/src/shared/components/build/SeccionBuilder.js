import React from "react"
import TYPE_FIELDS from './../../../constants/typeFields'
import InputFactory from "../factory/InputFactory"

const SeccionBuilder = ({items, xs, disableInputs=false}) => {

    return (
        <React.Fragment>
            {items.filter(item => TYPE_FIELDS.some(type => type === item.type))
              .map((item, index) => (
                <InputFactory
                  key={index}
                  field={item}
                  xs={xs}
                  disableInput={disableInputs}
                />
              ))}
        </React.Fragment>
    )
}

export default SeccionBuilder
