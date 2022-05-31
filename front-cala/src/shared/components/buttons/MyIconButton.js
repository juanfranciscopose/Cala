import { Add, Delete } from "@mui/icons-material"
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
                    {icon == 'delete' ? <Delete/> : ''}
                    {icon == 'add' ? <Add/> : ''}
                </IconButton>
            </Tooltip>
        </>
    )
}
export default MyIconButton