(function () {
    'use strict';
    angular
        .module('app')
        .controller('ItemsController', ItemsController);


    ItemsController.$inject = ['$scope', '$state'];

    function ItemsController($scope, $state) {
        $scope.backToMainScreen = function () {
            $state.go("main");
        };
    }
}());

