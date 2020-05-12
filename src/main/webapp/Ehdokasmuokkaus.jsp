<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page
	import="java.util.List, persist.Ehdokkaat, ehdokasservice.EhdokasService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="ehdokaspaneeli.css" rel="stylesheet" type="text/css">
<script src="Ehdokasmuokkaus.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div id="container">

		<img id="headerimg" src="Logo.png" width="720" />
		<div class="kysymys">
			<h1>Ehdokaspaneeli</h1>
		</div>

		<%
		Ehdokkaat ehdokas = (Ehdokkaat) request.getAttribute("Ehdokas");
		int id = ehdokas.getEhdokasId();
		String etunimi = ehdokas.getEtunimi();
		String sukunimi = ehdokas.getSukunimi();
		String puolue = ehdokas.getPuolue();
		String paikkakunta = ehdokas.getKotipaikkakunta();
		int ika = ehdokas.getIka();
		String ammatti = ehdokas.getAmmatti();
		String miksiEduskuntaan = ehdokas.getMiksiEduskuntaan();
		String mitaAsioitaHaluatEdistaa = ehdokas.getMitaAsioitaHaluatEdistaa();
		%>
		<h1>Ehdokkaan muokkaus: <%=etunimi%> <%=sukunimi%></h1>

		<form id="kysymysForm" method="post" action="/ehdokasservice/editehdokas/<%=id%>">
			<table id="muokkausForm">
				<tr>
					<th class="lyhyt">Etunimi</th>
					<td class="text"><input type="text" name="etunimi" value="<%=etunimi%>" data-original="<%=etunimi%>" onkeyup="tarkistaVastaavuus(this)"></td>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<th class="lyhyt">Sukunimi</th>
					<td class="text"><input type="text" name="sukunimi" value="<%=sukunimi%>" data-original="<%=sukunimi%>" onkeyup="tarkistaVastaavuus(this)"></td>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<th class="lyhyt">Puolue</th>
					<td class="text"><input type="text" name="puolue" value="<%=puolue%>" data-original="<%=puolue%>" onkeyup="tarkistaVastaavuus(this)"></td>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<th class="lyhyt">Kotipaikkakunta</th>
					<td class="text"><input type="text" name="paikkakunta" value="<%=paikkakunta%>" data-original="<%=paikkakunta%>" onkeyup="tarkistaVastaavuus(this)"></td>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<th class="lyhyt">Ikä</th>
					<td class="text"><input type="text" name="ika" value="<%=ika%>" data-original="<%=ika%>" onkeyup="tarkistaVastaavuus(this)"></td>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<th class="lyhyt">Ammatti</th>
					<td class="text"><input type="text" name="ammatti" value="<%=ammatti%>" data-original="<%=ammatti%>" onkeyup="tarkistaVastaavuus(this)"></td>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<th colspan="2">Miksi eduskuntaan?</th>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<td colspan="3" class="text"><textarea name="miksiEduskuntaan" rows=4 data-original="<%=miksiEduskuntaan%>" onkeyup="tarkistaVastaavuus(this)"><%=miksiEduskuntaan%></textarea></td>
				</tr>
				<tr>
					<th colspan="2">Mitä asioita haluat edistää?</th>
					<td class="button"><button type="button" onclick="palauta(this)">Palauta</button></td>
				</tr>
				<tr>
					<td colspan="3" class="text"><textarea name="mitaAsioitaHaluatEdistaa" rows=4 data-original="<%=mitaAsioitaHaluatEdistaa%>" onkeyup="tarkistaVastaavuus(this)"><%=mitaAsioitaHaluatEdistaa%></textarea></td>
				</tr>
				<tr>
					<td colspan="3"><input id="tallennaBtn" type="submit" value='Tallenna muutokset'></td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>