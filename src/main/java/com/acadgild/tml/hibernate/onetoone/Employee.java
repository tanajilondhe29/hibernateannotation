package com.acadgild.tml.hibernate.onetoone;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
 
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long employeeId;
     
    @Column(name="firstname")
    private String firstname;
     
    @Column(name="lastname")
    private String lastname;
     
    @Column(name="dob")
    private Date birthDate;
     
    @Column(name="phone")
    private String phone;
 
    @OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
    private EmployeeDetail employeeDetail;
     
    public Employee() {
         
    }
     
    public Employee(String firstname, String lastname, Date birthdate, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthdate;
        this.phone = phone;
    }

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname="
				+ firstname + ", lastname=" + lastname + ", birthDate="
				+ birthDate + ", phone=" + phone + ", employeeDetail="
				+ employeeDetail + "]";
	}
 
    
}
