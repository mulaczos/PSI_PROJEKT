angular
    .module('app')
    .factory('AuthenticationService', AuthenticationService);

AuthenticationService.$inject = ['$http'];

function AuthenticationService($http) {

    var AuthenticationService = {};

    AuthenticationService.login = function (username, password) {
        return $http({
            method: 'POST',
            url: 'login',
            data: 'username=' + username + '&password=' + password,
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            }
        });
    };

    AuthenticationService.isAuthenticated = function () {
        return $http({
            method: 'GET',
            url: 'authentication'
        });
    };

    return AuthenticationService;
}

