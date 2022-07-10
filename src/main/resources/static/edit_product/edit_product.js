angular.module('market-front').controller('editProductController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/market/api/v1';

        $scope.prepareProductForUpdate = function () {
            $http.get(contextPath + '/products/' + $routeParams.productId)
                .then(function successCallback(response) {
                        $scope.upd_product = response.data;
                    },
                    function failCallback(response) {
                        alert(response.data.messages);
                        $location.path('/store');
                    });
        }

    $scope.updateProduct = function () {
        $http.put(contextPath + '/products', $scope.upd_product)
            .then(function successCallback(response) {
                    $scope.upd_product = null;
                    alert("Продукт обновлен");
                    $location.path('/store');
                },
                function failCallback(response) {
                    alert(response.data.messages);
                });
    }

    $scope.prepareProductForUpdate();
});

