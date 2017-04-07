(function () {
    'use strict';

    angular.module('app', [
        'ui.router',
        'ngResource'
    ])
        .config(config);

    config.$inject = (['$locationProvider', '$stateProvider', '$urlRouterProvider']);
    function config($locationProvider, $stateProvider, $urlRouterProvider) {

        $locationProvider.hashPrefix('');
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });

        $stateProvider
            .state('login', {
                url: "/login",
                templateUrl: '/views/login.html',
                controller: 'LoginController'
            })
            .state('items', {
                url: "/items",
                templateUrl: '/views/items.html',
                controller: 'ItemsController'
            })
            .state('basket', {
                url: "/basket",
                templateUrl: '/views/basket.html',
                controller: 'BasketController'
            })
            .state('orders', {
                url: "/orders",
                templateUrl: '/views/orders.html',
                controller: 'OrdersController'
            })
            .state('panel', {
                url: "/panel",
                templateUrl: '/views/panel.html',
                controller: 'PanelController'
            })
            .state('settings', {
                url: "/settings",
                templateUrl: '/views/settings.html',
                controller: 'SettingsController'
            });

        $urlRouterProvider
            .when('/', '/')
            .otherwise("/");
    }
}());
