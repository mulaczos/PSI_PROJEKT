(function () {
    'use strict';
    angular
        .module('app')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', 'AuthenticationService', '$state', '$rootScope'];

    function NavbarController($scope, AuthenticationService, $state, $rootScope) {



        $scope.init = function () {
            AuthenticationService.isAuthenticated()
                .then(function success(response) {
                    if (response.data) {
                        $rootScope.loggedIn = true;
                        $state.go("home", {}, {reload: true});
                    } else {
                        $state.go("login");
                    }
                }, function failure(response) {
                    $state.go("login");
                });
        }
    }


}());