/**
 * 
 */
package com.curd.CustomerProject.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.CustomerProject.Model.Customer;
import com.curd.CustomerProject.Repository.CustomerRepository;
import com.curd.CustomerProject.Response.ResponseVo;
import com.curd.CustomerProject.Service.CustomerService;
import com.curd.CustomerProject.dto.CustomerDTO;

/**
 * @author Giri_
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	private static final Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public List<Customer> getCustomerByCustomerId(Integer customerId) {
		List<Customer> customerList = new ArrayList<>(1);
		Optional<Customer> customerOptional  = customerRepository.findById(customerId);
		if(customerOptional.isPresent()){
			customerList.add(customerOptional.get());
		}
		return customerList;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public ResponseVo addCustomer(CustomerDTO customerDTO) {
		ResponseVo response = new ResponseVo();
		try {
		Customer customer = new Customer();
		if(customerDTO.getCustomerId()!=0) {
			customer.setCustomerId(customerDTO.getCustomerId());
		}else {
			customer.setCustomerId(customerRepository.getMaxId()+1);
		}
		
		customer.setAge(customerDTO.getAge());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		
		customerRepository.save(customer);
		
		response.setStatus(200);
		response.setMessage("Successfully Saved");
		}catch (Exception e) {
			logger.debug("Exception in addCustomer",e);
			response.setStatus(500);
			response.setMessage("Error in adiing customer");
		}
		return response;
	}

	@Override
	public ResponseVo deleteCustomer(Integer customerId) {
		ResponseVo response = new ResponseVo();
		List<Customer> customerList = getCustomerByCustomerId(customerId);
		customerRepository.deleteByCustomerId(customerId);
		response.setStatus(200);
		response.setMessage("Successfully Deleted "+customerList.get(0).getFirstName()+" "+customerList.get(0).getLastName());
		return response;
	}

	@Override
	public ResponseVo getCustomerByAge() {
		ResponseVo response = new ResponseVo();
		List<Customer> customerList = customerRepository.findAll();
		customerList = customerList.stream().filter(e->e.getAge()>25).collect(Collectors.toList());
		response.setData(customerList);
		return response;
	}

}
