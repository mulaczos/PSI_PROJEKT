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

        AccountService.logout = function () {
          return $http({
              method: 'GET',
              url: '/logout'
          })
        };

        AccountService.register = function (username, password, name, lastname, email) {
            return $http({
                method: 'POST',
                url: '/user',
                data: 'username=' + username + '&password=' + password + '&name=' + name + '&lastname=' + lastname + '&email=' + email,
                headers: {
                    "Content-Type": "application/json;charset=UTF-8"
                }
            });
        };

        return AccountService;
    }
}());