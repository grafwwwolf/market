angular.module('market-front', []).controller('appController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189/market/api/v1';
    let currentPage = 1;
    let totalPgs;

    $scope.loadProducts = function (pageIndex = currentPage) {

        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                page: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
            totalPgs = response.data.totalPages;
        });
    }

    $scope.removeProduct = function (product) {
        $http.get(contextPath + '/products/delete/' + product.id)
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

    $scope.createNewProduct = function () {
        $http.post(contextPath + '/products', $scope.new_product)
            .then(function successCallback(response) {
                    $scope.loadProducts(currentPage);
                    $scope.new_product = null;
                },
                function failCallback(response) {
                    alert(response.data.message);
                });
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadProducts(currentPage);

});

