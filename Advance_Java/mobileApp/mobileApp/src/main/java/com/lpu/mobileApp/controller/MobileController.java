package com.lpu.mobileApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.mobileApp.dto.MobileDTO;
import com.lpu.mobileApp.entity.Mobile;
import com.lpu.mobileApp.service.MobileServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RequestMapping("/api")
@RestController
@Tag(name = "Mobile Controller", description = "APIs for managing mobiles")
public class MobileController {

	@Autowired
	private MobileServiceImpl service;

	@Autowired
	private ModelMapper modelMapper;

	@Operation(summary = "Add mobile to the database",
			description = "Adding a mobile")
	@PostMapping("/mobiles")
	public ResponseEntity<MobileDTO> saveMobile(@Valid @RequestBody MobileDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMobile(dto));
	}

	@Operation(summary = "Get all mobiles",
			description = "Fetch all mobiles")
	@GetMapping("/mobiles")
	public List<MobileDTO> findAll() {
		List<MobileDTO> dtolist = new ArrayList<MobileDTO>();
		List<Mobile> mobilelist = service.findAllMobiles();

		for (Mobile mobile : mobilelist) {
			MobileDTO dto = new MobileDTO();

			dto.setBrandName(mobile.getBrandName());
			dto.setModelName(mobile.getModelName());
			dto.setPrice(mobile.getPrice());
			dto.setRam(mobile.getRam());
			dto.setStorage(mobile.getStorage());
			dto.setColor(mobile.getColor());
			
			dtolist.add(dto);
		}

		return dtolist;
	}

	@Operation(summary = "Get mobile by ID",
			description = "Fetch a single mobile using its ID")
	@GetMapping("/mobiles/{id}")
	public MobileDTO findMobileById(@PathVariable int id) {
		Mobile mobile = service.findMobileById(id);
		return modelMapper.map(mobile, MobileDTO.class);
	}
	
	@Operation(summary = "Update mobile by ID",
			description = "Fetch a single mobile using its ID and update it")
	@PutMapping("/mobiles/{id}")
	public MobileDTO updateMobileById(@PathVariable int id, @Valid @RequestBody MobileDTO dto) {
		return service.updateMobileById(id, dto);
	}
	
	@Operation(summary = "Delete mobile by ID",
			description = "Delete a single mobile using its ID")
	@DeleteMapping("/mobiles/{id}")
	public void deleteMobileById(@PathVariable int id) {
		service.deleteMobileById(id);
	}
	
	@Operation(summary = "Get mobile by Brand Name",
			description = "Fetch a single mobile using its Brand Name")
	@GetMapping("/mobiles/search")
	public List<MobileDTO> getMobileByBrandName(@RequestParam("brandName") String brandName) {
		return service.findMobileByBrandName(brandName);
	}
}
