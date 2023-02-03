package net.javaguides.usermanagement.model;


public class Vehicle_Reservation {
	protected int id;
	protected String name;
	protected String number;
	protected String type;
	protected String Address;
	protected String sdate;
	protected String edate;
	
	public Vehicle_Reservation() {
	}
	
	public Vehicle_Reservation(String name, String number, String type, String Address, String sdate, String edate) {
		super();
		this.name = name;
		this.number = number;
		this.type = type;
		this.Address = Address;
		this.sdate = sdate;
		this.edate = edate;
	}

	public Vehicle_Reservation(int id, String name, String number, String type, String Address, String sdate, String edate) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.type = type;
		this.Address = Address;
		this.sdate = sdate;
		this.edate = edate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
}
