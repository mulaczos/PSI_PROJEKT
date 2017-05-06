(function () {
    'use strict';

    angular.module('app', [
        'ui.router',
        'ngResource',
        'ui.toggle'
    ])
        .config(config)
        .filter('capitalize', function () {
            return function (input) {
                return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
            }
        });

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
            .state('item', {
                url: "/item",
                templateUrl: '/item.html',
                controller: 'ItemsController'
            })
            .state('profile', {
                url: "/profile",
                templateUrl: '/profile.html',
                controller: 'ProfileController'
            })
            .state('main', {
                url: "/main",
                templateUrl: '/main.html',
                controller: 'MainController'
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
            .state('cart', {
                url: "/cart",
                templateUrl: '/cart.html',
                controller: 'CartController'
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
