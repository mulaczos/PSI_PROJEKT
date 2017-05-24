(function () {
    'use strict';
    angular
        .module('app')
        .controller('AdminController', AdminController);


    AdminController.$inject = ['$scope', 'AccountService', '$state', 'CategoryService', 'ItemService', '$rootScope', 'localStorageService'];

    function AdminController($scope, AccountService, $state, CategoryService, ItemService, $rootScope, localStorageService) {

        $scope.success = false;
        $scope.categories = CategoryService.all();
        $scope.tab = localStorageService.get('tab');
        $scope.items = ItemService.all();

        $scope.init = function () {
            AccountService.getAllUsers().then(function (success) {
                $scope.customers = success.data;
            });
            AccountService.isAuthenticated().then(function (success) {
                $scope.username = success.data.name;
            });
            AccountService.getRole().then(function (success) {
                if ($rootScope.role !== success.data) {
                    if (success.data === 'USER') {
                        $rootScope.role = success.data;
                        $state.go('main', {}, {reload: true});
                    } else {
                        $rootScope.role = success.data;
                        $scope.reload();
                    }
                } else {
                    $rootScope.role = success.data;
                }
            });
        };

        $scope.openTab = function(tab) {
           localStorageService.set('tab', tab);
           $scope.tab = tab;
        };

        $scope.disable = function (username) {
            AccountService.toggleDisable(username).then(function (success) {
                $scope.init();
            });
        };

        $scope.degradeToUser = function (username) {
            AccountService.degradeToUser(username).then(function (success) {
                $scope.init();
            });
        };

        $scope.assignModeratorRole = function (username) {
            AccountService.assignModeratorRole(username).then(function (success) {
                $scope.init();
            });
        };

        $scope.grantAdmin = function (username) {
            AccountService.grantAdmin(username).then(function (success) {
                $scope.init();
            });
        };

        $scope.reload = function () {
            $state.go("admin", {}, {reload: true});
        };

        $scope.addItem = function (valid) {
            if (valid) {
                ItemService.post({
                    name: $scope.name,
                    price: $scope.price,
                    shortDescription: $scope.short,
                    fullDescription: $scope.full,
                    category: $scope.cat
                }).$promise.then(function (success) {
                    $scope.itemForm.$setPristine();
                    $scope.itemForm.$setUntouched();
                    $scope.name = null;
                    $scope.price = null;
                    $scope.short = null;
                    $scope.full = null;
                    $scope.cat = null;
                    $scope.success = true;
                }, function (failure) {
                    $scope.itemForm.$setPristine();
                    $scope.itemForm.$setUntouched();
                    $scope.name = null;
                    $scope.price = null;
                    $scope.short = null;
                    $scope.full = null;
                    $scope.cat = null;
                });
            }
        };

        $scope.deleteUser = function(username) {
            AccountService.deleteUser(username).then(function(success) {
                $scope.reload();
            });
        };
        $scope.deleteItem = function(id) {
            ItemService.delete({id: id}).$promise.then(function(success){
                console.log("is this thing on?");
                $scope.reload();
            });
        }
    }
}());