package com.cala.util.messages;

public class MessageError {
	/**
	 * GENERAL
	 */
	public static final String ERR_GENERICO = "Ocurrió un error en la aplicación. Por favor, contáctese con el administrador.";
	public static final String ERR_VALIDACION_GENERICA = "Datos insuficientes";
	public static final String ERR_PAGINACION_REQUERIDA = "Es necesario paginar los resultados";
	
	/**
	 * generic filter
	 */
	public static final String ERR_ENTER_NAME = "El campo nombre es requerido para ejecutar esta acción";//-> usado en generico de filtro
	public static final String ERR_ENTER_STATE = "El estado es requerido para ejecutar esta acción";//-> usado en generico de filtro
	public static final String ERR_ENTER_NAME_MAX = "El campo nombre superó el tamaño máximo";//-> usado en generico de filtro
	public static final String ERR_ENTER_NAME_MIN = "El campo nombre no alcanzó el tamaño mínimo";//-> usado en generico de filtro
	public static final String ERR_NAME_NOT_UNIQUE = "El campo nombre está siendo utilizado en otro filtro";//-> usado en generico de filtro
	public static final String ERR_ID = "El id es incorrecto";//-> usado en generico de filtro
	public static final String ERR_FILTER_NOT_EXIST = "El filtro no existe";//-> usado en generico de filtro
	public static final String ERR_PAGINATION = "La paginacion es incorrecta";//-> usado en generico de filtro
	
	/**
	 * ABM
	 */
	public static final String ERR_INGRESAR_USUARIO = "El campo nombre de usuario es requerido para ejecutar esta acción";
	public static final String ERR_INGRESAR_PASSWORD = "El campo contraseña es requerido para ejecutar esta acción";
	public static final String ERR_INGRESAR_DESCRIPCION = "El campo descripción es requerido para ejecutar esta acción";
	public static final String ERR_SELECCIONAR_PERMISO = "Se debe seleccionar al menos un permiso para dar de alta el rol";
	public static final String ERR_ROL_EXISTENTE = "Ya existe un rol con el nombre ingresado";
	public static final String ERR_USUARIO_EXISTENTE = "Ya existe un usuario con el nombre ingresado";
	public static final String ERR_VALIDACION_AMBITO_EXISTENTE = "El usuario ya tiene el ambito seleccionado";
	public static final String ERR_AMBITO_LABORATORIO = "El ambito laboratorio requiere que se carga al menos un laboratorio";
	public static final String ERR_RUBRO_CON_CONJUNTO_EXISTENTE = "Ya existe un rubro con el mismo conjunto analitico.";
	public static final String ERR_SUB_MARTIZ_EXISTENTE = "Ya existe una Sub Matriz con los mismos datos.";
	public static final String ERR_RUBRO_CON_PRODUCTO_EXISTENTE = "Ya existe un rubro con el mismo producto.";
	
	/**
	 * VALIDACIONES
	 */
	public static final String ERR_TRAMITE_CON_MUESTRA = "El tramite seleccionado ya tiene una muestra cargada";
	public static final String ERR_STOCK_DE_PROTOCOLO_VACIO = "El Laboratorio no tiene protocolos en blanco disponibles para emitir resultados";
	public static final String ERR_LAB_CUIT_REQUERIDO = "El Laboratorio seleccionado no tiene CUIT configurado";
	public static final String ERR_TRAMITE_NO_SE_PUEDE_ANULAR = "El trámite seleccionado no se puede anular";
	public static final String ERR_TRAMITE_NO_PUEDE_REEMPLAZAR = "El trámite seleccionado no puede reemplazar otro trámite";
	public static final String ERR_BOLETA_NO_SE_PUEDE_CONFIRMAR = "La boleta seleccionada ya está confirmada";
	public static final String ERR_TRAMITE_NO_SE_PUEDE_RECHAZAR = "El trámite seleccionado no se puede rechazar";
	public static final String ERR_TRAMITE_NO_SE_PUEDE_REQUERIR_AUTORIZACION = "El trámite seleccionado no se puede pasar a pendiente de autorización";
	public static final String ERR_TRAMITE_DERIVADO_NO_SE_PUEDE_MODIFICAR = "El trámite seleccionado no se puede modificar";
	public static final String ERR_PERMISOS_INSUFICIENTES = "El usuario no posee los permisos para realizar dicha acción";
	public static final String ERR_TRAMITE_NO_SE_PUEDE_EMITIR = "Para emitir el trámite seleccionado debe esta autorizado";
	public static final String ERR_TRAMITE_NO_SE_PUEDE_DERIVAR = "Para emitir el trámite seleccionado debe esta pendiente de carga";
	public static final String ERR_CREHA_VACIO = "No se encontraron datos en CREHA para el numero de acta";
	public static final String ERR_CREHA_NUMERO = "Numero de acta de Creha debe de ser tipo numerico.";
	public static final String ERR_CREHA_ESTADO = "No se importaron los datos de acta de Creha, su estado debe de ser recepcionada.";
	public static final String ERR_CREHA_EXISTE_TRAMITE = "Ya existe un tramite cargado con el mismo numero de acta.";
	public static final String ERR_PRODUCTO_VCS_EXISTE = "Ya existe un producto cargado con los mismos datos.";
	public static final String ERR_VALOR_DOUBLE = "El valor debe de ser un numero.";
	public static final String ERR_TRAMITE_RECEPCION = "No se pudo realizar la recepcion del tramite";
	public static final String ERR_CREHA_SIN_RECEPCION = "El acta no se encuentra recepcionada.";
	public static final String ERR_CREHA_TRAMITE_INFORMAR= "No se pudo informar a Creha";
	public static final String ERR_LAB_CONFIG = "El laboratorio ya existe.";
	public static final String ERR_TRAMITE_IMPORTAR_REPETIDO = "Ya existe un tramite con el mismo numero.";
	public static final String ERR_PRODUCTO_VCS_EXISTE_CONJUNTO_ANALITO_SUSTANCIA = "Una de las sustancias ya está siendo utilizada para el mismo conjunto analito.";
	public static final String ERR_TRAMITE_DERIVADO_NO_AUTORIZADO = "El trámite derivado no se encuetra autorizado.";
	
	/**
	 * REPORTES
	 * 
	 */
	
	public static final String ERR_GENERANDO_REPORTE = "Ocurrió un error al generar el reporte. Por favor, intente nuevamente o comuníquese con el Administrador.";

	
	public static String msgGenerico(String key){
		return String.format("El campo %s es requerido para ejecutar esta acción", key);
	}
	
	public static String listaVacia(String key){
		return String.format("La lista de %s debe contener al menos un elemento para ejecutar esta acción", key);
	}
	
	public static String faltanDatos(String key){
		return String.format("Faltan datos en la carga de %s", key);
	}
	
	public static String formatoInvalido(String key, String formato){
		return String.format("El campo %s es inválido. Debe ser %s.", key, formato);
	}
	
	public static String msgEstadoIncorrecto(String key){
		return String.format("Para esta acción debe estar en estado %s", key);
	}
	
	public static String msgErrorValidacionParametro(String key, String type){
		return String.format("El campo %s debe de ser %s.", key , type);
	}
	
	public static String msgErrorExisteRegistro(String key){
		return String.format("El campo %s ya se encuentra cargado.", key);
	}
	

	public static String msgErrorFechaDeAnalsisAnterior(int analisis, String fecha){
		return String.format("Las fechas del Analisis #%s no puede ser menor que la Fecha de %s de la muestra.", analisis, fecha);
	}
	
	public static String msgErrorNoExisteDato(String key){
		return String.format("El campo %s no se pudo encontrar en el sistema.", key);
	}
	
	/*
	 *       GENERIC FILTER
	 */
	public static String msgErrorCreateGenericFilter(String key){
		return String.format("El filtro %s no se pudo crear en el sistema.", key);
	}
	
	public static String msgErrorDeleteGenericFilter(String key){
		return String.format("El filtro %s no se pudo eliminar en el sistema.", key);
	}
	
	public static String msgErrorUpdateGenericFilter(String key){
		return String.format("El filtro %s no se pudo actualizar en el sistema.", key);
	}
	
	public static String msgErrorActivateGenericFilter(String key){
		return String.format("El filtro %s no se pudo activar en el sistema.", key);
	}
	
}
