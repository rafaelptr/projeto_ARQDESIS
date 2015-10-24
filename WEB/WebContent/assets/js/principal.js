$(document).ready(function(){
	$('#language_page option[value="'+$("#idiomaSelecionado").val()+'"]').prop("selected","selected");
	$('#language_page').change(function(){
		pathArray = location.href.split( '/' );
		protocol = pathArray[0];
		host = pathArray[2];
		url = protocol + '//' + host + "/"+pathArray[3];
		$.ajax({
			method: "POST",
			url: url+"/IdiomaControl",
			cache:false,
			data: {"idioma" : $(this).val()}
		})
		.success(function(resposta){
			location.reload();
		});
	});
});


$(document).ready(function(){
$("#consultarVoo").click(function(){
	
	$.ajax({
		url: "./BuscarVooJson",
		data:{
			origem: $("#origem").val(),
			destino:$("#destino").val(),
		},
		method:"GET",
	}).success(function(data){
		if(data != undefined){
			$("#VooId option").remove();
			for(var i =0 ; i < data.length ; i++){
				var aux = "<option rel='"+data[i].preco+"' value='"+data[i].id+"'>["+data[i].codigo+"]"+data[i].nome+"[ R$ <span class='preco'>"+data[i].preco+"</span>]</option>"; 
				$("#VooId").append(aux);
			}
		}
	}).error(function(data){
		alert("Erro ao buscar dados");
	});

});
	$("#addPassageiro").click(function(){
		var nome = $("#nTd").text();
		var aux = "	<div class=\"form-group\">"
		  +"<label class=\"col-md-4 control-label\" for=\"\"></label>"  
		  +"<div class=\"col-md-3\">"
		  +"<input class='form-control input-md nome'  name=\"passageiro[].nome\" placeholder='"+nome+"'>"
		  +"<br />"
		  +"<input class='form-control input-md'  name=\"passageiro[].cpf\" placeholder='CPF' >"
		+"</div>"
		+"</div>";
		$("#passageirosForm").append(aux);
		
		var td =  parseInt($("#passageirosForm").find('.nome').length);
		var $selected = $("#VooId").find(":selected");
		var pc =  parseFloat($selected.attr('rel'));
		var total = parseFloat(td* pc);
		$("#totalBilhetes").text("R$ "+total);
	});
});