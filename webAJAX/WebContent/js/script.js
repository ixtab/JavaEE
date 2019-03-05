function llamadaAjax() {     
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
    	document.getElementById("resultado").innerHTML = "Cargando...";
        if (xhr.readyState == 4) {
            if (xhr.status == 200)
            	document.getElementById("resultado").innerHTML = xhr.responseText;
            else
            	document.getElementById("resultado").innerHTML = "Error AJAX";
        }
    }

    var url = "Triangulo";
    var l1 = document.getElementById("lado1").value;
    var l2 = document.getElementById("lado2").value;
    var l3 = document.getElementById("lado3").value;
    var parametros = "?lado1=" + l1 + "&lado2=" + l2 + "&lado3=" + l3;
    url = url + parametros;
    
    xhr.open("GET", url); // Configurar la solicitud
    xhr.send(); // Enviar la solicitud al servidor
}