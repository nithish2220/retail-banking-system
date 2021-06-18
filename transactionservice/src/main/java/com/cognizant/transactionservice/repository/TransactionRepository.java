package com.cognizant.transactionservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.transactionservice.models.Transaction;
/**
 * @author Dhananjay Batra
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
    /**
     * @param id
     * @param id2
     * @return List<Transaction>
     */
    List<Transaction> findBySourceAccountIdOrTargetAccountIdOrderByInitiationDate(long id , long id2);

	/**
	 * @param accId
	 * @return List<Transaction>
	 */
	List<Transaction> findByTargetAccountIdOrderByInitiationDate(long accId);

	/**
	 * @param i
	 * @return List<Transaction>
	 */
	List<Transaction> findBySourceAccountIdOrderByInitiationDate(int i);
}
