(function () {
    'use strict';

    angular
        .module('app')
        .controller('MainController', MainController);

    MainController.$inject = ['$scope', 'ItemService', 'CategoryService', '$state','$rootScope'];

    function MainController($scope, ItemService, CategoryService, $state, $rootScope) {

        $scope.init = function () {
            if (angular.isUndefined($rootScope.category) === false) {
                if ($rootScope.category === 'ALL') {
                    $scope.fetchAllItems();
                } else {
                    $scope.showItemsForGivenCategory($rootScope.category);
                }
            } else {
                $scope.fetchAllItems();
            }
            $scope.categories = CategoryService.all();
        };

        $scope.showItem = function (id) {
            $state.go("item");
        };

        $scope.fetchAllItems = function () {
            $rootScope.category = 'ALL';
            $scope.items = ItemService.all();
        };

        $scope.showItemsForGivenCategory = function (id) {
            $rootScope.category = id;
            $scope.items = ItemService.getItemsForGivenCategory({id: id});
        };
    }
}());