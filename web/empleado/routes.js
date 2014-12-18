app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
             templateUrl: "login/login.html",
             controller:"LoginController"
        });
        
        $routeProvider.when('/panel', {
            templateUrl: "panel/panel.html",
            controller:"PanelController"
        });
        
        $routeProvider.when('/login', {
            templateUrl: "login/login.html",
            controller:"LoginController"
        });
        
        $routeProvider.otherwise({
           redirectTo: '/panel' ,
           controller:"PanelController"
        });
    }
]);