$(()=>{
	var ruta = "https://reqres.in/api/users?delay=3";
	var resultado;
	$.ajax({
			contentType: "text/json",
        	url: ruta,
        	success: function(respuesta) {
        		resultado = respuesta;
        	},
        	error: function(e) {
            }
        });
	console.log(resultado);


})