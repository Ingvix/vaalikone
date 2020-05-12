package ehdokasservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.EhdokasDao;
import persist.Ehdokkaat;

@Path("/")
public class EhdokasService {

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> getAll() {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vaalikones");
			EntityManager em = emfactory.createEntityManager();
			Query query = em.createNamedQuery("Ehdokkaat.findAll");
			List<Ehdokkaat> ehdokkaat = (List<Ehdokkaat>) query.getResultList();
			em.close();
			return ehdokkaat;
	}
	
	@GET
	@Path("/getEhdokas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ehdokkaat getEhdokas(@PathParam("id") int id) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vaalikones");
			EntityManager em = emfactory.createEntityManager();
			Query query = em.createNamedQuery("Ehdokkaat.findByEhdokasId");
			query.setParameter("ehdokasId", id);
			List<Ehdokkaat> ehdokasList = (List<Ehdokkaat>) query.getResultList();
			Ehdokkaat ehdokas = ehdokasList.get(0);
			em.close();
			return ehdokas;
	}

	@POST
	@Path("/addehdokas")
	@Consumes("application/x-www-form-urlencoded")
	public Response addEhdokas(@FormParam("etunimi") String etunimi, @FormParam("sukunimi") String sukunimi, 
			@FormParam("ika") int ika, @FormParam("puolue") String puolue, 
			@FormParam("kotipaikkakunta") String kotipaikkakunta, @FormParam("ammatti") String ammatti, 
			@FormParam("miksiEduskuntaan") String miksiEduskuntaan, 
			@FormParam("MitaAsioitaHaluatEdistaa") String MitaAsioitaHaluatEdistaa) {
		Ehdokkaat ehdokas = new Ehdokkaat();
		ehdokas.setEtunimi(etunimi);
		ehdokas.setSukunimi(sukunimi);
		ehdokas.setPuolue(puolue);
		ehdokas.setIka(ika);
		ehdokas.setKotipaikkakunta(kotipaikkakunta);
		ehdokas.setAmmatti(ammatti);
		ehdokas.setMiksiEduskuntaan(miksiEduskuntaan);
		ehdokas.setMitaAsioitaHaluatEdistaa(MitaAsioitaHaluatEdistaa);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vaalikones");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokas);
		em.getTransaction().commit();
		em.close();

		
	    java.net.URI location;
	    Response response = null;
		try {
			location = new java.net.URI("/Ehdokaspaneeli");
		    response = Response.temporaryRedirect(location).build();
	} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
}
	
	@POST
    @Path("/delete/{id}")
    public boolean deleteEhdokas(@PathParam("id") int id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vaalikones");
		EntityManager em = emfactory.createEntityManager();
	       
	     
	        Ehdokkaat b=em.find(Ehdokkaat.class, id);
	        if (b!=null) {
	            em.getTransaction().begin();
	            em.remove(b);
	            em.getTransaction().commit();
	            
	        }
	  
	    
        return EhdokasDao.deleteEhdokas(id);
    }
}
