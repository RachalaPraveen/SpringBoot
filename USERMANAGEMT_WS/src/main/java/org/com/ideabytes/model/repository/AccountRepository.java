package org.com.ideabytes.model.repository;

import org.com.ideabytes.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The AccountRepository interface is a Spring Data JPA data repository for
 * Account entities. The AccountRepository provides all the data access
 * behaviors exposed by <code>JpaRepository</code> and additional custom
 * behaviors may be defined in this interface.
 * 
 * @author Matt Warman
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Query for a single Account entities by username.
     * 
     * @param username The username value to query the repository.
     * @return An Account or <code>null</code> if none found.
     */
    Account findByUsername(String username);

}
