(function () {
    'use strict';
    angular
        .module('app')
        .controller('CartController', CartController);


    CartController.$inject = ['$scope', '$state', 'localStorageService'];

    function CartController($scope, $state, localStorageService) {

        $scope.items = localStorageService.get("items");

        $scope.backToShopping = function() {
            $state.go('main');
        };

        $scope.removeQuanity = function (item) {
            if (item.quanity > 0) {
                item.quanity = item.quanity - 1;
            }
        };

        $scope.addQuanity = function (item) {
            item.quanity++;
        };
    }
}());

