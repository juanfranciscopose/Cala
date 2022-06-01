import React from 'react'
import { Add, Delete, Edit, ViewListOutlined } from "@mui/icons-material"
import { IconButton, Tooltip } from "@mui/material"

const MyIconButton = ({
    customClick,
    tooltip,
    icon,
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
            <Tooltip title={tooltip}>
                <IconButton
                    disabled={disabled}
                    color={color}
                    size={size}
                    onClick={(event) => handleClick(event)}
                >
                    {icon === 'view' ? <ViewListOutlined/> : ''}
                    {icon === 'delete' ? <Delete/> : ''}
                    {icon === 'edit' ? <Edit/> : ''}
                    {icon === 'add' ? <Add/> : ''}
                </IconButton>
            </Tooltip>
        </>
    )
}
export default MyIconButton