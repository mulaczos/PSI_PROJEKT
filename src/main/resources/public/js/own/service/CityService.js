(function () {
    'use strict';
    angular
        .module('app')
        .factory('CityService', CityService);

    CityService.$inject = ['$resource'];

    function CityService($resource) {

        var base = 'api/city/';

        return $resource(base, {id: '@id'}, {
            'all': {url: base, method: 'GET', isArray: true}
        });
    }

}());