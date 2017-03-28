angular.module('app', [
    'ui.router',
    'ngHamburger',
    'permission',
    'permission.ui'
])
    .config(config)
    .run(function (AuthenticationService) {
        AuthenticationService.isAuthenticated();
    })
    .run(['PermRoleStore', 'PermPermissionStore', 'AuthenticationService', function (PermRoleStore, PermPermissionStore, AuthenticationService) {

        PermRoleStore
            .defineRole('ADMIN', ['admin_panel', 'all_orders', 'to_acceptance']);
        PermRoleStore
            .defineRole('ADMINISTRATION', ['all_orders', 'to_acceptance']);
        PermRoleStore
            .defineRole('LEADER', ['to_acceptance']);
        PermRoleStore
            .defineRole('USER', []);
        PermPermissionStore
            .definePermission('admin_panel', function () {
                return 'ROLE_ADMIN' === Session.authorities;
            });
        PermPermissionStore
            .definePermission('all_orders', function () {
                return ('ROLE_ADMIN' === Session.authorities || 'ROLE_ADMINISTRATION' === Session.authorities);
            });
        PermPermissionStore
            .definePermission('to_acceptance', function () {
                return (
                'ROLE_ADMIN' === Session.authorities ||
                'ROLE_ADMINISTRATION' === Session.authorities ||
                'ROLE_LEADER' === Session.authorities);
            });
    }]);

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

