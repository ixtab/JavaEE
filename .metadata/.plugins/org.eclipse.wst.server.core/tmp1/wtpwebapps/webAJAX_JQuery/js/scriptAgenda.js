$(document).ready(function () {
	var agenda;
    $.ajax({ 
    	contentType: "text/json",
        url: "agenda.json", 
        success: function (agenda) { 
        	resultado = "<table>";
        	for (var i in agenda) {
        		resultado = resultado + "<tr>";
        		resultado = resultado + "<td>" + agenda[i].nombre + "</td>";
        		resultado = resultado + "<td>" + agenda[i].tlf + "</td>";
        		resultado = resultado + "<td>" + agenda[i].domicilio + "</td>";
        		resultado = resultado + "</tr>";
        	}
        	resultado = resultado + "</table>";
            $('#agenda').html(resultado);
        }
    });
});
