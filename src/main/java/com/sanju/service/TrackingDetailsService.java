package com.sanju.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanju.model.TrackingDetails;
import com.sanju.repo.TrackingDetailsRepo;
import com.sanju.util.ExcelUtil;

@Service
public class TrackingDetailsService {
	@Autowired
	private TrackingDetailsRepo trackingDetailsRepo;

	@Autowired
	private ExcelUtil excelUtil;

	public List<TrackingDetails> saveTrackingDetails(String excelFilePath)
			throws EncryptedDocumentException, IOException {
		List<TrackingDetails> trackingDetailsData = null;
		if (excelFilePath != null && !excelFilePath.isBlank()) {
			trackingDetailsData = excelUtil.getTrackingDetailsData(excelFilePath);
		}
		if (trackingDetailsData != null && trackingDetailsData.size() != 0) {
			trackingDetailsData = trackingDetailsRepo.saveAll(trackingDetailsData);
		}
		return trackingDetailsData;
	}
}
