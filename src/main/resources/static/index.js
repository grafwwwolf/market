(function () {
    angular
        .module('market-front', ['ngRoute'])
        .config(config)
        .run(run);
    
    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/edit_product/:productId', {
                templateUrl: 'edit_product/edit_product.html',
                controller: 'editProductController'
            })
            .when('/create_product', {
                templateUrl: 'create_product/create_product.html',
                controller: 'createProductController'
            })
            .when('/cart', {
                templateUrl: 'cart/cart.html',
                controller: 'cartController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }
    
    function run($rootScope, $http) {
        
    }
})();


angular.module('market-front').controller('indexController', function ($rootScope, $scope, $http) {
    const contextPath = 'http://localhost:8189/market/api/v1';
});

//
//     const contextPath = 'http://localhost:8189/market/api/v1';
//     let currentPage = 1;
//     let totalPgs;
//
//     $scope.loadProducts = function (pageIndex = currentPage) {
//         currentPage = pageIndex;
//         $http({
//             url: contextPath + '/products',
//             method: 'GET',
//             params: {
//                 page: pageIndex
//             }
//         }).then(function (response) {
//             console.log(response);
//             $scope.productsPage = response.data;
//             $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
//             totalPgs = response.data.totalPages;
//
//         });
//     }
//
//     $scope.removeProduct = function (product) {
//         $http.delete(contextPath + '/products/' + product.id)
//             .then(function successCallback(response) {
//                     console.log(response);
//                     $scope.loadProducts(currentPage);
//                 },
//                 function failCallback(response) {
//                     alert(response.data.message);
//                 });
//     }
//
//     $scope.showInfo = function (product) {
//         alert(product.title)
//     }
//
//     $scope.loadPreviousPage = function () {
//         if (currentPage < 2) {
//             alert("Вы находитесь на первой странице")
//         } else {
//             if (currentPage == 1) {
//                 $scope.loadProducts();
//             } else {
//                 currentPage--;
//                 $scope.loadProducts();
//             }
//         }
//     }
//
//     $scope.loadNextPage = function () {
//         if (currentPage > totalPgs - 1) {
//             alert("Вы находитесь на последней странице")
//         } else {
//             if (currentPage == totalPgs) {
//                 $scope.loadProducts();
//             } else {
//                 currentPage++;
//                 $scope.loadProducts();
//             }
//         }
//     }
//
//     $scope.createNewProduct = function () {
//         $http.post(contextPath + '/products', $scope.new_product)
//             .then(function successCallback(response) {
//                     $scope.loadProducts(currentPage);
//                     $scope.new_product = null;
//                 },
//                 function failCallback(response) {
//                     alert(response.data.message);
//                 });
//     }
//
//     $scope.prepareProductForUpdate = function (productId) {
//         $http.get(contextPath + '/products/' + productId)
//             .then(function successCallback(response) {
//                     $scope.upd_product = response.data;
//                 },
//                 function failCallback(response) {
//                     alert(response.data.message);
//                 });
//     }
//
//     $scope.updateProduct = function () {
//         $http.put(contextPath + '/products', $scope.upd_product)
//             .then(function successCallback(response) {
//                     $scope.loadProducts(currentPage);
//                     $scope.upd_product = null;
//                 },
//                 function failCallback(response) {
//                     alert(response.data.message);
//                 });
//     }
//
//     $scope.generatePagesIndexes = function (startPage, endPage) {
//         let arr = [];
//         for (let i = startPage; i < endPage + 1; i++) {
//             arr.push(i);
//         }
//         return arr;
//     }
//
//     $scope.loadProducts(currentPage);
//
// });

