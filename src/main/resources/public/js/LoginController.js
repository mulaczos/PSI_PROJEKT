angular
    .module('app')
    .controller('LoginController', LoginController);

LoginController.$inject = ['$scope', 'AuthenticationService'];

function LoginController($scope, AuthenticationService) {

    $scope.processLogin = function () {

        AuthenticationService.login(
            $scope.user.username,
            $scope.user.password
        );

    }
}