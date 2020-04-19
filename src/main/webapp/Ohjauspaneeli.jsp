<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, persist.Kysymykset"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
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
					 Numero: <input type="text" name="kysymysid"/> <br/>
						Kysymys: <input type="text" name="kysymys"/> <br/>
						<input type="submit" value="Lisää" />
						</form>
					
					<br>
					<br>
					
					 <h1>Kysymysten poisto</h1>
					<br>
					<form id="poistoLista" name="loginForm" method="post" action="KysymysPoisto">
						<%
						List<Kysymykset> kysymykset = (List<Kysymykset>)request.getAttribute("Kysymykset");
						for (Kysymykset kysymys : kysymykset) { %>
						<input type="checkbox" name="kysymys" value="<%= kysymys.getKysymysId() %>"><label> <%= kysymys.getKysymys() %></label><br>
						<%
						} 
						%>
						<input type="submit" value="Poista" />
					</form>
					
					
					
				   


        </div>

</body>
</html>