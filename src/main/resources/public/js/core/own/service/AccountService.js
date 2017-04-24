(function () {
    'use strict';
    angular
        .module('app')
        .factory('AccountService', AccountService);

    AccountService.$inject = ['$http', 'SessionService', '$state'];

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

        AccountService.grantmoderator = function (username) {
            return $http({
                method: 'POST',
                url: '/user/grantmoderator',
                data: username
            });
        };

        AccountService.degradetouser = function (username) {
            return $http({
                method: 'POST',
                url: '/user/degradetouser',
                data: username
            });
        };

        AccountService.grantadmin = function (username) {
            return $http({
                method: 'POST',
                url: '/user/grantadmin',
                data: username
            });
        };

        AccountService.degradetomoderator = function (username) {
            return $http({
                method: 'POST',
                url: '/user/degradetomoderator',
                data: username
            });
        };

        return AccountService;
    }
}());
