package ehdokasservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
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
}
