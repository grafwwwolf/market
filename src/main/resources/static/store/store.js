angular.module('market-front').controller('storeController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8189/market/api/v1';
    let currentPage = 1;
    let totalPgs;

    $scope.loadProducts = function (pageIndex = currentPage) {
        currentPage = pageIndex;
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

    $scope.showInfo = function (product) {
        alert(product.title)
    }

    $scope.loadPreviousPage = function () {
        if (currentPage < 2) {
            alert("Вы находитесь на первой странице")
        } else {
            if (currentPage == 1) {
                $scope.loadProducts();
            } else {
                currentPage--;
                $scope.loadProducts();
            }
        }
    }

    $scope.loadNextPage = function () {
        if (currentPage > totalPgs - 1) {
            alert("Вы находитесь на последней странице")
        } else {
            if (currentPage == totalPgs) {
                $scope.loadProducts();
            } else {
                currentPage++;
                $scope.loadProducts();
            }
        }
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }
    
    $scope.navToEditProductPage = function (productId) {
        $location.path('/edit_product/' + productId);
    }

    $scope.saveToCart = function (productId) {

        $http({
            url: contextPath + '/cart/add',
            method: 'GET',
            params: {
                productIdToCart: productId
            }
        }).then(function successCallback (response) {
                console.log(response);
                alert("Продукт добавлен в корзину");
                productId = null;
            },
            function failCallback(response) {
                alert(response.data.messages);
            });
    }

    $scope.loadProducts(currentPage);

});

