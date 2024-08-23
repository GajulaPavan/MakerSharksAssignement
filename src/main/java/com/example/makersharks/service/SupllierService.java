package com.example.makersharks.service;

import com.example.makersharks.pagination.SupplierResponse;

public interface SupllierService {
	
	SupplierResponse getAllSuppliers(String location,String natureOfBusiness,String manufactureProcess,Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

}
