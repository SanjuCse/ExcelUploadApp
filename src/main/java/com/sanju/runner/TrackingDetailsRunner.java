package com.sanju.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanju.model.TrackingDetails;
import com.sanju.service.TrackingDetailsService;

import lombok.extern.java.Log;

@Log
//@Component
public class TrackingDetailsRunner implements CommandLineRunner {

	@Autowired
	private TrackingDetailsService trackingDetailsService;

	@Override
	public void run(String... args) throws Exception {
//		List<TrackingDetails> savedTrackingDetails = trackingDetailsService
//				.saveTrackingDetails("C:\\Users\\sanju\\Downloads\\Tracking_details.xlsx");
//		long count = savedTrackingDetails.stream().count();
//		log.info("Data saved with " + count + " records");
	}

}
