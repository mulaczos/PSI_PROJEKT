(function () {
    'use strict';
    angular
        .module('app')
        .factory('CityService', CityService);

    CityService.$inject = ['$resource'];

    function CityService($resource) {

        var base = '/city/';

        return $resource(base, {id: '@id'}, {
            'all': {url: base, method: 'GET', isArray: true}
        });
    }

}());