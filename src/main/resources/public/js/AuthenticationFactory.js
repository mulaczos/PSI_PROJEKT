angular
    .module('app')
    .factory('AuthenticationFactory', AuthenticationFactory);

AuthenticationFactory.$inject = ['$resource'];

function AuthenticationFactory($resource) {

    var base = '/login';

    return $resource(base, {
        'login': {url: base, method: 'POST'}
    });
}

