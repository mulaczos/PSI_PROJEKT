(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'ItemService', 'CategoryService', '$state'];

    function HomeController($scope, ItemService, CategoryService, $state) {

        $scope.init = function () {
            $scope.fetchAllItems();
            $scope.categories = CategoryService.all();
        };

        $scope.showItem = function (id) {
            $state.go("items");
        };

        $scope.fetchAllItems = function () {
            $scope.items = ItemService.all();
        };

        $scope.showItemsForGivenCategory = function (id) {
            console.log(id);
            $scope.items = ItemService.getItemsForGivenCategory({id: id});
        };
    }
}());