app.provider("LoginService", LoginServiceProvider);

app.config(['baseUrl', 'LoginServiceProvider', function (baseUrl, loginServiceProvider) {
        loginServiceProvider.setBaseUrl(baseUrl);
    }]);

app.controller("LoginController", ['$scope', '$rootScope', 'LoginService', LoginController]);


function LoginServiceProvider() {
    var _baseUrl = "";
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', function ($http) {
            return new LoginService($http, _baseUrl);
        }];
}

function LoginService($http, baseUrl) {
    this.login = function (fnOk, fnError, body) {
        $http({
            method: 'POST',
            url: baseUrl + '/api/session',
            data: body
        }).success(function (data, status, headers, config) {
            fnOk(data);
            
        }).error(function (data, status, headers, config) {
            fnError(data, status);
        });
    };
}

function LoginController($scope, $rootScope, LoginService) {
    $scope.credentials = "";

    $scope.loginButton = function () {
        if ($scope.credentials.login === null || $scope.credentials.password === null) {
            $scope.error = "Los campos no pueden estar vacios";
        } else {
            LoginService.login(function (data) {
                $rootScope.login = true;
                $rootScope.userLoged = data;
                location.replace('#/panel/');
            }, function (data, status) {
                alert("Error "+status);
            }, $scope.credentials);
        }
    };
    if($rootScope.login){
        location.replace('#/panel/');
    }
}


