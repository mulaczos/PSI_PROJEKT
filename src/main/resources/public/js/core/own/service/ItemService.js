(function () {
    'use strict';
    angular
        .module('app')
        .factory('ItemService', ItemService);

    ItemService.$inject = ['$resource'];

    function ItemService($resource) {

        var base = '/item/';

        return $resource(base, {id: '@id'}, {
            'all': {url: base, method: 'GET', isArray: true},
            'getItemsForGivenCategory': {url: base + "category/:id", method: 'GET', isArray: true}
        });
    }

}());