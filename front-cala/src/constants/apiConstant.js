var port = '8080'
var host = 'localhost'
var REST_SERVICE_URI = 'http://' + host + ':' + port

module.exports = {
    apiConstant: {
        ABMPersonas: `${REST_SERVICE_URI}/people`,
        Filtros: `${REST_SERVICE_URI}/filters`
    },
}