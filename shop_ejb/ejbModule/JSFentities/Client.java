package JSFentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private int clientId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="adress_id")
	private Address address;

	//bi-directional many-to-one association to ClientOrder
	@OneToMany(mappedBy="client")
	private List<ClientOrder> clientOrders;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ClientOrder> getClientOrders() {
		return this.clientOrders;
	}

	public void setClientOrders(List<ClientOrder> clientOrders) {
		this.clientOrders = clientOrders;
	}

	public ClientOrder addClientOrder(ClientOrder clientOrder) {
		getClientOrders().add(clientOrder);
		clientOrder.setClient(this);

		return clientOrder;
	}

	public ClientOrder removeClientOrder(ClientOrder clientOrder) {
		getClientOrders().remove(clientOrder);
		clientOrder.setClient(null);

		return clientOrder;
	}

}