package com.sanju.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class TrackingDetails {
	@Id
	@Column(name = "TRACKING_DETAILS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "LAN_NO", length = 25)
	private String lanNo;
	
	@Column(name = "TRACK_ID", length = 15)
	private String trackId;
	
	@Column(name = "DATE")
	private LocalDate date;
	
	@Column(name = "STATUS", length = 5000)
	private String status;
	
	@Column(name = "DELIVERY_STATUS", length = 20)
	private String deliveryStatus;
	
	@Column(name = "MSISDN", length = 20)
	private Double msisdn;
}
