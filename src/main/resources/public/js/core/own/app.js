(function () {
    'use strict';

    angular.module('app', [
        'ui.router',
        'ngResource'
    ])
        .config(config);

    config.$inject = (['$locationProvider', '$stateProvider', '$urlRouterProvider']);
    function config($locationProvider, $stateProvider, $urlRouterProvider) {

        // $locationProvider.hashPrefix('');
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });

        $stateProvider
            .state('login', {
                url: "/login",
                templateUrl: '/login.html',
                controller: 'LoginController'
            })
            .state('register', {
                url: "/register",
                templateUrl: '/register.html',
                controller: 'RegisterController'
            })
            .state('items', {
                url: "/items",
                templateUrl: '/items.html',
                controller: 'ItemsController'
            })
            .state('basket', {
                url: "/basket",
                templateUrl: '/basket.html',
                controller: 'BasketController'
            })
            .state('home', {
                url: "/home",
                templateUrl: '/home.html',
                controller: 'HomeController'
            })
            .state('orders', {
                url: "/orders",
                templateUrl: '/orders.html',
                controller: 'OrdersController'
            })
            .state('panel', {
                url: "/panel",
                templateUrl: '/panel.html',
                controller: 'PanelController'
            })
            .state('settings', {
                url: "/settings",
                templateUrl: '/settings.html',
                controller: 'SettingsController'
            });

        $urlRouterProvider
            .when('/', '/')
            .otherwise("/");
    }
}());
