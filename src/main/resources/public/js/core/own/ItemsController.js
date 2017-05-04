(function () {
    'use strict';
    angular
        .module('app')
        .controller('ItemsController', ItemsController);


    ItemsController.$inject = ['$scope', 'ItemService'];

    function ItemsController($scope, ItemService) {

        $scope.init = function () {
            $scope.items = ItemService.all();
        };
    }
}());

