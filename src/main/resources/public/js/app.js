var app = angular.module("app",
    [ 'ngRoute', 'app.services', 'app.controllers']).config(
    function($routeProvider) {

        var baseUrl = "html/"

        $routeProvider
            .when('/', {
                 redirectTo : '/login',
                 controller : 'LoginController'
             })
            .when('/chart', {
                templateUrl : baseUrl + 'chart.html',
                controller : 'ChartController'
            })
            .when('/configuration', {
                templateUrl : baseUrl + 'configuration.html',
                controller : 'ConfigurationController'
            })
            .otherwise({
                redirectTo : '/',
                controller : 'ChartController',
            });
    });