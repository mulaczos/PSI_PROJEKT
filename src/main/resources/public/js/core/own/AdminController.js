(function () {
    'use strict';
    angular
        .module('app')
        .controller('AdminController', AdminController);


    AdminController.$inject = ['$scope', 'AccountService', '$state'];

    function AdminController($scope, AccountService, $state) {

        AccountService.getAllUsers().then(function (success) {
            $scope.customers = success.data;
        });

        $scope.disable = function (username) {
            AccountService.toggleDisable(username).then(function (success) {
                setTimeout(function() {$scope.reload();}, 350);
            });
        };

        $scope.degradeToUser = function (username) {
            AccountService.degradeToUser(username).then(function (success) {
                $scope.reload();
            });
        };

        $scope.assignModeratorRole= function (username) {
            AccountService.assignModeratorRole(username).then(function (success) {
                $scope.reload();
            });
        };

        $scope.grantAdmin= function (username) {
            AccountService.grantAdmin(username).then(function (success) {
                $scope.reload();
            });
        };

        $scope.reload = function() {
            $state.go("admin", {}, {reload: true});
        };
    }
}());