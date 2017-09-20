(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController)
        .controller('RegisterController', RegisterController);

    LoginController.$inject = ['$scope', 'AccountService', '$state', '$rootScope', 'localStorageService'];

    function LoginController($scope, AccountService, $state, $rootScope, localStorageService) {

        $scope.processLogin = function (valid) {
            if (valid) {
                AccountService.login(
                    $scope.username,
                    $scope.password
                ).then(function success(response) {
                    $rootScope.loggedIn = true;
                    localStorageService.clearAll();
                    $rootScope.$broadcast('refreshCart');
                    $rootScope.$broadcast('updateUsername');
                    $rootScope.role = response.data.authorities[0].authority;
                    $rootScope.selectedCategory = 'ALL';
                    localStorageService.set('tab', 'addItem');
                    $state.go('main', {}, {reload: true});
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
            $state.go('register', {}, {reload: true});
        };

        $rootScope.$on('newAccount', function (event, data) {
            $scope.user = data;
            $scope.newAccount = true;
        });
    }

    RegisterController.$inject = ['$scope', '$state', 'AccountService', '$rootScope', 'CityService'];

    function RegisterController($scope, $state, AccountService, $rootScope, CityService) {

        CityService.all().$promise.then(function (success) {
            $scope.cityList = success;
        });

        $scope.processRegistration = function (valid) {
            if (valid && ($scope.password === $scope.confirm)) {
                AccountService.register({
                    username: $scope.username,
                    password: $scope.password,
                    name: $scope.name,
                    email: $scope.email,
                    address: $scope.address,
                    zipcode: $scope.choosenCity.zipcode,
                    city: $scope.choosenCity.city,
                    lastname: $scope.lastname
                }).then(function (success) {
                    $state.go('login').then(function () {
                        $rootScope.$broadcast('newAccount', $scope.username);
                    });
                }, function (failure) {
                    $state.reload();
                });
            }
        };

        $scope.arePasswordsTheSame = function () {
            if ($scope.password && $scope.confirm && $scope.password.length > 4 && $scope.confirm.length > 4) {
                return $scope.password == $scope.confirm;
            } else {
                return true;
            }
        };

        $scope.goToLoginPage = function () {
            $state.go('login', {}, {reload: true});
        };
    }
}());