(function () {
    'use strict';
    angular
        .module('app')
        .factory('OrderService', OrderService);

    OrderService.$inject = ['$resource'];

    function OrderService($resource) {

        var base = '/order/';

        return $resource(base, {id: '@id'}, {
            'get': {url: base + ':id', method: 'GET'},
            'all': {url: base, method: 'GET', isArray: true},
            'post': {url: base, method: 'POST'},
            'getMyOrders': {url: base + 'my', method: 'GET', isArray: true},
            'confirmOrder': {url: base + 'confirm', method: 'POST'},
            'rejectOrder': {url: base + 'reject', method: 'POST'}
        });
    }

}());