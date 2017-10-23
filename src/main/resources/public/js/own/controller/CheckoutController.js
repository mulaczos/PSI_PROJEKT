(function () {
    'use strict';
    angular
        .module('app')
        .controller('CheckoutController', CheckoutController);


    CheckoutController.$inject = ['$scope', 'AuthenticationService', 'localStorageService', 'OrderService', '$rootScope', '$state', 'CityService'];

    function CheckoutController($scope, AuthenticationService, localStorageService, OrderService, $rootScope, $state, CityService) {

        $scope.submitted = false;

        CityService.all().$promise.then(function (success) {
            $scope.cityList = success;
            AuthenticationService.getProfile().then(function (success) {
                $scope.user = success.data;
                $scope.lastname = success.data.lastname;
                $scope.name = success.data.name;
                $scope.email = success.data.email;
                $scope.address = success.data.address;
                angular.forEach($scope.cityList, function (value, key) {
                    if (value.zipcode === success.data.zipcode) {
                        $scope.choosenCity = value;
                    }
                });
            });
        });


        $scope.confirm = function () {

            var items = localStorageService.get('items');
            var summary = localStorageService.get('total');

            for (var i = 0; i < items.length; i++) {
                items[i].id = null;
            }

            OrderService.post({
                items: items,
                summary: summary,
                customer: $scope.user,
                customerDetails: {
                    customerName: $scope.name,
                    customerLastname: $scope.lastname,
                    customerEmail: $scope.email,
                    customerAddress: $scope.address,
                    customerCity: $scope.choosenCity.city,
                    customerZipcode: $scope.choosenCity.zipcode
                }
            }).$promise.then(function (success) {
                $scope.submitted = true;
                localStorageService.clearAll();
                $rootScope.$broadcast('refreshCart');
            });

        };

        $scope.goToMyOrders = function () {
            $state.go('orders');
        }

    }
}());

