package com.sanju.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sanju.model.TrackingDetails;
import com.sanju.service.TrackingDetailsService;

import lombok.extern.java.Log;

@Controller
@Log
public class ExcelController {

	@Autowired
	private TrackingDetailsService trackingDetailsService;

	@GetMapping("/upload")
	private String openUploadPage() {
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		List<TrackingDetails> saveTrackingDetails = null;
		if (!file.isEmpty()) {
			InputStream inputStream = file.getInputStream();
			if (inputStream!=null) {
				saveTrackingDetails = trackingDetailsService.saveTrackingDetails(inputStream);
			}
			if (saveTrackingDetails != null && saveTrackingDetails.size() != 0) {
				log.info("Record Inserted Count :: " + saveTrackingDetails.size());
			} else {
				log.info("Unable to Upload Data");
			}
			return "redirect:/upload";
		} else {
			return "redirect:/error";
		}
	}
}
