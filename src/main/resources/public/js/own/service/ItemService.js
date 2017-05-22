(function () {
    'use strict';
    angular
        .module('app')
        .factory('ItemService', ItemService);

    ItemService.$inject = ['$resource'];

    function ItemService($resource) {

        var base = '/items/';

        return $resource(base, {id: '@id'}, {
            'get': {url: base+':id', method: 'GET'},
            'all': {url: base, method: 'GET', isArray: true},
            'post': {url: base, method: 'POST'},
            'getItemsForGivenCategory': {url: base + "category/:id", method: 'GET', isArray: true}
        });
    }

}());