var app = angular.module("app", ['ngRoute', 'ngAnimate', 'ui.date']).run(function ($rootScope) {
});

app.config(function ($provide, $httpProvider) {
    $provide.factory('HTTPLoadingInterceptor', function ($q) {
        return {
            'request': function (config) {
                NProgress.start();
                return config;
            },
            'requestError': function (rejection) {
                return $q.reject(rejection);
            },
            'response': function (response) {
                NProgress.done();
                return response;
            },
            // optional method
            'responseError': function (rejection) {
                NProgress.done();
                return $q.reject(rejection);
            }
        };
    });

    $httpProvider.interceptors.push("HTTPLoadingInterceptor");
});

app.constant("baseUrl", contextPath);

app.constant('uiDateConfig', {
    dateFormat: "dd/mm/yy",
    fistDay: 1
});