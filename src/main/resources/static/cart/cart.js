angular.module('market-front').controller('cartController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8189/market/api/v1/cart';

    $scope.loadCartInfo = function () {

        $http.get(contextPath + '/products')
            .then(function successCallback(response) {
                    console.log(response);
                    $scope.productInCart = response.data;
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

        $scope.removeProduct = function (product) {
        $http.delete(contextPath + '/products/' + product.id)
            .then(function successCallback(response) {
                    console.log(response);
                    $scope.loadCartInfo();
                },
                function failCallback(response) {
                    alert(response.data.message);
                });
    }

    $scope.loadCartInfo();

});

