<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" ng-app="productList" ng-controller="productListCtrl">
    <div class="well">
        <div class="col-auto">
            <label class="mr-sm-2" for="sortSelect">Sort by</label>
            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="sortSelect" ng-model="selectData" ng-change="selectFilter()">
                <option selected="selected" value="priceup">Price Up</option>
                <option value="pricedown">Price Down</option>
            </select>
        </div>
    </div>
    <div class="row">
        <!----------------GOODS------------------>
        <div class="col-md-3" ng-repeat="product in productData">
            <div class="thumbnail">


                <a href="/products/{{product.id}}" target="_blank">
                    <img src="{{product.image}}" alt="Lights" style="width:150px;">

                </a>


                <div class="caption">
                    <p><b>{{product.description.name}}</b></p>
                </div>
                <div>
                    <span class="alert alert-warning"><b style="color: black;">{{product.price}} uah</b></span>
                    <button type="button" class="btn btn-success btn-lg">
                        <span class="glyphicon glyphicon-shopping-cart"></span>   Buy
                    </button>
                </div>

            </div>
        </div>
    </div>
</div>

<script>
    var appProduct = angular.module('productList',[]);
    appProduct.controller('productListCtrl',
    function ($scope, $http) {
        $http.get('rest/products/list?sort=none').then(function (responce) {
           $scope.productData=responce.data;

        });

        $scope.selectFilter=function () {
            $http.get('rest/products/list?sort='+$scope.selectData).then(function (responce) {
                $scope.productData=responce.data;
            });
        }
    });

</script>