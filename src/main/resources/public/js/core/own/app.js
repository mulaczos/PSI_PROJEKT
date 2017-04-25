(function () {
    'use strict';

    angular.module('app', [
        'ui.router',
        'ngResource'
    ])
        .config(config);

    config.$inject = (['$locationProvider', '$stateProvider', '$urlRouterProvider', '$httpProvider']);
    function config($locationProvider, $stateProvider, $urlRouterProvider, $httpProvider) {

        $httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';

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
            .state('profile', {
                url: "/profile",
                templateUrl: '/profile.html',
                controller: 'ProfileController'
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
            .state('admin', {
                url: "/admin",
                templateUrl: '/admin.html',
                controller: 'AdminController'
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
