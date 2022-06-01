import React from 'react'
import { Add, Delete, Edit, ViewListOutlined } from "@mui/icons-material"
import { Fab, Tooltip } from "@mui/material"

const MyFabButton = ({
    customClick,
    tooltip,
    icon,
    disabled = false,
    color,
    size = 'medium'// o 'small' 'large'
}) => {

    const handleClick = (event) => {
        if (!disabled){
            if (customClick) customClick(event)
        }
    }

    return (
        <> 
            <Tooltip title={tooltip}>
                <Fab
                    disabled={disabled}
                    ariant="extended"
                    size={size}
                    color={color}
                    onClick={(event) => {handleClick(event)}} 
                >
                        {icon === 'view' ? <ViewListOutlined/> : ''}
                        {icon === 'delete' ? <Delete/> : ''}
                        {icon === 'add' ? <Add/> : ''}
                        {icon === 'edit' ? <Edit/> : ''}
                </Fab>
            </Tooltip>
        </>
    )
}
export default MyFabButton