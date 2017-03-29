angular
    .module('app')
    .factory('AuthenticationService', AuthenticationService);

AuthenticationService.$inject = ['$http', 'Session', '$state'];

function AuthenticationService($http, Session, $state) {

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
                Session.create(response.data.principal.username, response.data.principal.authorities[0].authority);
                $state.go("home");
            } else {
                $state.go("login");
            }
        });
    };

    return AuthenticationService;
}

