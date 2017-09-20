(function () {
    'use strict';
    angular
        .module('app')
        .controller('OrdersController', OrdersController);

    OrdersController.$inject = ['$scope', 'OrderService', '$rootScope', '$state'];

    function OrdersController($scope, OrderService, $rootScope, $state) {

        $scope.expanded = false;

        $scope.init = function () {
            $scope.orders = OrderService.getMyOrders();
        };

        $scope.goShopping = function () {
            $rootScope.selectedCategory = 'ALL';
            $state.go('main');
        }
    }
}());