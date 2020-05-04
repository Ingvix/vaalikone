package Ohjauspaneeli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.Query;
import java.util.List;
import persist.Kysymykset;

public class Ohjauspaneeli extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	  EntityManagerFactory emfactory = null;
	  EntityManager em = null;
	  try {
		  emfactory = Persistence.createEntityManagerFactory( "vaalikones" );
		  em = emfactory.createEntityManager();
		  Query query = em.createNamedQuery("Kysymykset.findAll");
		  List<Kysymykset> kysymykset = (List<Kysymykset>) query.getResultList();
		  request.setAttribute("Kysymykset", kysymykset);
		  request.getRequestDispatcher("/Ohjauspaneeli.jsp").forward(request, response);
	  } catch (Exception e) {
		  em.close();
	  }
  }
}
