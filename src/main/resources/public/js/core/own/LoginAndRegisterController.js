(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController)
        .controller('RegisterController', RegisterController);

    LoginController.$inject = ['$scope', 'AccountService', '$state', '$rootScope'];

    function LoginController($scope, AccountService, $state, $rootScope) {

        $scope.processLogin = function (valid) {

            console.log(valid);
            if (valid) {
                AccountService.login(
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

    RegisterController.$inject = ['$scope', '$state', 'AccountService'];

    function RegisterController($scope, $state, AccountService) {

        $scope.processRegistration = function (valid) {
            if(valid && ($scope.password === $scope.confirm)) {
                AccountService.register(
                    $scope.username,
                    $scope.password,
                    $scope.name,
                    $scope.lastname,
                    $scope.email
                );
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