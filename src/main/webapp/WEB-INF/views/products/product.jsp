
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div>
        <h1>${product.description.name}</h1>
        <img src="${product.image}"/>
    </div>
    <div ng-app="productView" ng-controller="viewCtrl">
        <div ng-repeat="x in imagesData">
            <img src="{{x.image}}"/>
        </div>
    </div>
</div>
<script>
    var appVar=angular.module('productView',[]);
    appVar.controller('viewCtrl',
    function ($scope, $http) {
        $http.get('/rest/products/${product.id}').then(
            function (responce) {
                $scope.imagesData=responce.data;
            }
        )
    })
</script>
