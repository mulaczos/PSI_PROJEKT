(function () {
    'use strict';
    angular
        .module('app')
        .controller('ProfileController', ProfileController);


    ProfileController.$inject = ['$scope', 'AccountService', '$rootScope'];

    function ProfileController($scope, AccountService, $rootScope) {

        AccountService.getProfile().then(function (success) {
            $scope.username = success.data.username;
            $scope.lastname = success.data.lastname;
            $scope.name = success.data.name;
            $scope.email = success.data.email;

        });

        $scope.arePasswordsTheSame = function () {
            if ($scope.password && $scope.confirm && $scope.password.length > 5 && $scope.confirm.length > 5) {
                return $scope.password == $scope.confirm;
            } else {
                return false;
            }
        };
    }
}());

