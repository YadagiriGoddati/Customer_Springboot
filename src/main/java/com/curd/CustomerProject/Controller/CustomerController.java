/**
 * 
 */
package com.curd.CustomerProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curd.CustomerProject.Model.Customer;
import com.curd.CustomerProject.Response.ResponseVo;
import com.curd.CustomerProject.Service.CustomerService;
import com.curd.CustomerProject.dto.CustomerDTO;

import jakarta.websocket.server.PathParam;

/**
 * @author Giri_
 *
 */

@RestController
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	
	 @Autowired(required=true)
	CustomerService customerService;
	 @CrossOrigin
	@GetMapping(path="/getCustomer")
	public List<Customer> getCustomer(@RequestParam(value = "customerId", required = false) Integer customerId) {
		List<Customer> customerList = new ArrayList<>();
		
		if(customerId!=null) {
			customerList = customerService.getCustomerByCustomerId(customerId);
		}else {
			customerList = customerService.getAllCustomer();
		}
		
		logger.info("Inside getCustomer Method");
		return customerList;
	}
	
	 @CrossOrigin
	@PostMapping(path="/addCustomer" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVo addCustomer(@RequestBody CustomerDTO customerDTO) {
		ResponseVo response = new ResponseVo();
		
		response = customerService.addCustomer(customerDTO);
		
		logger.info("Inside addCustomer Method");
		
		return response;
	}
	 
	 @CrossOrigin
		@PostMapping(path="/updateCustomer/{customerId}" , produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseVo updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Integer customerId) {
			ResponseVo response = new ResponseVo();
			customerDTO.setCustomerId(customerId);
			response = customerService.addCustomer(customerDTO);
			
			logger.info("Inside addCustomer Method");
			
			return response;
		}
	 
	 
	@CrossOrigin
	@GetMapping(path="/deleteCustomer/{customerId}")
	public ResponseVo deleteCustomer(@PathVariable Integer customerId) {
		ResponseVo response = new ResponseVo();
		
		response = customerService.deleteCustomer(customerId);
		
		logger.info("Inside deleteCustomer Method");
		
		return response;
	}
	@CrossOrigin
	@GetMapping(path="/getCustomerByAge")
	public ResponseVo getCustomerByAge() {
		ResponseVo response = new ResponseVo();
		
		response = customerService.getCustomerByAge();
		
		logger.info("Inside getCustomerByAge Method");
		
		return response;
	}

}
