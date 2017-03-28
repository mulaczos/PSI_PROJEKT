angular
    .module('app')
    .service('Session', Session);

function Session() {
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


