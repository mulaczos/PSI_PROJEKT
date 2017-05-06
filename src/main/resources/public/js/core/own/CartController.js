(function () {
    'use strict';
    angular
        .module('app')
        .controller('CartController', CartController);


    CartController.$inject = ['$scope', '$state', 'ItemService', '$rootScope'];

    function CartController($scope, $state, ItemService, $rootScope) {

    }
}());

