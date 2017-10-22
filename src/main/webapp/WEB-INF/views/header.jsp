<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" style="background-color:#F44336;color:#fff;height:100px;">
    <h1>Bootstrap Affix Example</h1>
    <h3>Fixed (sticky) navbar on scroll</h3>
    <p>Scroll this page to see how the navbar behaves with data-spy="affix".</p>
    <p>The navbar is attached to the top of the page after you have scrolled a specified amount of pixels.</p>
</div>
<nav class="navbar navbar-default" data-spy="affix" data-offset-top="97">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/products">WEB SHOP</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#" class="w3-large" data-toggle="modal" data-target="#myModal">Product category<i class="glyphicon glyphicon-menu-hamburger"></i></a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group" >
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button class="btn btn-default" type="submit">
                    <i class="glyphicon glyphicon-search"></i>
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="w3-large">Trash <span class="glyphicon glyphicon-shopping-cart"></span><span class="badge w3-red w3-large">0</span></a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in w3-large"></span></a></li>
            </ul>
        </div>
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
                                                        <li><a href="/products/category?id=${item.id}">${item.getName()}</a></li>
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