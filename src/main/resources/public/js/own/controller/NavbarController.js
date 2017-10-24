(function () {
    'use strict';
    angular
        .module('app')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope', 'AuthenticationService', '$state', '$rootScope', 'localStorageService', 'NavbarService'];

    function NavbarController($scope, AuthenticationService, $state, $rootScope, localStorageService, NavbarService) {

        $scope.init = function () {
            $scope.showItemQuanity();
            $scope.isAuthenticated();
            $scope.selectedTab = NavbarService.getSelectedTab();
        };

        $scope.goMain = function () {
            if ($rootScope.loggedIn) {
                $state.go('main');
            } else {
                $state.go('login');
            }
        };

        $scope.logout = function () {
            AuthenticationService.logout()
                .then(function success(success) {
                    $rootScope.loggedIn = false;
                    $rootScope.role = null;
                    $scope.username = null;
                    localStorageService.clearAll();
                    $state.go('login');
                });
        };

        $scope.goToState = function (state) {
            if ($rootScope.loggedIn) {
                NavbarService.setSelectedTab(state);
                $state.go(state);
            }
        };

        $scope.getUsername = function () {
            return ($scope.username !== null && !angular.isUndefined($scope.username) &&
            $scope.username !== '') ? 'Username: ' + $scope.username : '';
        };

        $rootScope.$on('refreshCart', function (event, data) {
            $scope.showItemQuanity();
        });

        $rootScope.$on('updateUsername', function (event, data) {
            $scope.isAuthenticated();
        });


        $scope.showItemQuanity = function () {
            $scope.items = localStorageService.get('items');
            if ($scope.items !== null) {
                $scope.howManyItems = $scope.items.length;
            } else {
                $scope.howManyItems = 0;
            }

        };

        $scope.isAuthenticated = function () {
            AuthenticationService.isAuthenticated()
                .then(function success(response) {
                    if (response.data) {
                        $rootScope.loggedIn = true;
                        $rootScope.role = response.data.authorities[0].authority;
                        $scope.username = response.data.name;
                        $state.go('main');
                    } else {
                        $state.go('login');
                    }
                }, function failure(response) {
                    $state.go('login');
                });
        };

        $scope.isSelected = function (tab) {
            return NavbarService.getSelectedTab() === tab;
        }
    }
}());