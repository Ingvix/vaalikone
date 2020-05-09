<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, persist.Ehdokkaat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="ehdokaspaneeli.css" rel="stylesheet" type="text/css">
<script src="Ehdokaspaneeli.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div id="container">

		<img id="headerimg" src="Logo.png" width="720" />
		<div class="kysymys">
			<h1>Ehdokaspaneeli</h1>
		</div>

		<h1>Ehdokkaiden hallinta</h1>
		<table id="suodatus">
			<tr>
				<th colspan="3">Suodatus</th>
			</tr>
			<tr>
				<td class="text" colspan="3"><input id="suodatin" type="text" placeholder="Suodata ehdokkaita..." onkeyup="suodata()"></td>
			</tr>
			<tr>
				<td><label><input class="ehto" type="checkbox" value=2 checked>Nimi</label></td>
				<td><label><input class="ehto" type="checkbox" value=3 checked>Puolue</label></td>
				<td><label><input class="ehto" type="checkbox" value=4 checked>Paikkakunta</label></td>
			</tr>
			
		</table>
		<form id="kysymysForm" onsubmit="return tarkistaMuutokset()" method="post" action="Kysymyshallinta">
			<table id="kysymysLista">
				<tr id="tableHeader">
					<th class="index">#</th>
					<th id="poista">Poista</th>
					<th>Nimi</th>
					<th>Puolue</th>
					<th colspan="2">Paikkakunta</th>
				</tr>
				<tr>
					<td id="rullatd" colspan="5">
						<div id="rullaus">
							<table id="rullaLista">
								<%
									List<Ehdokkaat> ehdokkaat = (List<Ehdokkaat>) request.getAttribute("Ehdokkaat");
								String nimi;
								String puolue;
								String paikkakunta;
								int id;
								int i = 1;
								for (Ehdokkaat ehdokas : ehdokkaat) {
									nimi = ehdokas.getEtunimi() + " " + ehdokas.getSukunimi();
									puolue = ehdokas.getPuolue();
									paikkakunta = ehdokas.getKotipaikkakunta();
									id = ehdokas.getEhdokasId();
								%>
								<tr class="dataRow">
									<td class="index"><%=i%></td>
									<td class="checkbox"><input type="checkbox" name="kysymys" value="<%=id%>"></td>
									<td><label><%=nimi%></label></td>
									<td><label><%=puolue%></label></td>
									<td><label><%=paikkakunta%></label></td>
									<td class="button"><a href="http://localhost:8080/ehdokasservice/edit/<%=id%>"><button type="button">Muokkaa</button></a></td>
								</tr>
								<%
									i++;
								}
								%>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="6"><input id="tallennaBtn" type="submit" value="Poista ehdokkaita"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>