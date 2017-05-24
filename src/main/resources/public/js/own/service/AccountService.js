(function () {
    'use strict';
    angular
        .module('app')
        .factory('AccountService', AccountService);

    AccountService.$inject = ['$http'];

    function AccountService($http) {

        var AccountService = {};

        AccountService.login = function (username, password) {
            return $http({
                method: 'POST',
                url: 'login',
                data: 'username=' + username + '&password=' + password,
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
            });
        };

        AccountService.isAuthenticated = function () {
            return $http({
                method: 'GET',
                url: 'user/credentials'
            })
        };

        AccountService.getAllUsers = function () {
            return $http({
                method: 'GET',
                url: 'user'
            })
        };

        AccountService.getProfile = function () {
            return $http({
                method: 'GET',
                url: 'user/profile'
            })
        };

        AccountService.logout = function () {
            return $http({
                method: 'GET',
                url: '/logout'
            })
        };

        AccountService.register = function (data) {
            return $http({
                method: 'POST',
                url: '/user',
                data: data
            });
        };

        AccountService.updateProfile = function (data) {
            return $http({
                method: 'PUT',
                url: '/user',
                data: data
            });
        };

        AccountService.assignModeratorRole = function (username) {
            return $http({
                method: 'POST',
                url: '/user/assignmoderator',
                data: username
            });
        };

        AccountService.degradeToUser = function (username) {
            return $http({
                method: 'POST',
                url: '/user/degradetouser',
                data: username
            });
        };

        AccountService.grantAdmin = function (username) {
            return $http({
                method: 'POST',
                url: '/user/grantadmin',
                data: username
            });
        };

        AccountService.toggleDisable = function (username) {
            return $http({
                method: 'POST',
                url: '/user/toggledisable',
                data: username
            });
        };

        AccountService.getRole = function (username) {
            return $http({
                method: 'GET',
                url: '/user/role'
            });
        };

         AccountService.deleteUser = function (data) {
            return $http({
                url: '/user/'+data,
                method: 'DELETE'
            });
         };

        return AccountService;
    }
}());
