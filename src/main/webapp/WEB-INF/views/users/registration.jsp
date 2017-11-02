<div>
    <h1>Registration</h1>
    <div class="w3-row">
        <div id = "ts1" class="w3-third tablink w3-bottombar w3-padding w3-border-red">Step 1</div>
        <div id = "ts2" class="w3-third tablink w3-bottombar w3-padding">Step 2</div>
    </div>
    <form id="user" method="post" action="/user/register"  ng-app="regApp" ng-controller="regStep1Ctrl">
    <div id="Step1" class="w3-container city">
        <div class="w3-container w3-card-4" >
            <h2 class="w3-text-green">Registration form</h2>
            <p>Fill the field</p>
            <p>
                <label class="w3-text-green"><b>Username</b><span style="color: red"> *</span>
                    <span style="color:red" ng-show="showUsernameError"> (User already exist)</span></label>
                <input class="w3-input w3-border" name="usename" type="text" ng-model="username" required></p>
            <p>
                <label class="w3-text-green"><b>E-mail</b><span style="color: red"> *</span><span style="color:red" ng-show="showEmailError"> (User with this email already exist)</span></label>
                <input class="w3-input w3-border" name="email" type="email" ng-model="email" required></p>
            <p>
                <label class="w3-text-green"><b>Password</b><span style="color: red">*</span></label>
                <input class="w3-input w3-border" name="password" type="password" ng-model="password" required></p>
            <p>
                <label class="w3-text-green">
                    <b>Repeat Password</b>  <span ng-show="password != undefined && password == r_password" class="w3-text-green glyphicon glyphicon-ok"></span>
                    <span ng-show="password != undefined  && r_password != undefined && password != r_password" style="color: red;">(Not equals)</span></label>
                <input class="w3-input w3-border" name="r_password" type="password" ng-model="r_password" required></p>
            <p>
                <a class="w3-btn w3-green w3-hover-light-grey" ng-click="checkExist()">Next</a></p>
        </div>
    </div>

    <div id="Step2" class="w3-container city" style="display:none">
        <div class="w3-container w3-card-4">
            <h2 class="w3-text-green">Registration form</h2>
            <p>Fill the field</p>
            <p>
                <label class="w3-text-green"><b>First name</b><span style="color: red"> *</span></label>
                <input class="w3-input w3-border" name="firstName" type="text" ng-model="firstName" required></p>
            <p>
                <label class="w3-text-green"><b>Last name</b><span style="color: red"> *</span></label>
                <input class="w3-input w3-border" name="lastName" type="text" ng-model="lastName" required></p>
            <p>
                <label class="w3-text-green"><b>Birthday</b></label>
                <input class="w3-input w3-border" name="birthday" type="date" ng-model="birthday"></p>
            <p>
                <label class="w3-text-green"><b>Phone number</b><span style="color: red">*</span></label>
                <input class="w3-input w3-border" name="phone" type="tel" ng-model="phone" required></p>
            <p>
                <label class="w3-text-green"><b>Address</b><span style="color: red">*</span></label>
                <input class="w3-input w3-border" name="address" type="text" ng-model="text" required></p>

            <p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <span ng-click = "backStep1Register()" class="w3-btn w3-blue w3-hover-light-grey">< Back</span><button class="w3-btn w3-green w3-hover-light-grey" type="submit">Accept</button></p>
        </div>
    </div>
    </form>
</div>

<script>
    function openCity(cityName) {
        var i, x, tablinks;
        x = document.getElementsByClassName("city");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < x.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" w3-border-red", "");
        }
        document.getElementById(cityName).style.display = "block";
    }

    var regForm = angular.module('regApp',[]);
    regForm.controller('regStep1Ctrl', function ($scope, $http) {
        $scope.checkExist = function () {
            if($scope.username != undefined && $scope.email != undefined){
                if($scope.password == $scope.r_password){
                var data = $.param({
                    username: $scope.username,
                    email: $scope.email
                });
                var config = {
                    headers : {
                        'Content-Type': undefined
                    }
                };

                $http.get('/user/validation?'+data)
                    .then(function (response) {
                        if(response.data.username == 0 && response.data.email == 0){
                            openCity("Step2");
                            document.getElementById('ts2').className+=" w3-border-red";
                        }
                        $scope.showUsernameError = response.data.username;
                        $scope.showEmailError = response.data.email;
                    });
            }}
        };
        $scope.backStep1Register = function () {
            openCity("Step1");
            document.getElementById('ts1').className+=" w3-border-red";

        };
    })
</script>
