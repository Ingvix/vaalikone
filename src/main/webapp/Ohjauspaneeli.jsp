<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, persist.Kysymykset"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<script src="Ohjauspaneeli.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div id="container">

		<img id="headerimg" src="Logo.png" width="720" />
		<div class="kysymys">
			<h1>Ohjauspaneeli</h1>
		</div>
		<br>
		<h1>Kysymyksen lisäys</h1>
		<br>
		<form name="loginForm" method="post" action="UusiKysymys">
			Numero: <input type="text" name="kysymysid" /> <br />
			Kysymys: <input type="text" name="kysymys" /> <br /> <input type="submit" value="Lisää" />
		</form>

		<br> <br>

		<h1>Kysymysten hallinta</h1>
		<form id="kysymysForm" onsubmit="return tarkistaMuutokset()"
			method="post" action="KysymysPoisto">
				<table id="kysymysLista">
					<tr id="tableHeader">
						<th class="index">#</th>
						<th>Poista</th>
						<th colspan="2">Kysymys</th>
					</tr>
					<%
				List<Kysymykset> kysymykset = (List<Kysymykset>) request.getAttribute("Kysymykset");
				String q;
				int id;
				int i = 1;
				for (Kysymykset kysymys : kysymykset) {
					q = kysymys.getKysymys();
					id = kysymys.getKysymysId();
					%>
					<tr class="dataRow">
						<td class="index"><%= i %></td>
						<td class="checkbox"><input type="checkbox" name="kysymys"
							value="<%= id %>"></td>
						<td class="text"><input type="text" name="<%= id %>"
							value="<%= q %>" data-original="<%= q %>"
							onkeyup="tarkistaVastaavuus(this)"></td>
						<td class="button"><button type="button"
								onclick="palautaKysymys(this)">Palauta</button></td>
					</tr>
					<%
					i++;
				} 
				%>
				</table>
			<input type="submit" value="Tallenna muutokset">
		</form>
	</div>

</body>
</html>