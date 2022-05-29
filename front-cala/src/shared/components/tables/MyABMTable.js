import React from 'react';
import { DataGrid} from '@mui/x-data-grid';

const MyABMTable = ({
    columns, // headers de la tabla (dejo hardcode de ejemplo)
    rows, // valores de la tabla (dejo hardcode de ejemplo)
    pageSize, // integer => cantidad por defecto de items por pagina
    height, // max(600) o min(400) => ajustar
    customSelectionChange // evento seleccion de checkbox fila
  }) => {
    /*const columnsHardcode = [
        { field: 'id', headerName: 'ID', width: 70 },
        { field: 'firstName', headerName: 'First name', width: 130 },
        { field: 'lastName', headerName: 'Last name', width: 130 },
        {
          field: 'age',
          headerName: 'Age',
          type: 'number',
          width: 90,
        },
        {
          field: 'fullName',
          headerName: 'Full name',
          description: 'This column has a value getter and is not sortable.',
          sortable: false,
          width: 160,
          valueGetter: (params) =>
            `${params.row.firstName || ''} ${params.row.lastName || ''}`,
        },
      ];
      
      const rowsHardcode = [
        { id: 1, lastName: 'Snow', firstName: 'Jon', age: 35 },
        { id: 2, lastName: 'Lannister', firstName: 'Cersei', age: 42 },
        { id: 3, lastName: 'Lannister', firstName: 'Jaime', age: 45 },
        { id: 4, lastName: 'Stark', firstName: 'Arya', age: 16 },
        { id: 5, lastName: 'Targaryen', firstName: 'Daenerys', age: null },
        { id: 6, lastName: 'Melisandre', firstName: null, age: 150 },
        { id: 7, lastName: 'Clifford', firstName: 'Ferrara', age: 44 },
        { id: 8, lastName: 'Frances', firstName: 'Rossini', age: 36 },
        { id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65 },
      ];*/

      //guardo objeto de selected rows
      const [selectedRows, setSelectedRows] = React.useState([]);

      const handleSelectionChange = (ids) => {
        const selectedIDs = new Set(ids);
        const selectedRows = rows.filter((row) =>
          selectedIDs.has(row.id),
        );
        setSelectedRows(selectedRows);

        if (customSelectionChange){
            customSelectionChange(selectedRows)
        }
      }

      return (
        <div style={{ height: height === 'max' ? 600 : 400 , width: '100%' }}>
          <DataGrid
            rows={rows}
            columns={columns}
            pageSize={pageSize}
            rowsPerPageOptions={[]}
            checkboxSelection
            onSelectionModelChange={(newSelection) => { handleSelectionChange(newSelection) }}
          />
        </div>
      );
};

export default MyABMTable;
