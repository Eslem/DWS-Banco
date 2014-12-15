


$(document).ready(function(){
    
    $(".nav ul").find("li").on("click","a",function(){
       $(".nav ul").find("li").children("a").removeClass("active");
        $(this).toggleClass("active");
        
    });
    
});