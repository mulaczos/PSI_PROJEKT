(function () {
    'use strict';
    angular
        .module('app')
        .factory('OrderService', OrderService);

    OrderService.$inject = ['$resource'];

    function OrderService($resource) {

        var base = '/order/';

        return $resource(base, {id: '@id'}, {
            'get': {url: base+':id', method: 'GET'},
            'all': {url: base, method: 'GET', isArray: true},
            'post': {url: base, method: 'POST'},
            'getItemsForGivenCategory': {url: base + "category/:id", method: 'GET', isArray: true}
        });
    }

}());