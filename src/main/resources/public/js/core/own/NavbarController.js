(function () {
    'use strict';
    angular
        .module('app')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', 'AuthenticationService', '$state'];

    function NavbarController($scope, AuthenticationService, $state) {

        $scope.init = function () {
            AuthenticationService.isAuthenticated()
                .then(function success(response) {
                    if (response.data) {
                        $scope.loggedIn = true;
                        $state.go("items", {}, {reload: true});
                    } else {
                        $state.go("login");
                    }
                }, function failure(response) {
                    $state.go("login");
                });
        }
    }


}());