$(document).ready(function () {

    /*  $("header .navbar-nav ul a").click(function () {
     $("header .navbar-nav ul a.active").removeClass("active");
     $(this).addClass("active");
     });*/



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
