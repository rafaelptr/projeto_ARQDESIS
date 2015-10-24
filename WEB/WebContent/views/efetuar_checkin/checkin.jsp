<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="to.*"%>
<form class="form-horizontal" action='EfetuarCheckin' method='POST'>
	<fieldset>
	<legend><%= Idioma.para(request, "efetuar_checkin")%></legend>
	<div class='clear-fix'></div>
	<%
		BilheteTO bilhete = (BilheteTO)request.getAttribute("bilhete");
		if(bilhete == null)bilhete = new BilheteTO();
	%>
	<div class="form-group">
	  <label class="col-md-4 control-label" for="codigo"><%= Idioma.para(request,"codigo_bilhete")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="codigo" name="codigo" placeholder="<%= Idioma.para(request,"codigo_bilhete")%>" autofocus="autofocus" required="required" value="<%= bilhete.codigo %>" />
	  </div>
	</div>
	
	<div class="form-group">
	  <div class="col-md-3 col-md-offset-4">
		<button class='btn btn-success' type="submit" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"efetuar_checkin") %></button>
	  </div>
	</div>
	
	</fieldset>
</form>