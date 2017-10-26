<div id="footer" xmlns:jsp="http://java.sun.com/JSP/Page"
     xmlns:spring="http://www.springframework.org/tags" version="2.0">
    <div id="back-top" class="page_up text-center align-middle">
        <a href="">
            <span class=" glyphicon glyphicon-chevron-up"><p>Up</p></span>
        </a>
    </div>
    <div style="background-color: green; height: 50px; width: auto; margin-top: 50px;"></div>
</div>
<style>
    .page_up{
        height: 50px;
        width: 50px;
        position: fixed;
        bottom: 50px;
        right: 30px;

    }

    .page_up .glyphicon {
        height: 50px;
        width: 50px;
        font-size: 20px;
        color: green;
        border: 2px solid green;
        border-radius: 50%;
        background-color: white;
    }

    .page_up .glyphicon:hover {
        color: white;
        background-color: green;
    }
</style>
<script>
    $(document).ready(function(){
        $(function (){
            $("#back-top").hide();
            $(window).scroll(function (){
                if ($(this).scrollTop() > 100){
                    $("#back-top").fadeIn();
                } else{
                    $("#back-top").fadeOut();
                }
            });
            $("#back-top a").click(function (){
                $("body,html").animate({
                    scrollTop:0
                }, 800);
                return false;
            });
        });
    });
</script>
