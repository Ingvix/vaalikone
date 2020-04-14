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

import persist.Kysymykset;

@WebServlet("/UusiKysymys")
public class UusiKysymys extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// read form fields
		Integer kysymysid = Integer.parseInt(request.getParameter("kysymysid"));
		String kysymys = request.getParameter("kysymys");
		
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "vaalikones" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );
	      
	      Kysymykset kysymykset = new Kysymykset( );
	      kysymykset.setKysymysId( kysymysid );
	      kysymykset.setKysymys( kysymys );
	      
	      entitymanager.persist( kysymykset );
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	      emfactory.close( );
		
	}

}