package JSFentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;

	private String city;

	private String country;

	@Column(name="home_nr")
	private int homeNr;

	@Column(name="local_nr")
	private int localNr;

	@Column(name="post_code")
	private String postCode;

	private String street;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="address")
	private List<Client> clients;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getHomeNr() {
		return this.homeNr;
	}

	public void setHomeNr(int homeNr) {
		this.homeNr = homeNr;
	}

	public int getLocalNr() {
		return this.localNr;
	}

	public void setLocalNr(int localNr) {
		this.localNr = localNr;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setAddress(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setAddress(null);

		return client;
	}

}