(function () {
    'use strict';
    angular
        .module('app')
        .factory('CategoryService', CategoryService);

    CategoryService.$inject = ['$resource'];

    function CategoryService($resource) {

        var base = '/category/';

        return $resource(base, {id: '@id'}, {
            'all': {url: base, method: 'GET', isArray: true}
        });
    }

}());