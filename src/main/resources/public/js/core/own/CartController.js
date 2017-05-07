(function () {
    'use strict';
    angular
        .module('app')
        .controller('CartController', CartController);


    CartController.$inject = ['$scope', '$state', 'localStorageService', '$rootScope'];

    function CartController($scope, $state, localStorageService, $rootScope) {

        $scope.total = 0;
        $scope.items = localStorageService.get("items");

        $scope.backToShopping = function () {
            $state.go('main');
        };

        $scope.removeQuanity = function (item) {
            for (var i = 0; i < $scope.items.length; i++) {
                if ($scope.items[i].id === item.id) {
                    if ($scope.items[i].quanity > 1) {
                        $scope.items[i].quanity = $scope.items[i].quanity - 1;
                    }
                    localStorageService.set("items", $scope.items);
                    $scope.items = localStorageService.get("items");
                    $scope.countTotal();
                    break;
                }
            }
        };

        $scope.addQuanity = function (item) {
            for (var i = 0; i < $scope.items.length; i++) {
                if ($scope.items[i].id === item.id) {
                    $scope.items[i].quanity = $scope.items[i].quanity + 1;
                    localStorageService.set("items", $scope.items);
                    $scope.items = localStorageService.get("items");
                    $scope.countTotal();
                    break;
                }
            }
            $scope.countTotal();
        };

        $scope.countTotal = function () {
            $scope.total = 0;
            if ($scope.items !== null) {
                for (var i = 0; i < $scope.items.length; i++) {
                    $scope.total = $scope.total + ($scope.items[i].quanity * $scope.items[i].price);
                }
            }
        };

        $scope.remove = function(item) {
            for (var i = 0; i < $scope.items.length; i++) {
                if ($scope.items[i].id === item.id) {
                    $scope.items.splice(i, 1);
                    localStorageService.set("items", $scope.items);
                    $scope.items = localStorageService.get("items");
                    $scope.countTotal();
                    $rootScope.$broadcast("refreshCart");
                    break;
                }
            }
        };

        $scope.checkout = function() {
          $state.go('checkout');
        };
    }
}());

