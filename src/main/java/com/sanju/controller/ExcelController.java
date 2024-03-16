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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanju.model.TrackingDetails;
import com.sanju.service.TrackingDetailsService;

import lombok.extern.java.Log;

@Controller
@Log
public class ExcelController {

	@Autowired
	private TrackingDetailsService trackingDetailsService;
	
	private static final String STATUS = "Status";
	private static final String SUCCESS = "Success";
	private static final String FAILURE = "Failure";

	@GetMapping("/upload")
	private String openUploadPage() {
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadFile(RedirectAttributes attributes,@RequestParam("file") MultipartFile file) throws IOException {
		List<TrackingDetails> saveTrackingDetails = null;
		String msg = null;
		if (!file.isEmpty()) {
			InputStream inputStream = file.getInputStream();
			if (inputStream!=null) {
				saveTrackingDetails = trackingDetailsService.saveTrackingDetails(inputStream);
			}
			if (saveTrackingDetails != null && saveTrackingDetails.size() != 0) {
				msg = "Record Inserted Count :: " + saveTrackingDetails.size();
				attributes.addFlashAttribute(STATUS, SUCCESS);
				attributes.addFlashAttribute("resultMsg", msg);
				log.info(msg);
			} else {
				msg = "Unable to Upload Data";
				attributes.addFlashAttribute(STATUS, FAILURE);
				attributes.addFlashAttribute("resultMsg", msg);
				log.warning(msg);
			}
			return "redirect:/upload";
		} else {
			msg = "File is Empty";
			attributes.addFlashAttribute(STATUS, FAILURE);
			attributes.addFlashAttribute("resultMsg", msg);
			return "redirect:/upload";
		}
	}
}
