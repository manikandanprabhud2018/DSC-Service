package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Inventory;

@Repository
public class InventoryRepository {
	
	private Logger logger = LoggerFactory.getLogger(InventoryRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Inventory> getInventoryList() {
		logger.info(":::::::::::::::::::::: getInventoryList repository ::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.INVENTORY_SELECT_QUERY, new BeanPropertyRowMapper<Inventory>(Inventory.class));
	}
	public void saveInventory(final Inventory inventory) {
		logger.info(":::::::::::::::::::::: saveInventory repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.INVENTORY_INSERT_QUERY,new Object[] {inventory.getCargo(),inventory.getTrucksNo(),inventory.getBargeNo(),inventory.getTimeIn(),inventory.getWeightIn(),inventory.getTimeOut(),inventory.getWeightOut(),inventory.getTotalWeight(),inventory.getPacking(),inventory.getMode(),inventory.getLocation(),inventory.getPickupId(),inventory.getCakNo(),inventory.getContractType()});
	}
	public void updateInventory(final String cakNo, final Inventory inventory) {
		logger.info(":::::::::::::::::::::: updateInventory repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.INVENTORY_UPDATE_QUERY,new Object[] {inventory.getCargo(),inventory.getTrucksNo(),inventory.getBargeNo(),inventory.getTimeIn(),inventory.getWeightIn(),inventory.getTimeOut(),inventory.getWeightOut(),inventory.getTotalWeight(),inventory.getPacking(),inventory.getMode(),inventory.getLocation(),inventory.getPickupId(),inventory.getCakNo(),inventory.getContractType()}, new Object[] {cakNo});
	}
	
	public Inventory getInventoryByPickupId(final String pickupId) {
		return jdbcTemplate.queryForObject(DSCConstands.INVENTORY_SELECT_PICKUPID_QUERY, new BeanPropertyRowMapper<Inventory>(Inventory.class));
	}
}
