package com.srai.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.srai.model.ClientMetadata;
@Repository
public interface ClientMetadataRepository  extends  JpaRepository<ClientMetadata, Long> {
	 /** Get collections of Person by name. */
	  ClientMetadata findById(@Param("id") String id);

}
