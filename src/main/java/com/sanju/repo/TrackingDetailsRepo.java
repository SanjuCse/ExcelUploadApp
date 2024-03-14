package com.sanju.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanju.model.TrackingDetails;

public interface TrackingDetailsRepo extends JpaRepository<TrackingDetails, Long> {

}
