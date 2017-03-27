angular
    .module('app')
    .controller('LoginController', LoginController)

LoginController.$inject = ['$scope', 'AuthenticationFactory'];

function LoginController($scope, AuthenticationFactory) {
    $scope.processLogin = function () {
        console.log($scope.user.username);
        console.log($scope.user.password);

        AuthenticationFactory.login({
            username: $scope.user.username,
            password: $scope.user.password
        }).$promise.then(function (success) {
            console.log(success);
        });
    }
}




