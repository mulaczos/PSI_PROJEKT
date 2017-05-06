(function () {
    'use strict';
    angular
        .module('app')
        .controller('ItemsController', ItemsController);


    ItemsController.$inject = ['$scope', '$state', 'ItemService', '$rootScope'];

    function ItemsController($scope, $state, ItemService, $rootScope) {

        $scope.quanity = 0;

        $scope.init = function () {
            $scope.item = ItemService.get({id: $rootScope.item});
        };

        $scope.backToMainScreen = function () {
            $state.go("main");
        };

        $scope.removeQuanity = function () {
            if ($scope.quanity > 0) {
                $scope.quanity = $scope.quanity - 1;
            }
        };

        $scope.addQuanity = function () {
            $scope.quanity++;
        };
    }
}());

