(function () {
    'use strict';

    angular
        .module('app')
        .controller('MainController', MainController);

    MainController.$inject = ['$scope', 'ItemService', 'CategoryService', '$state','$rootScope'];

    function MainController($scope, ItemService, CategoryService, $state, $rootScope) {

        $scope.init = function () {
            if (angular.isUndefined($rootScope.selectedCategory) === false) {
                if ($rootScope.selectedCategory === 'ALL') {
                    $scope.fetchAllItems();
                } else {
                    $scope.showItemsForGivenCategory($rootScope.selectedCategory);
                }
            } else {
                $scope.fetchAllItems();
            }
            $scope.categories = CategoryService.all();
        };

        $scope.showItem = function (id) {
            $rootScope.item = id;
            $state.go("item");
        };

        $scope.fetchAllItems = function () {
            $rootScope.selectedCategory = 'ALL';
            $scope.items = ItemService.all();
        };

        $scope.showItemsForGivenCategory = function (id) {
            $rootScope.selectedCategory = id;
            $scope.items = ItemService.getItemsForGivenCategory({id: id});
        };
    }
}());