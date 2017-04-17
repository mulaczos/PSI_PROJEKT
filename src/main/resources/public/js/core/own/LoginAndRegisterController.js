(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController)
        .controller('RegisterController', RegisterController);

    LoginController.$inject = ['$scope', 'AuthenticationService', '$state', '$rootScope'];

    function LoginController($scope, AuthenticationService, $state, $rootScope) {

        $scope.processLogin = function (valid) {

            console.log(valid);
            if (valid) {
                AuthenticationService.login(
                    $scope.username,
                    $scope.password
                ).then(function success(response) {
                    $rootScope.loggedIn = true;
                    $state.go("home", {}, {reload: true});
                }, function failure(response) {
                    $scope.signInForm.$setPristine();
                    $scope.signInForm.$setUntouched();
                    $scope.username = null;
                    $scope.password = null;
                    $scope.failed = true;
                });
            }
        };

        $scope.register = function () {
            $state.go("register", {}, {reload: true});
        }
    }

    RegisterController.$inject = ['$scope', $state];

    function RegisterController($scope, $state) {

        $scope.register = function (valid) {
            if (valid) {

            }
        };

        $scope.arePasswordsTheSame = function () {

            if ($scope.password && $scope.confirm && $scope.password.length > 5 && $scope.confirm.length > 5) {
                return $scope.password == $scope.confirm;

            } else return true;
        };

        $scope.goToLoginPage = function () {
            $state.go("login", {}, {reload: true});
        };
    }
}());