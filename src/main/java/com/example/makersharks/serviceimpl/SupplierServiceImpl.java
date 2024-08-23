package com.example.makersharks.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.makersharks.entity.Supplier;
import com.example.makersharks.exception.EmptyException;
import com.example.makersharks.pagination.SupplierResponse;
import com.example.makersharks.repository.SupplierRepo;
import com.example.makersharks.service.SupllierService;

@Service
public class SupplierServiceImpl implements SupllierService{
	
	@Autowired
	private SupplierRepo suppRepo;

	@Override
	public SupplierResponse getAllSuppliers(String location, String natureOfBusiness, String manufactureProcess,
			Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
		Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
		
		Page<Supplier> suppliers=suppRepo.getSuppliers(location, natureOfBusiness, manufactureProcess, pageDetails);
		
		List<Supplier> orgsuppliers=suppliers.getContent();
		
		if(orgsuppliers.isEmpty()) {
			throw new EmptyException("Sorry Could not find the manufacturers");
		}
		SupplierResponse supplierResp=new SupplierResponse();
		supplierResp.setSuppliers(orgsuppliers);
		supplierResp.setPageNumber(suppliers.getNumber());
		supplierResp.setPageSize(suppliers.getSize());
		supplierResp.setTotalElements(suppliers.getTotalElements());
		supplierResp.setTotalPages(suppliers.getTotalPages());
		supplierResp.setLastPage(suppliers.isLast());
		return supplierResp;
	}

}
