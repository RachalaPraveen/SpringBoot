package org.com.ideabytes.service.bean;

import org.com.ideabytes.model.Account;
import org.com.ideabytes.model.repository.AccountRepository;
import org.com.ideabytes.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The AccountServiceBean encapsulates all business behaviors for operations on the Account entity model and some
 * related entities such as Role.
 * 
 * @author Matt Warman
 */
@Service
public class AccountServiceBean implements AccountService {

    /**
     * The Logger for this Class.
     */
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceBean.class);

    /**
     * The Spring Data repository for Account entities.
     */
    @Autowired
    private transient AccountRepository accountRepository;

    @Override
    public Account findByUsername(final String username) {
        logger.info("> findByUsername");
        final Account account = accountRepository.findByUsername(username);

        logger.info("< findByUsername");
        return account;
    }

}
