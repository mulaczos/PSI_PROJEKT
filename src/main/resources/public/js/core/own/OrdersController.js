(function () {
    'use strict';
    angular
        .module('app')
        .controller('OrdersController', OrdersController);

    OrdersController.$inject = ['$scope', 'OrderService'];

    function OrdersController($scope, OrderService) {

        $scope.init = function () {
           $scope.orders = OrderService.getMyOrders();
        };
    }
}());