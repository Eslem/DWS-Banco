


$(document).ready(function () {

  /*  $("header .navbar-nav ul a").click(function () {
        $("header .navbar-nav ul a.active").removeClass("active");
        $(this).addClass("active");
    });*/
    
 $(".carousel").carousel({
     interval:5000
 });

});

$(function () {
    $(window).scroll(function () {
        var scrollTop = $(window).scrollTop();
        if (scrollTop != 0)
            $('header .navbar').stop().animate({'opacity': '1'}, 400);
        else
            $('header .navbar').stop().animate({'opacity': '0'}, 400);
    });

    $('header .navbar').hover(
            function (e) {
                var scrollTop = $(window).scrollTop();
                if (scrollTop != 0) {
                    $('header.navbar').stop().animate({'opacity': '0.5'}, 400);
                }
            },
            function (e) {
                var scrollTop = $(window).scrollTop();
                if (scrollTop != 0) {
                    $('header .navbar').stop().animate({'opacity': '1'}, 400);
                }
            }
    );
});
