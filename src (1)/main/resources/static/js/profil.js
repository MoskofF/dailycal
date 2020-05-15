// function izmail() {
//     let red = document.getElementById("email");
//     let button = document.getElementById("btemail");
//
//     let opis = document.createElement("div");
//     let vlez = document.createElement("div");
//
//     opis.setAttribute("class", "col-1");
//     opis.innerHTML = "Ново:";
//
//     vlez.setAttribute("class", "col-2");
//
//     let zaza = document.createElement("input");
//     zaza.setAttribute("type", "email");
//     zaza.setAttribute("th:field", "*{email}");
//     zaza.setAttribute("placeholder", "Нов емаил");
//
//     vlez.appendChild(zaza);
//
//     red.appendChild(opis);
//     red.appendChild(vlez);
//
//     button.remove();
//
// }

$(document).ready(function(){
   $("#btemail").on("click", function(){
       if ($("#EmailDiv").hasClass( "d-none"))
            $("#EmailDiv").removeClass("d-none");
       else
           $("#EmailDiv").addClass("d-none");
        //$("#btemail").hide();
   });

    $("#btdata").on("click", function(){
        if ($("#datumDiv").hasClass( "d-none"))
            $("#datumDiv").removeClass("d-none");
        else
            $("#datumDiv").addClass("d-none");
        //$("#btemail").hide();
    });

    $("#bttezhina").on("click", function(){
        if ($("#tezhinaDiv").hasClass( "d-none"))
            $("#tezhinaDiv").removeClass("d-none");
        else
            $("#tezhinaDiv").addClass("d-none");
        //$("#btemail").hide();
    });

    $("#btvisina").on("click", function(){
        if ($("#visinaDiv").hasClass( "d-none"))
            $("#visinaDiv").removeClass("d-none");
        else
            $("#visinaDiv").addClass("d-none");
        //$("#btemail").hide();
    });

    $("#btcel").on("click", function(){
        if ($("#celDiv").hasClass( "d-none"))
            $("#celDiv").removeClass("d-none");
        else
            $("#celDiv").addClass("d-none");
        //$("#btemail").hide();
    });

    $("#btinstruktor").on("click", function(){
        if ($("#instruktorDiv").hasClass( "d-none"))
            $("#instruktorDiv").removeClass("d-none");
        else
            $("#instruktorDiv").addClass("d-none");
        //$("#btemail").hide();
    });

    $("#btishrana").on("click", function(){
        if ($("#ishranaDiv").hasClass( "d-none"))
            $("#ishranaDiv").removeClass("d-none");
        else
            $("#ishranaDiv").addClass("d-none");
        //$("#btemail").hide();
    });

    $("#bttrening").on("click", function(){
        if ($("#treningDiv").hasClass( "d-none"))
            $("#treningDiv").removeClass("d-none");
        else
            $("#treningDiv").addClass("d-none");
        //$("#btemail").hide();
    });
});