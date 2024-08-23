package com.example.makersharks.entity;

//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="supplier_id")
	private Long supplierId;
	
	@Column(name="company_name")
	private String companyName;
	
	private String website;
	
	@Size(min=2,max=100, message="Please enter valid location")
	private String location;
	
	@Column(name="nature_of_business")
	@Pattern(regexp = "small_scale|medium_scale|large_scale", message = "Please Enter Correct Nature Of Business")
	private String natureOfBusinees;
	
	@Column(name="manufacturing_process")
	@Pattern(regexp = "moduling|3d_printing|casting|coating", message = "Please Enter Correct manufcaturing process")
	private String manufacturingProcess;

	public Supplier() {
		
	}

	public Supplier(Long supplierId, String companyName, String website, String location,
			@Pattern(regexp = "small_scale|medium_scale|large_scale", message = "Please Enter Correct Nature Of Business") String natureOfBusinees,
			@Pattern(regexp = "moduling|3d_printing|casting|coating", message = "Please Enter Correct manufcaturing process") String manufacturingProcess) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
		this.website = website;
		this.location = location;
		this.natureOfBusinees = natureOfBusinees;
		this.manufacturingProcess = manufacturingProcess;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNatureOfBusinees() {
		return natureOfBusinees;
	}

	public void setNatureOfBusinees(String natureOfBusinees) {
		this.natureOfBusinees = natureOfBusinees;
	}

	public String getManufacturingProcess() {
		return manufacturingProcess;
	}

	public void setManufacturingProcess(String manufacturingProcess) {
		this.manufacturingProcess = manufacturingProcess;
	}
	
	
	
	
	

}
