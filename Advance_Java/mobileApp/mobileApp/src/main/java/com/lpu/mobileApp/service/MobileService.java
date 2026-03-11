package com.lpu.mobileApp.service;

import java.util.List;

import com.lpu.mobileApp.dto.MobileDTO;
import com.lpu.mobileApp.entity.Mobile;

public interface MobileService {
	
	MobileDTO saveMobile(MobileDTO dto);
	
	List<Mobile> findAllMobiles();
	
	Mobile findMobileById(int id);
	
	MobileDTO updateMobileById(int id, MobileDTO dto);
	
	void deleteMobileById(int id);
	
	List<MobileDTO> findMobileByBrandName(String brandName);
}
