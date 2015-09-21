
<form class="form-horizontal" action='CadastrarAeronave' method='POST'>
	<fieldset>
	
	<legend><%= Idioma.para(request, "cadastrar_aeronave")%></legend>
	<a href="./ListagemAeronave" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="codigo"><%= Idioma.para(request,"codigo")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="codigo" name="codigo" placeholder="<%= Idioma.para(request,"codigo")%>" autofocus="autofocus" required="required" />
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="nome"><%= Idioma.para(request,"nome")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="nome" name="nome" placeholder="<%= Idioma.para(request,"nome")%>" autofocus="autofocus" required="required" />
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="qtd_assentos_A"><%= Idioma.para(request,"qtd_assentos_A")%></label>  
	  <div class="col-md-3">
		<input class='form-control input-md' id="qtd_assentos_A" name="qtd_assentos_A" placeholder="<%= Idioma.para(request,"qtd_assentos_A")%>" autofocus="autofocus" type="number" required="required"  />
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="qtd_assentos_B"><%= Idioma.para(request,"qtd_assentos_B")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="qtd_assentos_B" name="qtd_assentos_B" placeholder="<%= Idioma.para(request,"qtd_assentos_B")%>" autofocus="autofocus" type="number" required="required" />
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="qtd_assentos_C"><%= Idioma.para(request,"qtd_assentos_C")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="qtd_assentos_C" name="qtd_assentos_C" placeholder="<%= Idioma.para(request,"qtd_assentos_C")%>" autofocus="autofocus" type="number" required="required" />
	  </div>
	</div>
	
	<div class="form-group">
	  <div class="col-md-3 col-md-offset-4">
		<button class='btn btn-success' type="submit" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"salvar") %></button>
	  </div>
	</div>
	
	</fieldset>
</form>