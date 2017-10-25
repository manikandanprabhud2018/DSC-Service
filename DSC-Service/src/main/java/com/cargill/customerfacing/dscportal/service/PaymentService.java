package com.cargill.customerfacing.dscportal.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Payment;
import com.cargill.customerfacing.dscportal.repository.PaymentRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class PaymentService {

	private Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;

	@RequestMapping(
			value = "/paymentList/{cakNo}",
			method = RequestMethod.GET,
			produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public List<Payment> getPaymentList(@PathVariable("cakNo") String cakNo) {
		logger.info(":::::::::: getPaymentList :::::::::::::::");
		return paymentRepository.getPaymentList(cakNo);
	}
	@RequestMapping(
			value = "/payment",
			method = RequestMethod.POST, headers = {"content-type=application/json"})
	public void savePayment(@RequestBody Payment payment) {
		logger.info(":::::::::: savePayment :::::::::::::::");
		logger.info(":::::::::: savePayment :::::::::::::::"+ payment.getCakNo());
		logger.info(":::::::::: savePayment :::::::::::::::"+ payment.getFile().getBytes());
		logger.info(":::::::::: savePayment :::::::::::::::"+ payment.getFile().getName());
		logger.info(":::::::::: savePayment :::::::::::::::"+ payment.getFile().getSize());
		paymentRepository.savePayment(payment);

		//paymentRepository.savePayment();
	}
	@RequestMapping(
			value = "/download/{cakNo}",
			method = RequestMethod.GET,
			produces = DSCConstands.APPLICATION_PDF, consumes= DSCConstands.APPLICATION_PDF)
	public HttpEntity<byte[]> getPaymentDocDownload(@PathVariable("cakNo") String cakNo, HttpServletResponse response) throws IOException {
		logger.info(":::::::::: getPaymentList :::::::::::::::");
		//Payment payment = paymentRepository.getPaymentDocDownload(cakNo);
		response.setContentType(DSCConstands.APPLICATION_PDF);
		//response.setHeader("Content-Disposition", "inline;filename=\"" + payment.getFile().getName());
		response.setHeader("Content-Disposition", "inline;filename=\"" + "TEST");
		OutputStream outputStream = response.getOutputStream(); 
		//outputStream.write(payment.getFile().getBytes());
		outputStream.write("Any String you want".getBytes());
		outputStream.flush();
		outputStream.close();
		return null;
	}
}
