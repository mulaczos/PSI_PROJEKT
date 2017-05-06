(function () {
    'use strict';
    angular
        .module('app')
        .controller('ItemsController', ItemsController);


    ItemsController.$inject = ['$scope', '$state', 'ItemService', '$rootScope'];

    function ItemsController($scope, $state, ItemService, $rootScope) {

        $scope.init = function () {
            $scope.item = ItemService.get({id: $rootScope.item});
        };

        $scope.backToMainScreen = function () {
            $state.go("main");
        };
    }
}());

