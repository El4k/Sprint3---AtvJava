package br.com.compass.pb.sprint3.atv1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String road;
	private Integer numberHouse;
	private String city;
	private String state;
	private String CEP;

	public Address() {
	}

	public Address(String road, Integer numberHouse, String city, String state, String CEP) {
		this.road = road;
		this.numberHouse = numberHouse;
		this.city = city;
		this.state = state;
		this.CEP = CEP;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public Integer getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(Integer numberHouse) {
		this.numberHouse = numberHouse;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	@Override
	public String toString() {
		return "<br>Road: <br>" + road;
	}

}