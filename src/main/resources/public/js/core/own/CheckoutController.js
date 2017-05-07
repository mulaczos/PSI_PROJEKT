(function () {
    'use strict';
    angular
        .module('app')
        .controller('CheckoutController', CheckoutController);


    CheckoutController.$inject = ['$scope', '$state', 'localStorageService', '$rootScope'];

    function CheckoutController($scope, $state, localStorageService, $rootScope) {



    }
}());

