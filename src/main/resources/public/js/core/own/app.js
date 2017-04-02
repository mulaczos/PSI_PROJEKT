angular.module('app', [
    'ngRoute',
    'ngHamburger',
    'permission',
    'permission.ng'
])
    .config(config)
    .run(function (AuthenticationService) {
        AuthenticationService.isAuthenticated();
    })
    .run(['PermRoleStore', 'PermPermissionStore', 'AuthenticationService', function (PermRoleStore, PermPermissionStore, Session) {

        PermRoleStore
            .defineRole('ADMIN', ['ADMIN_PANEL', 'ROOT_MODIFICATION_PANEL']);
        PermRoleStore
            .defineRole('MODERATOR', ['EXTENDED_MODIFICATION_PANEL', 'ITEM_PANEL']);
        PermRoleStore
            .defineRole('USER', []);
        PermPermissionStore
            .definePermission('ADMIN_PANEL', function () {
                return 'ADMIN' === Session.authority;
            });
        PermPermissionStore
            .definePermission('ROOT_MODIFICATION_PANEL', function () {
                return ('ADMIN' === Session.authority);
            });
        PermPermissionStore
            .definePermission('EXTENDED_MODIFICATION_PANEL', function () {
                return (
                'ADMIN' === Session.authority ||
                'MODERATOR' === Session.authority);
            });
        PermPermissionStore
            .definePermission('ITEM_PANEL', function () {
                return (
                'ADMIN' === Session.authority ||
                'MODERATOR' === Session.authority);
            });
    }]);

config.$inject = (['$locationProvider', '$routeProvider']);

function config($locationProvider, $routeProvider) {

    // $locationProvider.hashPrefix('');
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });

    $routeProvider.when('/', {
        redirectTo : '/login',
        controller : 'LoginController'
    })
        .when('/login', {
            templateUrl : '/views/login.html',
            controller : 'LoginController'
        })
        .when('/home', {
            templateUrl :  '/views/home.html',
            controller : 'HomeController'
        })
        .otherwise({
            redirectTo : '/',
            controller : 'LoginController',
        });


}

