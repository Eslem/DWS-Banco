var app = angular.module("usuario-app", []);

function buscarUsuarioController($scope, $http) {
    $http({
        method: 'GET',
        url: baseUrl + '/update.json.jsp?idEntidadBancaria=1&nombre=' + nombre + '&codigoEntidad=' + codigoEntidad
    }).success(function (data, status, headers, config) {
        fnOk(data);
    }).error(function (data, status, headers, config) {
        fnError(data, status);
    });
}
