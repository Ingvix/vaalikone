package Ohjauspaneeli;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;

import persist.Kysymykset;

/**
 * Servlet implementation class KysymysPoisto
 */
@WebServlet("/KysymysPoisto")
public class KysymysPoisto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  EntityManagerFactory emfactory = null;
	  EntityManager em = null;
	  EntityTransaction etx = null; 
	  try {
		  emfactory = Persistence.createEntityManagerFactory( "vaalikones" );
		  em = emfactory.createEntityManager();
		  etx = em.getTransaction();
		  String[] kysymyspoistot = request.getParameterValues("kysymys");
		  
		  etx.begin();
		  for (String id : kysymyspoistot) {
			  
			  Query q = em.createQuery(
					  "DELETE FROM Kysymykset k WHERE k.kysymysId=?1");
			  q.setParameter(1, Integer.parseInt(id));
			  q.executeUpdate();

		  }
		  etx.commit();
		  em.close();
	  } catch (Exception e) {
		  etx.rollback();
		  em.close();
	  }
	  response.sendRedirect("Ohjauspaneeli");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
