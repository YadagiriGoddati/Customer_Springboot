/**
 * 
 */
package com.curd.CustomerProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curd.CustomerProject.Model.Customer;


/**
 * @author Giri_
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	@Query("SELECT coalesce(max(c.customerId), 10000) FROM Customer c")
	int getMaxId();

	@Transactional
	@Modifying
	@Query("DELETE FROM Customer c WHERE c.customerId =:customerId")
	void deleteByCustomerId(@Param("customerId") Integer customerId);

}
