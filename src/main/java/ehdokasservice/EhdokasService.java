package ehdokasservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	@POST
	@Path("/addehdokas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void addEhdokas(@FormParam("etunimi") String etunimi, @FormParam("sukunimi") String sukunimi, 
			@FormParam("ika") int ika, @FormParam("puolue") String puolue, 
			@FormParam("kotipaikkakunta") String kotipaikkakunta, @FormParam("ammatti") String ammatti, 
			@FormParam("miksiEduskuntaan") String miksiEduskuntaan, 
			@FormParam("MitaAsioitaHaluatEdistaa") String MitaAsioitaHaluatEdistaa, @Context HttpServletRequest request, @Context HttpServletResponse response) {
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
//        File file=new File("ehdokkaat.dat");
//		ArrayList<Ehdokkaat> ehdokkaat=new ArrayList<>();
//		 try {
//	            ehdokkaat.add(ehdokas);
//	            FileOutputStream fos=new FileOutputStream(file);
//	            ObjectOutputStream oos=new ObjectOutputStream(fos);
//	            oos.writeObject(ehdokkaat);
//	            oos.close();
//	            fos.close();
//	        }
//	        catch(FileNotFoundException e) {
//	           
//	        } catch (IOException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
		
		try {
			response.sendRedirect("EhdokasPaneeli.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("/EhdokasPaneeli.jsp");
			//rd.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
