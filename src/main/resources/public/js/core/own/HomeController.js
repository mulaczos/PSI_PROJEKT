(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'ItemService', 'CategoryService', '$state'];

    function HomeController($scope, ItemService, CategoryService, $state) {

        $scope.isOpen = true;

        $scope.init = function () {
            $scope.items = ItemService.all();
            $scope.categories = CategoryService.all();
        };

        $scope.showItem = function (id ){
            console.log(id);
            $state.go("items");
        };
    }
}());