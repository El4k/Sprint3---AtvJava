package br.com.compass.pb.sprint3.atv1.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String login;
	private String password;
	private BigDecimal valueBuy;
	private Double valueFee;
	private Integer deadline;
	
    @OneToOne
	private Address address;
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products;

	public User() {}

	public User(String login, String password, Address address){
		this.login = login;
		this.password = password;
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}
	
	public BigDecimal getValueBuy() {
		return valueBuy;
	}

	public void setValueBuy(BigDecimal valueBuy) {
		this.valueBuy = valueBuy;
	}

	public Double getValueFee() {
		return valueFee;
	}

	public void setValueFee(Double valueFee) {
		this.valueFee = valueFee;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "<b>Road: </b>"+address.getRoad()+"<br><b>Number House: </b>"+address.getNumberHouse()+"<br><b>City: </b>"+address.getCity()
		+"<br><b>State: </b>"+address.getState()+"<br><b>CEP: </b>"+address.getCEP();
	}
	
	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}