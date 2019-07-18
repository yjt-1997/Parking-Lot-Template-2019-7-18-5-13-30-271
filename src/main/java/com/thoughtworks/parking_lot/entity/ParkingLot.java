package com.thoughtworks.parking_lot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    private String name;

    private int capacity;
    private String address;
    @OneToMany
    @JoinColumn(name = "parking_lot_name", referencedColumnName = "name")
    private List<ParkingOrder> parkingOrders;

    public ParkingLot() {
    }

    public ParkingLot(String name, int capacity, String address) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingOrder> getParkingOrders() {
        return parkingOrders;
    }

    public void setParkingOrders(List<ParkingOrder> parkingOrders) {
        this.parkingOrders = parkingOrders;
    }
}
