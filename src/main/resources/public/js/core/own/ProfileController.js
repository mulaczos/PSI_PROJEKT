(function () {
    'use strict';
    angular
        .module('app')
        .controller('ProfileController', ProfileController);


    ProfileController.$inject = ['$scope', 'AccountService', '$rootScope'];

    function ProfileController($scope, AccountService, $rootScope) {

        $scope.username = 'success.username';
        $scope.lastname = 'success.lastname';
        $scope.name = 'success.name';
        $scope.email = 'success.email';
        console.log("AAAAAAA");

        AccountService.getProfile().then(function (success) {
            console.log(success.data);
            console.log(success.data);
            console.log(success.data);
            console.log(success.data);
            console.log(success.data);
            console.log(success.data);
            console.log(success.data);
            console.log("IS THIS THING ON??");
            $scope.username = success.data.username;
            $scope.lastname = success.data.lastname;
            $scope.name = success.data.name;
            $scope.email = success.data.email;
            console.log($scope.name);
            console.log($scope.name);
            console.log($scope.name);
            console.log($scope.name);
            console.log($scope.name);
            console.log($scope.name);
            console.log($scope.name);
            console.log($scope.name);

        });
        console.log("BBB");

        // $rootScope.$on('$includeContentLoaded', function () {
        //     $scope.init();
        // });
        // $scope.init = function () {
        //     AccountService.getProfile().then(function (success) {
        //         $scope.username = success.username;
        //         $scope.lastname = success.lastname;
        //         $scope.name = success.name;
        //         $scope.email = success.email;
        //     });
        // };

    }
}());

