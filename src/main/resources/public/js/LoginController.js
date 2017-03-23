angular
    .module('app')
    .controller('LoginController', LoginController)
    .config(config);

LoginController.$inject = ['$scope'];
config.$inject=(['$stateProvider']);

function LoginController($scope) {
             $scope.init = function() {
                console.log("it works!");
             }
             $scope.greeting = "hello!";
}
function config($stateProvider) {
            $stateProvider
                .state('login', {
                    url: "/login",
                    templateUrl: '/views/login.html',
                    controller: 'LoginController'
            })}

