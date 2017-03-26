var app = angular.module('app',['ui.router', 'ngHamburger']).config(
    function($locationProvider) {

        $locationProvider.hashPrefix('');
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    });