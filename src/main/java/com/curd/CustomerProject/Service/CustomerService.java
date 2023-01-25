/**
 * 
 */
package com.curd.CustomerProject.Service;

import java.util.List;

import com.curd.CustomerProject.Model.Customer;
import com.curd.CustomerProject.Response.ResponseVo;
import com.curd.CustomerProject.dto.CustomerDTO;

/**
 * @author Giri_
 *
 */
public interface CustomerService {

	List<Customer> getCustomerByCustomerId(Integer customerId);

	List<Customer> getAllCustomer();

	ResponseVo addCustomer(CustomerDTO customerDTO);

	ResponseVo deleteCustomer(Integer customerId);

	ResponseVo getCustomerByAge();

}
