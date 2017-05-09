(function () {
    'use strict';
    angular
        .module('app')
        .controller('AllOrdersController', AllOrdersController);

    AllOrdersController.$inject = ['$scope', 'OrderService', '$state'];

    function AllOrdersController($scope, OrderService, $state) {

        $scope.init = function () {
            $scope.orders = OrderService.all();
        };

        $scope.confirmOrder = function (order) {
            OrderService.confirmOrder(order).$promise.then(function (success) {
                $state.go('allorders', {}, {reload: true});
            });
        };

        $scope.rejectOrder = function (order) {
            OrderService.rejectOrder(order).$promise.then(function (success) {
                $state.go('allorders', {}, {reload: true});
            });
        };
    }
}());

