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

public class Ehdokaspaneeli extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

	  String uri = "http://localhost:8080/ehdokasservice/getall";
	  Client client = ClientBuilder.newClient();
	  WebTarget wt = client.target(uri);
	  Builder b = wt.request();
	  GenericType<List<Ehdokkaat>> gList = new GenericType<List<Ehdokkaat>>() {};

	  try {
		  List<Ehdokkaat> ehdokkaat = b.get(gList);

		  request.setAttribute("Ehdokkaat", ehdokkaat);
		  request.getRequestDispatcher("/EhdokasPaneeli.jsp").forward(request, response);
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  
  }
}
