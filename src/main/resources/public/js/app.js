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
            .defineRole('ADMIN', ['ADMIN_PANEL', 'ROOT_MODIFICATION_PANEL']);
        PermRoleStore
            .defineRole('MODERATOR', ['EXTENDED_MODIFICATION_PANEL', 'ITEM_PANEL']);
        PermRoleStore
            .defineRole('USER', []);
        PermPermissionStore
            .definePermission('ADMIN_PANEL', function () {
                return 'ROLE_ADMIN' === Session.authorities;
            });
        PermPermissionStore
            .definePermission('ROOT_MODIFICATION_PANEL', function () {
                return ('ROLE_ADMIN' === Session.authorities);
            });
        PermPermissionStore
            .definePermission('EXTENDED_MODIFICATION_PANEL', function () {
                return (
                'ROLE_ADMIN' === Session.authorities ||
                'ROLE_MODERATOR' === Session.authorities);
            });
        PermPermissionStore
            .definePermission('ITEM_PANEL', function () {
                return (
                'ROLE_ADMIN' === Session.authorities ||
                'ROLE_MODERATOR' === Session.authorities);
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

