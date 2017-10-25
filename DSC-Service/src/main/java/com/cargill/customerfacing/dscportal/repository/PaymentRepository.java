package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Payment;

@Repository
public class PaymentRepository {

	private Logger logger = LoggerFactory.getLogger(PaymentRepository.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Payment> getPaymentList(final String cakNo) {
		logger.info("::::::::::::: getPaymentList :::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.PAYMENT_SELECT_QUERY, new Object[] {cakNo}, new BeanPropertyRowMapper<Payment>(Payment.class));
	}
	
	public void savePayment(final Payment payment) {
		logger.info("::::::::::::: savePayment :::::::::::::::::::::::::");
	}
	
	public Payment getPaymentDocDownload(String cakNo) {
		return jdbcTemplate.queryForObject(DSCConstands.PAYMENT_SELECT_DOWNLOAD_QUERY, new Object[] {cakNo}, new BeanPropertyRowMapper<Payment>(Payment.class));
	}
}
