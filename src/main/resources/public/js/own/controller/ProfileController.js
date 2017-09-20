(function () {
    'use strict';
    angular
        .module('app')
        .controller('ProfileController', ProfileController);


    ProfileController.$inject = ['$scope', 'AccountService', '$state', 'CityService'];

    function ProfileController($scope, AccountService, $state, CityService) {

        CityService.all().$promise.then(function (success) {
            $scope.cityList = success;
            AccountService.getProfile().then(function (success) {
                $scope.username = success.data.username;
                $scope.lastname = success.data.lastname;
                $scope.name = success.data.name;
                $scope.email = success.data.email;
                $scope.password = null;
                $scope.confirm = null;
                $scope.address = success.data.address;

                angular.forEach($scope.cityList, function (value, key) {
                    if (value.zipcode === success.data.zipcode) {
                        $scope.choosenCity = value;
                    }
                });
            });
        });


        $scope.arePasswordsSame = function () {
            if ($scope.password && $scope.confirm && $scope.password.length > 4 && $scope.confirm.length > 4) {
                return $scope.password == $scope.confirm;
            } else {
                return true;
            }
        };

        $scope.unlockSubmit = function (valid) {
            return $scope.password && $scope.confirm && $scope.password.length > 4 && $scope.confirm.length > 4 &&
                ($scope.password === $scope.confirm) && valid;
        };

        $scope.updateProfile = function () {
            AccountService.updateProfile({
                username: $scope.username,
                newpassword: $scope.password,
                confirmwithpassword: $scope.confirmwithpassword,
                email: $scope.email,
                name: $scope.name,
                lastname: $scope.lastname,
                zipcode: $scope.choosenCity.zipcode,
                address: $scope.address,
                city: $scope.choosenCity.city
            }).then(function success(response) {
                $state.go('profile', {}, {reload: true});
            }, function failure(response) {
            });
        };
    }
}());

