(function () {
    'use strict';
    angular
        .module('app')
        .controller('AllOrdersController', AllOrdersController);

    AllOrdersController.$inject = ['$scope', 'OrderService'];

    function AllOrdersController($scope, OrderService) {

        $scope.init = function () {
            $scope.orders = OrderService.all();
        };
    }
}());

