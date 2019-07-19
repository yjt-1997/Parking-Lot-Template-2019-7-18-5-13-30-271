package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingOrderRepository extends JpaRepository<ParkingOrder, Integer> {
}
