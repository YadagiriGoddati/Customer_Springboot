/**
 * 
 */
package com.curd.CustomerProject.dto;

/**
 * @author Giri_
 *
 */
public class CustomerDTO {

	private String firstName;
	private String lastName;
	private Integer customerId;
	private Integer age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "CustomerDTO [firstName=" + firstName + ", lastName=" + lastName + ", customerId=" + customerId
				+ ", age=" + age + "]";
	}
	
	
	
}
