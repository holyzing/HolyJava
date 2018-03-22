package com.holy.service;

import java.util.List;

import com.holy.entity.Items;

public interface ItemsService {

	List<Items> findAll();

	Items findByID(Integer id);

	void saveOrUpdate(Items items);

	void deleteByID(Integer id);

}
