(function () {
    'use strict';

    angular
        .module('app')
        .service('SessionService', SessionService);

    function SessionService() {
        this.create = function (username, authority) {
            this.username = username;
            this.authority = authority;
            this.loggedIn = true;
        };
        this.destroy = function () {
            this.username = null;
            this.authority = null;
            this.loggedIn = false;
        };
    }
}());