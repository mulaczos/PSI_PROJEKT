(function () {
    'use strict';
    angular
        .module('app')
        .factory('ItemService', ItemService);

    ItemService.$inject = ['$resource'];

    function ItemService($resource) {

        var base = '/item/';

        return $resource(base, {id: '@id'}, {
            'get': {url: base, method: 'GET', params: {id: '@id'}},
            'all': {url: base, method: 'GET', isArray: true},
            'save': {url: base, method: 'POST'},
            'update': {url: base, method: 'PUT'},
            'delete': {url: base, method: 'DELETE', params: {id: '@id'}},
            'available': {url: base, method: 'GET', isArray: true}
        });
    }

}());