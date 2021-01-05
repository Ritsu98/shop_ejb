package JSFentities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	private String name;

	private double prize;

	//bi-directional many-to-one association to ClientOrder
	@OneToMany(mappedBy="product")
	private List<ClientOrder> clientOrders;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrize() {
		return this.prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public List<ClientOrder> getClientOrders() {
		return this.clientOrders;
	}

	public void setClientOrders(List<ClientOrder> clientOrders) {
		this.clientOrders = clientOrders;
	}

	public ClientOrder addClientOrder(ClientOrder clientOrder) {
		getClientOrders().add(clientOrder);
		clientOrder.setProduct(this);

		return clientOrder;
	}

	public ClientOrder removeClientOrder(ClientOrder clientOrder) {
		getClientOrders().remove(clientOrder);
		clientOrder.setProduct(null);

		return clientOrder;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}