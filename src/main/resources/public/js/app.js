var app = angular.module('app',[ 'ngRoute', 'ui.router']).config(
    function($routeProvider, $locationProvider) {

        $locationProvider.hashPrefix('');
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    });