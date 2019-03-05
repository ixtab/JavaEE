onload=llamadaAjax;

function llamadaAjax(fichero) {     
    var xhr = new XMLHttpRequest();
    var agenda;
    var resultado = "";
    var lineas = {};
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
            	agenda = JSON.parse(xhr.responseText);
            	resultado = "<table>";
            	for (var i in agenda) {
            		resultado = resultado + "<tr>";
            		resultado = resultado + "<td>" + agenda[i].nombre + "</td>";
            		resultado = resultado + "<td>" + agenda[i].tlf + "</td>";
            		resultado = resultado + "<td>" + agenda[i].domicilio + "</td>";
            		resultado = resultado + "</tr>";
            		lineas[i] = agenda[i];
            	}
            	resultado = resultado + "</table>";
            	document.getElementById("agenda").innerHTML = resultado;
            	console.log(lineas);
            }
            else {
            	resultado = "No se ha podido leer el archivo JSON";
            }
        }
    }
 
    var url = "agenda.json";
    xhr.open("GET", url);
    xhr.send();
}