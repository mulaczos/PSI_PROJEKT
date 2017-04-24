(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController)
        .controller('RegisterController', RegisterController);

    LoginController.$inject = ['$scope', 'AccountService', '$state', '$rootScope'];

    function LoginController($scope, AccountService, $state, $rootScope) {
        $scope.processLogin = function (valid) {
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
        };

        $rootScope.$on('newAccount', function (event, data) {
            $scope.user = data;
            $scope.newAccount = true;
        });
    }

    RegisterController.$inject = ['$scope', '$state', 'AccountService', '$rootScope'];

    function RegisterController($scope, $state, AccountService, $rootScope) {

        $scope.processRegistration = function (valid) {
            console.log("IS THIS THING ON?");
            console.log(valid);
            console.log("IS THIS THING sadajsdhlasjdh?");
            if (valid && ($scope.password === $scope.confirm)) {
                AccountService.register({
                    username: $scope.username,
                    password: $scope.password,
                    name: $scope.name,
                    email: $scope.email,
                    lastname: $scope.lastname
                }).then(function (success) {
                    $state.go("login").then(function () {
                        $rootScope.$broadcast('newAccount', $scope.username);
                    });
                }, function (failure) {
                    $state.reload();
                });
            }
        };

        $scope.arePasswordsTheSame = function () {

            if ($scope.password && $scope.confirm && $scope.password.length > 5 && $scope.confirm.length > 5) {
                return $scope.password == $scope.confirm;
            } else {
                return true;
            }
        };

        $scope.goToLoginPage = function () {
            $state.go("login", {}, {reload: true});
        };
    }
}());