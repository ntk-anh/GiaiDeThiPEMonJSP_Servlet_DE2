package Q1;

import java.sql.Date;

public class Employee {

	private int id;
	private String name;
	private int gender;
	private Date dob;

	public Employee() {

	}

	public Employee(int id, String name, int gender, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String toGender() {
		if (gender==1) {
			return "nam";
		}else {
			return "nữ";
		}
	}
}
