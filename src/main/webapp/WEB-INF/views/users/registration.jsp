<div>
    <h1>Registration</h1>
    <div class="w3-row">
        <div class="w3-third tablink w3-bottombar w3-padding w3-border-red">Step 1</div>
        <div class="w3-third tablink w3-bottombar w3-padding">Step 2</div>
    </div>

    <div id="Step1" class="w3-container city" ng-app="regApp" ng-controller="regStep1Ctrl">
        <form class="w3-container w3-card-4" action="/user">
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
                <label class="w3-text-green"><b>Repeat Password</b></label>
                <input class="w3-input w3-border" name="r_password" type="password" ng-model="r_password" required></p>
            <p>
                <a class="w3-btn w3-green w3-hover-light-grey" ng-click="checkExist()">Next</a></p>
        </form>
    </div>

    <div id="Step2" class="w3-container city" style="display:none">
        <h2>Paris</h2>
        <p>Paris is the capital of France.</p>
    </div>
</div>

<script>
    function openCity(evt, cityName) {
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
        evt.currentTarget.firstElementChild.className += " w3-border-red";
    }

    var regForm = angular.module('regApp',[]);
    regForm.controller('regStep1Ctrl', function ($scope, $http) {
        $scope.checkExist = function () {
            if($scope.username != undefined && $scope.email != undefined){
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
                        if(response.data.username == 0 && response.data.username == 0){
                            openCity(this, "Step2");
                        }
                        $scope.showUsernameError = response.data.username;
                        $scope.showEmailError = response.data.email;
                    });
            }
        };
    })
</script>
