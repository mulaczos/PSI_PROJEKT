(function () {
    'use strict';

    angular.module('app', [
        'ui.router',
        'ngResource',
        'ui.toggle',
        'LocalStorageModule'
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

        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: '/html/login.html',
                controller: 'LoginController'
            })
            .state('register', {
                url: '/register',
                templateUrl: '/html/register.html',
                controller: 'RegisterController'
            })
            .state('item', {
                url: '/item',
                templateUrl: '/html/item.html',
                controller: 'ItemsController'
            })
            .state('profile', {
                url: '/profile',
                templateUrl: '/html/profile.html',
                controller: 'ProfileController'
            })
            .state('main', {
                url: '/main',
                templateUrl: '/html/main.html',
                controller: 'MainController'
            })
            .state('orders', {
                url: '/orders',
                templateUrl: '/html/orders.html',
                controller: 'OrdersController'
            })
            .state('admin', {
                url: '/admin',
                templateUrl: '/html/admin.html',
                controller: 'AdminController'
            })
            .state('cart', {
                url: '/cart',
                templateUrl: '/html/cart.html',
                controller: 'CartController'
            })
            .state('checkout', {
                url: '/checkout',
                templateUrl: '/html/checkout.html',
                controller: 'CheckoutController'
            })
            .state('allorders', {
                url: '/allorders',
                templateUrl: '/html/allorders.html',
                controller: 'AllOrdersController'
            });

        $urlRouterProvider.otherwise('/');
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    }
}());
