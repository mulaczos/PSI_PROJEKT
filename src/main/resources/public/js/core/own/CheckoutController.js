(function () {
    'use strict';
    angular
        .module('app')
        .controller('CheckoutController', CheckoutController);


    CheckoutController.$inject = ['$scope', 'AccountService', 'localStorageService', 'OrderService', '$rootScope'];

    function CheckoutController($scope, AccountService, localStorageService, OrderService, $rootScope) {

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

            for(var i =0; i<items.length; i++) {
                items[i].id = null;
            }

            OrderService.post({
                items: items,
                summary: summary,
                customer: $scope.user
            }).$promise.then(function (success) {
                $scope.submitted = true;
                localStorageService.clearAll();
                $rootScope.$broadcast("refreshCart");
            });

        }

    }
}());

