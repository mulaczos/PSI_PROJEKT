(function () {
    'use strict';
    angular
        .module('app')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', 'AccountService', '$state', '$rootScope'];

    function NavbarController($scope, AccountService, $state, $rootScope) {

        $scope.init = function () {
            AccountService.isAuthenticated()
                .then(function success(response) {
                    if (response.data) {
                        $rootScope.loggedIn = true;
                        $state.go("main");
                    } else {
                        $state.go("login");
                    }
                }, function failure(response) {
                    $state.go("login");
                });
        };

        $scope.goMain = function () {
            if($rootScope.loggedIn) {
                $state.go("main", {}, {reload: true});
            } else {
                $state.go("login", {}, {reload: true});
            }
        };

        $scope.logout = function () {
            AccountService.logout()
                .then(function success(success) {
                    $rootScope.loggedIn=false;
                    localStorageService.clearAll();
                    $state.go("login", {}, {reload: true});
                });
        };

        $scope.goToState = function (state) {
            if($rootScope.loggedIn) {
                $state.go(state);
            }
        };

        $rootScope.$on('addItem', function (event, data) {
            $scope.user = data;
            $scope.newAccount = true;
        });
    }


}());