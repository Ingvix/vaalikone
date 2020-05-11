package Ohjauspaneeli;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;
import persist.Ehdokkaat;

public class Ehdokasmuokkaus extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	  String id = (String) request.getAttribute("id");
	  String uri = "http://localhost:8080/ehdokasservice/getEhdokas/" + id;
	  Client client = ClientBuilder.newClient();
	  WebTarget wt = client.target(uri);
	  Builder b = wt.request();
	  GenericType<Ehdokkaat> gEhdokas = new GenericType<Ehdokkaat>() {};

	  try {
		  Ehdokkaat ehdokas = b.get(gEhdokas);

		  request.setAttribute("Ehdokas", ehdokas);
		  request.getRequestDispatcher("/Ehdokasmuokkaus.jsp").forward(request, response);
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  
  }
}
