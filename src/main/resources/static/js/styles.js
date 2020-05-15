$(document).on("scroll", function(){
        if
        ($(document).scrollTop() > 86){
            $("#banner").addClass("shrink");
        }
        else
        {
            $("#banner").removeClass("shrink");
        }
});

function otvori() {
        var x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
}