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

        AccountService.register = function (data) {
            return $http({
                method: 'POST',
                url: '/user',
                data: data
            });
        };

        return AccountService;
    }
}());