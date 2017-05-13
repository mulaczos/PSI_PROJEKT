(function () {
    'use strict';
    angular
        .module('app')
        .controller('AdminController', AdminController);


    AdminController.$inject = ['$scope', 'AccountService', '$state', 'CategoryService', 'ItemService'];

    function AdminController($scope, AccountService, $state, CategoryService, ItemService) {

        $scope.categories = CategoryService.all();

        AccountService.getRole().then(function (success) {
            $scope.role = success.data;
        });

        $scope.toggle = false;

        AccountService.getAllUsers().then(function (success) {
            $scope.customers = success.data;
        });

        $scope.disable = function (username) {
            AccountService.toggleDisable(username).then(function (success) {
            });
        };

        $scope.degradeToUser = function (username) {
            AccountService.degradeToUser(username).then(function (success) {
                $scope.reload();
            });
        };

        $scope.assignModeratorRole = function (username) {
            AccountService.assignModeratorRole(username).then(function (success) {
                $scope.reload();
            });
        };

        $scope.grantAdmin = function (username) {
            AccountService.grantAdmin(username).then(function (success) {
                $scope.reload();
            });
        };

        $scope.reload = function () {
            $state.go("admin", {}, {reload: true});
        };

        $scope.addItem = function () {

        };
    }
}());