(function () {
    'use strict';
    angular
        .module('app')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', 'AuthenticationService'];

    function NavbarController($scope, AuthenticationService) {

        $scope.loggedIn = false;

        $scope.init = function () {
            AuthenticationService.isAuthenticated()
                .then(function success(response) {
                    if (response.data) {
                        $scope.loggedIn = true;
                        $state.go("items");
                    }
                }, function failure(response) {
                    $state.go("login");
                });
        }
    }


}());