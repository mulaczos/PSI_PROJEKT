(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'ItemService'];

    function HomeController($scope, ItemService) {
        $scope.init = function () {
            $scope.items = ItemService.all();
        };
    }
}());