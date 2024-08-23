package com.example.makersharks.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.makersharks.entity.Supplier;


@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long>{

	@Query("Select s from Supplier s where s.location = :location AND s.natureOfBusinees = :natureOfBusiness AND s.manufacturingProcess = :manufacturingProcess")
	Page<Supplier> getSuppliers(@Param("location") String location,@Param("natureOfBusiness") String natureOfBusiness,@Param("manufacturingProcess") String manufacturingProcess,Pageable pageable);

}
