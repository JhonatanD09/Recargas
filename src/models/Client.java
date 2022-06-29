package models;

public class Client {

	private Long id,phoneNumber;
	private double amount;

	public Client(Long id, Long phoneNumber, double amount) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
