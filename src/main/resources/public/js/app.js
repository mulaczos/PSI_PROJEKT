angular.module('app', ['ui.router', 'ngHamburger'])
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
        .state('other', {
            url: "/dsadasdasd"
        });

    $urlRouterProvider.otherwise('login');
}

