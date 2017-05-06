(function () {
    'use strict';
    angular
        .module('app')
        .controller('ItemsController', ItemsController);


    ItemsController.$inject = ['$scope', '$state', 'ItemService', '$rootScope', 'localStorageService'];

    function ItemsController($scope, $state, ItemService, $rootScope, localStorageService) {

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

        $scope.addToCart = function (item) {
            item.quanity = $scope.quanity;
            if (angular.isUndefined(localStorageService.get('items')) || localStorageService.get('items') === null) {
                $scope.cartData = [];
                $scope.cartData.push(item);
                localStorageService.set('items', $scope.cartData);
            } else {
                $scope.cartData = [];
                $scope.cartData = localStorageService.get('items');

                var present = false;
                for (var i = 0; i < $scope.cartData.length; i++) {
                    if ($scope.cartData[i].id === item.id) {
                        $scope.cartData[i].quanity = $scope.cartData[i].quanity + item.quanity;
                        present = true;
                        break;
                    }
                }
                if (!present) {
                    $scope.cartData.push(item);
                }
                localStorageService.set('items', $scope.cartData);
            }
        };
    }
}());

