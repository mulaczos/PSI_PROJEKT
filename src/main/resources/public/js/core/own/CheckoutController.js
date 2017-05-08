(function () {
    'use strict';
    angular
        .module('app')
        .controller('CheckoutController', CheckoutController);


    CheckoutController.$inject = ['$scope', 'AccountService', 'localStorageService', 'OrderService'];

    function CheckoutController($scope, AccountService, localStorageService, OrderService) {

        $scope.submitted = false;

        AccountService.getProfile().then(function (success) {
            $scope.user = success.data;
            $scope.lastname = success.data.lastname;
            $scope.name = success.data.name;
            $scope.email = success.data.email;
            $scope.address = success.data.address;
            $scope.city = success.data.city;
            $scope.zipcode = success.data.zipcode;
        });

        $scope.confirm = function () {

            var items = localStorageService.get('items');
            var summary = localStorageService.get('total');

            OrderService.post({
                items: items,
                summary: summary,
                customer: $scope.user
            }).then(function (success) {
                $scope.submitted = true;
            });

        }

    }
}());

