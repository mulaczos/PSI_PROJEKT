var app = angular.module('app', ['ui.router', 'ngHamburger'])
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

    // $urlRouterProvider.otherwise(function ($injector) {
    //     console.log("is this thinf on?");
    //     var $state = $injector.get("$state");
    //     $state.go('login');
    // });

    $urlRouterProvider.otherwise('login');
}

