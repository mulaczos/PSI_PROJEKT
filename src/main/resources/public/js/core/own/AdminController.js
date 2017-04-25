(function () {
    'use strict';
    angular
        .module('app')
        .controller('AdminController', AdminController);


    AdminController.$inject = ['$scope', 'AccountService'];

    function AdminController($scope, AccountService) {

        AccountService.getAllUserAuthorities().then(function (success) {
            $scope.customers = success.data;
        });

        $scope.disable = function (username) {
        };

        $scope.degradeToUser = function (username) {
        };
        $scope.assignModeratorRole= function (username) {
        };
        $scope.grantAdmin= function (username) {
        };
    }
}());