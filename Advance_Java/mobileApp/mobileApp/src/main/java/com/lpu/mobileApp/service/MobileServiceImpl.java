package com.lpu.mobileApp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.mobileApp.dto.MobileDTO;
import com.lpu.mobileApp.entity.Mobile;
import com.lpu.mobileApp.exception.ResourceNotFounddException;
import com.lpu.mobileApp.repository.MobileRepository;



@Service
public class MobileServiceImpl implements MobileService{
	
	@Autowired
	private MobileRepository repository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public MobileDTO saveMobile(MobileDTO dto) {
		Mobile mobile = modelMapper.map(dto, Mobile.class);
		
		Mobile saveMobile = repository.save(mobile);
		
		return modelMapper.map(saveMobile, MobileDTO.class);
	}
	
	@Override
	@Cacheable(value = "mobile")
	public List<Mobile> findAllMobiles() {
		return repository.findAll();
	}
	
	@Override
	@Cacheable(value = "mobile", key = "#id")
	public Mobile findMobileById(int id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFounddException("Mobile with id " + id + " not found"));
	}
	
	@Override
	@CachePut(value = "mobile", key = "#id")
	public MobileDTO updateMobileById(int id, MobileDTO dto) {

	    Mobile mobile = findMobileById(id);

	    mobile.setBrandName(dto.getBrandName());
	    mobile.setModelName(dto.getModelName());
	    mobile.setPrice(dto.getPrice());
	    mobile.setRam(dto.getRam());
	    mobile.setStorage(dto.getStorage());
	    mobile.setColor(dto.getColor());

	    Mobile updatedMobile = repository.save(mobile);

	    return modelMapper.map(updatedMobile, MobileDTO.class);
	}
	
	@Override
	@CacheEvict(value = "mobile", key = "#id")
	public void deleteMobileById(int id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<MobileDTO> findMobileByBrandName(String brandName) {
		return repository.findByBrandName(brandName)
	            .stream()
	            .map(mobile -> modelMapper.map(mobile, MobileDTO.class))
	            .toList();
	}
	
}
