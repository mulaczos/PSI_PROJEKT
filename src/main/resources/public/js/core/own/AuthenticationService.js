(function () {
    'use strict';

    angular
        .module('app')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http', 'SessionService', '$state'];

    function AuthenticationService($http, SessionService, $state) {

        var AuthenticationService = {};

        AuthenticationService.login = function (username, password) {
            return $http({
                method: 'POST',
                url: 'login',
                data: 'username=' + username + '&password=' + password,
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                }
            });
        };

        AuthenticationService.isAuthenticated = function () {
            return $http({
                method: 'GET',
                url: 'authentication'
            })
        };

        return AuthenticationService;
    }
}());