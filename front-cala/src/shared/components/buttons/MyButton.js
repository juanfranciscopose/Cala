import { Button } from "@mui/material"
import React from 'react'

const MyButton = ({
    label,
    type,
    customClick,
    disabled = false,
    color,
    size = 'large'// o 'small' 'medium'
}) => {

    const handleClick = (event) => {
        if (!disabled){
            if (customClick) customClick(event)
        }
    }

    return (
        <> 
            <Button
                type={type}
                disabled={disabled}
                color={color}
                variant='contained'
                size={size}
                onClick={(event) => handleClick(event)}
            >
                {label}
            </Button>
        </>
    )
}
export default MyButton