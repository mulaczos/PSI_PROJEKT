(function () {
    'use strict';
    angular
        .module('app')
        .controller('AdminController', AdminController);


    AdminController.$inject = ['$scope', 'AccountService'];

    function AdminController($scope, AccountService) {

        AccountService.getAllUserAuthorities().then(function (success) {
            console.log(success);
            $scope.users = success.data;
        });
    }
}());