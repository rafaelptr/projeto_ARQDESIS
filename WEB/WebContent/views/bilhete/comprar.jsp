<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="to.*"%>
<form class="form-horizontal" action='ComprarBilhete' method='POST'>
	<fieldset>
	
	<%
		ListagemAeroportoTO  aeroportos = new ListagemAeroportoTO(); 
		ListagemVooTO voos = new ListagemVooTO();
		if(request.getAttribute("voos")!=null){
			voos = (ListagemVooTO) request.getAttribute("voos");
		}	
		if(request.getAttribute("aeroportos")!=null){
			aeroportos = (ListagemAeroportoTO) request.getAttribute("aeroportos");
		}	
	%>
	<legend><%= Idioma.para(request, "Comprar Bilhete")%></legend>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	<div class="form-group">
	  <label class="col-md-4 control-label" for="origem"><%= Idioma.para(request,"origem")%></label>  
	  <div class="col-md-3">
		<select class='form-control input-md' id="origem">
		<option value="0"><%= Idioma.para(request, "selecionar_origem") %></option>
		<% for(AeroportoTO ae : aeroportos){ %>
			<option value="<%= ae.id %>">[<%= ae.codigo %>]&nbsp;<%= ae.nome %></option>
		<% } %>
		</select>
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="destino"><%= Idioma.para(request,"destino")%></label>  
	  <div class="col-md-3">
		<select class='form-control input-md' id="destino">
			<option value="0"> <%= Idioma.para(request, "selecionar_destino") %> </option>
			<% for(AeroportoTO ae : aeroportos){ %>
				<option value="<%= ae.id %>">[<%= ae.codigo %>]&nbsp;<%= ae.nome %></option>
			<% } %>
		</select>
	  </div>
	</div>
	<div class="form-group">
	<label class="col-md-4 control-label"></label>
	  <div class="col-md-3">
		<button type="button" class='consultar btn btn-default' id="consultarVoo" ><%= Idioma.para(request, "consultar") %></button>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="VooId"><%= Idioma.para(request,"voo")%></label>  
	  <div class="col-md-8">
		<select class='form-control input-md' id="VooId" name="VooId">
		</select>
	  </div>
	</div>
	
	<h4>Passageiros</h4>
	<hr /> 
	<div id='passageirosForm'>
	<div class="form-group">
	<label class="col-md-4 control-label"></label>
	  <div class="col-md-3">
		<button type="button" class='consultar btn btn-default' id="addPassageiro" ><%= Idioma.para(request, "adicionar_passageiro") %></button>
	  </div>
	</div>
	</div>
	
	</fieldset>
	<span style='display:none' id='nTd' ><%= Idioma.para(request, "nome") %></span>
	
	
	<div class="form-group">
	<label class="col-md-4 control-label"></label>
	  <div class="col-md-3">
		<label><%= Idioma.para(request, "total") %></label><span id='totalBilhetes'></span>
	  </div>
	</div>
	
<br/>
<h4>Cartão</h4>
<hr/>	
	<%
		CartaoTO cartao = new CartaoTO();
	%>
	<div class="form-group">
	<label class="col-md-4 control-label"><%= Idioma.para(request, "numero_cartao") %></label>
	  <div class="col-md-3">
	  	<input class='form-control input-md' name='cartao.numero' value='<%= (cartao.numero == 0 ?"":cartao.numero ) %>' placeholder='<%= Idioma.para(request, "numero_cartao") %>'/> 
	  </div>
	</div>
	
	<div class="form-group">
	<label class="col-md-4 control-label"><%= Idioma.para(request, "cod_seguranca") %></label>
	  <div class="col-md-3">
	  	<input class='form-control input-md' name='cartao.codigoSeguranca' value='<%= (cartao.codigoSeguranca == 0 ?"":cartao.codigoSeguranca ) %>' placeholder='<%= Idioma.para(request, "cod_seguranca") %>'/> 
	  </div>
	</div>
	
	
	<div class="form-group">
	<label class="col-md-4 control-label"></label>
	  <div class="col-md-3">
		<button type="submit" class='btn btn-success'  ><%= Idioma.para(request, "Comprar") %></button>
	  </div>
	</div>
</form>