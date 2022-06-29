angular.module('market-front', []).controller('appController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189/market/';
    let currentPage = 1;
    let totalPgs;

    $scope.loadProducts = function (pageIndex = currentPage) {

        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                page: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            totalPgs = response.data.totalPages;
        });
    }

    $scope.removeProduct = function (product) {
        $http.get(contextPath + 'products/delete/' + product.id)
            .then(function (response) {
                console.log(response);
                $scope.loadProducts();
            });
    }

    $scope.showInfo = function (product) {
        alert(product.title)
    }

    $scope.loadPreviousPage = function () {
        if (currentPage < 2) {
            alert("Вы находитесь на первой странице")
        } else {
            currentPage--;
            $scope.loadProducts();
        }
    }

    $scope.loadNextPage = function () {
        if (currentPage > totalPgs - 1) {
            alert("Вы находитесь на последней странице")
        } else {
            currentPage++;
            $scope.loadProducts();
        }
    }

    $scope.loadProducts(currentPage);

});

