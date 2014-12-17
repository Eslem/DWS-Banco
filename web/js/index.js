


$(document).ready(function () {

    $(".nav ul a").click(function () {
        $("header .nav ul a.active").removeClass("active");
        $(this).addClass("active");
    });
    
 $(".carousel").carousel({
     interval:5000
 });

});

$(function () {
    $(window).scroll(function () {
        var scrollTop = $(window).scrollTop();
        if (scrollTop != 0)
            $('.nav').stop().animate({'opacity': '0.2'}, 400);
        else
            $('.nav').stop().animate({'opacity': '1'}, 400);
    });

    $('.nav').hover(
            function (e) {
                var scrollTop = $(window).scrollTop();
                if (scrollTop != 0) {
                    $('.nav').stop().animate({'opacity': '1'}, 400);
                }
            },
            function (e) {
                var scrollTop = $(window).scrollTop();
                if (scrollTop != 0) {
                    $('.nav').stop().animate({'opacity': '0.2'}, 400);
                }
            }
    );
});
