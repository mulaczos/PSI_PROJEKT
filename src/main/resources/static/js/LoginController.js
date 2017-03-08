var app = angular.module("LoginController", [])

app.controller('LoginController', [ '$scope', function($scope) {

        $scope.init = function() {
            console.log("it works!");
        }

        $scope.greeting = "hello!";
}]);
