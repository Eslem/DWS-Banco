$(document).ready(function () {

    /*  $("header .navbar-nav ul a").click(function () {
     $("header .navbar-nav ul a.active").removeClass("active");
     $(this).addClass("active");
     });*/


    $(".apem").mouseenter(function () {
        $(this).stop().animate({"top": "-5px"});
        $(this).find(".btn").fadeIn().delay(500);
    });
    $(".apem").mouseleave(function () {
        $(this).stop().animate({"top": "5px"});
        $(this).find(".btn").css({"display": "none"});
    });


    $(".carousel").carousel({
        interval: 5000
    });


    $(window).scroll(function () {
        var scrollTop = $(window).scrollTop();
        if (scrollTop != 0)
            $('header .navbar').css('opacity', 1);
        else {
            $('header .navbar').css('opacity', '');
        }
    });
});
