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
            }).then(function success(response) {
                if (response.data) {
                    SessionService.create(response.data.principal.username, response.data.principal.authorities[0].authority);
                    $state.go("home");
                    // $state.go($state.current, {}, {reload: true});
                } else {
                    $state.go("login");
                }
            });
        };

        return AuthenticationService;
    }
}());