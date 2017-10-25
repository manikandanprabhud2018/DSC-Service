package com.cargill.customerfacing.dscportal.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Inventory;
import com.cargill.customerfacing.dscportal.domain.QRCodeGenerate;
import com.cargill.customerfacing.dscportal.repository.InventoryRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class InventoryService {
	private Logger logger = LoggerFactory.getLogger(InventoryService.class);
	
	@Autowired
	InventoryRepository repository;
	
	@RequestMapping(
            value = "/inventoryList",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON)
    public List<Inventory> getInventoryList() {
    	logger.info(":::::::::: getInventoryList :::::::::::::::");
		return repository.getInventoryList();
    }
    @RequestMapping(
            value = "/inventory",
            method = RequestMethod.POST,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void saveInventory(@RequestBody Inventory inventory) {
    	logger.info(":::::::::: saveInventory :::::::::::::::");
    	repository.saveInventory(inventory);
	}
    @RequestMapping(
            value = "/inventory/{cakNo}",
            method = RequestMethod.PUT,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void updateInventory(@PathVariable("cakNo") String cakNo, @RequestBody Inventory inventory) {
    	logger.info(":::::::::: updateInventory :::::::::::::::");
    	repository.updateInventory(cakNo, inventory);
    }
    
    @RequestMapping(
            value = "/inventory/{pickupId}",
            method = RequestMethod.PUT,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void updateQRCode(@PathVariable("pickupId") String cakNo) {
    	logger.info(":::::::::: updateInventory :::::::::::::::");
    	//repository.updateInventory(cakNo,);
    }
    
	@RequestMapping(
			value = "/generateQRCode/{cakNo}",
			method = RequestMethod.GET,
			produces = "image/png", consumes= "image/png")
	public @ResponseBody byte[] generateQRCode(@PathVariable("cakNo") String pickupId, HttpServletResponse response) throws IOException, WriterException {
		logger.info(":::::::::: generateQRCode :::::::::::::::");
		//Payment payment = paymentRepository.getPaymentDocDownload(cakNo);
		//Inventory inventory = repository.getInventoryByPickupId(pickupId);
		String encodeValues = "Pickup Id: P123312; Cak No: 209080 ; Approved Quantity: 25011; ";
		String qrCodeData = "Hello World!";
		String charset = "UTF-8"; // or "ISO-8859-1"
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		
		BitMatrix matrix = new MultiFormatWriter().encode(
				new String(encodeValues.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, 200, 200, hintMap);
		MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(),baos, new MatrixToImageConfig());
		return baos.toByteArray();
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public @ResponseBody void downloadQRCode(HttpServletResponse response) throws IOException, WriterException {
		String encodeValues = "Contract Approved Qty Id: CAQ23312; Cak No: 209080 ; Approved Quantity: 25011; ";
		ByteArrayOutputStream out = QRCode.from(encodeValues).to(
                ImageType.PNG).stream();

        response.setContentType("image/png");
        response.setContentLength(out.size());

        OutputStream outStream = response.getOutputStream();

        outStream.flush();
        outStream.close();
		
	}
}
