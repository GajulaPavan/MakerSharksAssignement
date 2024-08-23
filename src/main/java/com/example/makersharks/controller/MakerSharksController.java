package com.example.makersharks.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.makersharks.entity.Supplier;
import com.example.makersharks.pagination.SupplierResponse;
import com.example.makersharks.repository.SupplierRepo;
import com.example.makersharks.service.SupllierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/supplier")
public class MakerSharksController {
	
	@Autowired
	private SupllierService supplierService;
	
	@Autowired
	private SupplierRepo supplierRepo;
	
	@PostMapping("/query")
	public ResponseEntity<SupplierResponse> getAllSuppl(
	        @RequestParam(name = "location", required = false) String location,
	        @RequestParam(name = "natureOfBusiness", required = false) String natureOfBusiness,
	        @RequestParam(name = "manufacturingProcess", required = false) String manufacturingProcess,
	        @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
	        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
	        @RequestParam(name = "sortBy", defaultValue = "supplierId") String sortBy,
	        @RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder) {
//        location=location.toLowerCase();
	    SupplierResponse suppResp = supplierService.getAllSuppliers(location, natureOfBusiness, manufacturingProcess, pageNumber, pageSize, sortBy, sortOrder);
	    return new ResponseEntity<>(suppResp, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Supplier supplier,BindingResult result){
		if (result.hasErrors()) {
			List<String> errorMessages = result.getFieldErrors()
	                .stream()
	                .map(DefaultMessageSourceResolvable::getDefaultMessage)
	                .collect(Collectors.toList());
	        return ResponseEntity.badRequest().body(errorMessages);
	    }
		 supplierRepo.save(supplier);
		return new ResponseEntity<String>("Added succesfuly",HttpStatus.CREATED);
		
	}
	

}
