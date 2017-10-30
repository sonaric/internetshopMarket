<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="container-fluid" style="background-color:#F44336;color:#fff;height:100px;">
    <h1>Spring Web Shop Application</h1>
    <h3>Find all that you need</h3>
</div>
<nav class="navbar navbar-default" data-spy="affix" data-offset-top="97">
    <div class="container-fluid" >
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/products">WEB SHOP</a>
        </div>
        <ul class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#" class="w3-large" data-toggle="modal" data-target="#myModal">Product category<i class="glyphicon glyphicon-menu-hamburger"></i></a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group" >
                    <input id="search-input" type="text" class="form-control" placeholder="Search">
                </div>
                <button class="btn btn-default" type="submit">
                    <i class="glyphicon glyphicon-search"></i>
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="" class="w3-large">Admin <span class="glyphicon glyphicon-lock"></span></a></li>
                </security:authorize>
                <li><a href="#" class="w3-large">Trash <span class="glyphicon glyphicon-shopping-cart"></span><span class="badge w3-red w3-large">0</span></a></li>
                <security:authorize access="isAnonymous()">
                    <li><a href="#" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-log-in w3-large"></span></a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle" ><span class="glyphicon glyphicon-user w3-large" style="letter-spacing: 1px;"> <security:authentication property="principal.username"/></span></a>
                        <ul class="dropdown-menu" style="background-color: green;">
                            <li><a class="dropdown-item" href="/user/profile"><span class="glyphicon glyphicon-home"> Profile</span></a></li>
                            <li class="divider"></li>
                            <li> <a class="dropdown-item" href="/logout"><span class="glyphicon glyphicon-log-out"> Log Out</span></a></li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>
        </ul>
    </div>
</nav>


<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog" style="width: auto;">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close w3-large" data-dismiss="modal" >&times;</button>
            <h4 class="modal-title">Goods Category</h4>
        </div>
        <div class="modal-body">
            <div class="w3-row">
                <div class="w3-col w3-container m4 l3">
                    <ul class="nav nav-pills nav-stacked">
                        <c:forEach var="category" begin="0" end="${categories.size()-1}">
                            <li><a data-toggle="pill" href="#menu${category}">${categories.get(category).getCategoryDescription().getName()}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="w3-col w3-container m8 l9">
                    <div class="tab-content">
                        <c:forEach var="step_i" begin="0" end="${categories.size()-1}">
                            <div id="menu${step_i}" class="tab-pane fade">
                                <div class="panel-group">
                                    <c:forEach items="${categories.get(step_i).getCategoryList()}" var="subcategory">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">${subcategory.getName()}</div>
                                            <div class="panel-body">
                                                <ul class="w3-ul w3-normal">
                                                    <c:forEach items="${subcategory.getSubCategories()}" var="item">
                                                        <li><a href="/products/category/${item.id}">${item.getName()}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>

<div class="modal fade" id="loginModal" style="position:absolute; z-index: 9999 !important;">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">SignIn</h4>
            </div>

            <div class="modal-body">
                <form name="logInForm" action="/products" method="post">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" value="" required>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="pwd" name="password" required>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" name="remember-me">
                            Remember me
                        </label>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="w3-button w3-block w3-green w3-section w3-padding">LogIn</button>
                    <a href="/user/register" class="w3-button w3-block w3-red w3-section w3-padding">SignUp</a>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>