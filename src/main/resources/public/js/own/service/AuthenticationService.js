(function () {
    'use strict';
    angular
        .module('app')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http'];

    function AuthenticationService($http) {
        var AuthenticationService = {};

        AuthenticationService.login = function (username, password) {
            return $http({
                method: 'POST',
                url: '/api/login',
                data: 'username=' + username + '&password=' + password,
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            });
        };

        AuthenticationService.isAuthenticated = function () {
            return $http({
                method: 'GET',
                url: '/api/user/credentials'
            })
        };

        AuthenticationService.getAllUsers = function () {
            return $http({
                method: 'GET',
                url: '/api/user'
            })
        };

        AuthenticationService.getProfile = function () {
            return $http({
                method: 'GET',
                url: '/api/user/profile'
            })
        };

        AuthenticationService.logout = function () {
            return $http({
                method: 'GET',
                url: '/api/logout'
            })
        };

        AuthenticationService.register = function (data) {
            return $http({
                method: 'POST',
                url: '/api/user',
                data: data
            });
        };

        AuthenticationService.updateProfile = function (data) {
            return $http({
                method: 'PUT',
                url: '/api/user',
                data: data
            });
        };

        AuthenticationService.assignModeratorRole = function (username) {
            return $http({
                method: 'POST',
                url: '/api/user/assignmoderator',
                data: username
            });
        };

        AuthenticationService.degradeToUser = function (username) {
            return $http({
                method: 'POST',
                url: '/api/user/degradetouser',
                data: username
            });
        };

        AuthenticationService.grantAdmin = function (username) {
            return $http({
                method: 'POST',
                url: '/api/user/grantadmin',
                data: username
            });
        };

        AuthenticationService.toggleDisable = function (username) {
            return $http({
                method: 'POST',
                url: '/api/user/toggledisable',
                data: username
            });
        };

        AuthenticationService.getRole = function (username) {
            return $http({
                method: 'GET',
                url: '/api/user/role'
            });
        };

        AuthenticationService.deleteUser = function (data) {
            return $http({
                url: '/api/user/' + data,
                method: 'DELETE'
            });
        };

        return AuthenticationService;
    }
}());
