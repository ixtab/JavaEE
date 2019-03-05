/*
$(document).ready(function () {
    $("#comprobar").click(function () {
        var url = "Triangulo";
        var l1 = document.getElementById("lado1").value;
        var l2 = document.getElementById("lado2").value;
        var l3 = document.getElementById("lado3").value;
        var parametros = "?lado1=" + l1 + "&lado2=" + l2 + "&lado3=" + l3;
        url = url + parametros;
        $("#resultado").load(url);
    });
});
*/

$(()=> {									 // == $(document).ready(function ()
    $("#comprobar").click(function () {
        var ruta = "Triangulo";
        var l1 = document.getElementById("lado1").value;
        var l2 = document.getElementById("lado2").value;
        var l3 = document.getElementById("lado3").value;
        var parametros = "?lado1=" + l1 + "&lado2=" + l2 + "&lado3=" + l3;
        ruta = ruta + parametros;
        
        $.ajax({
        	url: ruta,
        	success: function(respuesta) {
        		$("#resultado").html(respuesta);
        	},
        	error: function(e) {
        		$("#resultado").text("Error ajax");
        		$("#resultado").css("width", "600px");
        		$("#resultado").css("background", "#eee");
        		$("#resultado").html( e.responseText);
            }
        });
    });
});

