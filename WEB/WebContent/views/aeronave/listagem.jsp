
<%@page import="java.util.ArrayList"%>
<%@page import="model.Aeronave"%>
<legend><%= Idioma.para(request, "consultar_aeronave")%></legend>
<a href="./CadastrarAeronave" class='btn btn-success'><i class='glyphicon glyphicon-plus'></i>&ensp;Cadastrar</a>
<br/>
<div class='clear-fix'></div>
<br/>
<table class='table table-condensed table-bordered table-stripped'>
	<thead>
		<tr>
			<th>
				<%= Idioma.para(request,"codigo") %>
			</th>
			<th>
				<%= Idioma.para(request,"nome") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_a") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_b") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_c") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_verticais") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_horizontais") %>
			</th>
			<th>
				<%= Idioma.para(request,"total_assentos") %>
			</th>
			<th>
			</th>
		</tr>
	</thead>
	<tbody>
		<%
			ArrayList<Aeronave> lista = (ArrayList<Aeronave>)request.getAttribute("lista");
			if(lista != null){
				for(Aeronave aeronave : lista ){
					%>
					<tr>
						<td><%=aeronave.getCodigo() %></td>
						<td><%=aeronave.getNome() %></td>
						<td><%=aeronave.getQtd_assentos_A()%></td>
						<td><%=aeronave.getQtd_assentos_B() %></td>
						<td><%=aeronave.getQtd_assentos_C() %></td>
						<td><%=aeronave.getQtd_assentos_verticais() %></td>
						<td><%=aeronave.getQtd_assentos_horizontais() %></td>
						<td><%=aeronave.getTotal_assentos() %></td>
						<td>
							<a href="./DetalhesAeronave?id=<%=aeronave.getId()%>"><i class="glyphicon glyphicon-eye-open"></i></a>
							<a href="./AlterarAeronave?id=<%=aeronave.getId()%>"><i class="glyphicon glyphicon-pencil"></i></a>
							<a href="./RemoverAeronave?id=<%=aeronave.getId()%>"><i class="glyphicon glyphicon-trash"></i></a>
						</td>
					</tr>
					<%
				}
			}
		%>
	</tbody>
</table>