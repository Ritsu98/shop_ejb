package jsfshopDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import JSFentities.Client;

@Stateless
public class ClientDAO {

	EntityManager em;
	
	public void create(Client client) {
		em.persist(client);
	}

	public Client merge(Client client) {
		return em.merge(client);
	}

	public void remove(Client client) {
		em.remove(em.merge(client));
	}

	public Client find(Object id) {
		return em.find(Client.class, id);
	}
}
