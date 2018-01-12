package com.leanstacks.ws.web.api;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leanstacks.ws.model.Employee;
import com.leanstacks.ws.model.Greeting;
import com.leanstacks.ws.repository.EmployeeRepository;
import com.leanstacks.ws.service.GreetingService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeController {
	
	    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	 @Autowired
	    private transient EmployeeRepository employeeServise;
	 /**
	     * Web service endpoint to fetch all Greeting entities. The service returns the collection of Greeting entities as
	     * JSON.
	     * 
	     * @return A ResponseEntity containing a Collection of Greeting objects.
	     */
	    @ApiOperation(value = "${GreetingController.getGreetings.title}",
	            notes = "${GreetingController.getGreetings.notes}",
	            response = Greeting.class,
	            responseContainer = "List")
	    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization",
	            value = "Basic auth_creds",
	            required = true,
	            dataType = "string",
	            paramType = "header"))
	    @RequestMapping(value = "/api/employee",
	            method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Collection<Employee>> getGreetings() {
	        logger.info("> getGreetings");

	        final Collection<Employee> employee = employeeServise.findAll();

	        logger.info("< getGreetings");
	        return new ResponseEntity<Collection<Employee>>(employee, HttpStatus.OK);
	    }


}
