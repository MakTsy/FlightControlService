package com.flight.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Date departureDate;
    private Date arrivalDate;
    private String departing;
    private String arriving;
    private Date checkInOpens;
    private String status;
    private int economClassSeat;
    private int firstClassSeat;
    private int businessClassSeat;
    private float economClassPrice;
    private float firstClassPrice;
    private float businessClassPrice;

    public Flight() {
    }

    public Flight(Date departureDate, Date arrivalDate, String departing, String arriving, Date checkInOpens, String status,
                  int economClassSeat, int firstClassSeat, int businessClassSeat, float economClassPrice,
                  float firstClassPrice, float businessClassPrice) {
        this.arrivalDate = arrivalDate;
        this.arriving = arriving;
        this.businessClassPrice = businessClassPrice;
        this.businessClassSeat = businessClassSeat;
        this.departing = departing;
        this.departureDate = departureDate;
        this.checkInOpens = checkInOpens;
        this.status = status;
        this.economClassSeat = economClassSeat;
        this.economClassPrice = economClassPrice;
        this.firstClassPrice = firstClassPrice;
        this.firstClassSeat = firstClassSeat;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getCheckInOpens() {
        return checkInOpens;
    }

    public String getArriving() {
        return arriving;
    }

    public String getDeparting() {
        return departing;
    }


    public String getStatus() {
        return status;
    }

    public float getClassPrice(String clas) {
        if (clas.equals("Econom")) {
            return this.economClassPrice;
        }
        if (clas.equals("First")) {
            return this.firstClassPrice;
        }
        if (clas.equals("Busieness")) {
            return this.businessClassPrice;
        }
        return 0;
    }

    public int getClassSeat(String clas) {
        if (clas.equals("Econom")) {
            return this.economClassSeat;
        }
        if (clas.equals("First")) {
            return this.firstClassSeat;
        }
        if (clas.equals("Busieness")) {
            return this.businessClassSeat;
        }
        return 0;
    }

    public void changeClassSit(String clas) {
        if (clas.equals("Econom")) {
            this.economClassSeat -= 1;
        }
        if (clas.equals("First")) {
            this.firstClassSeat -= 1;
        }
        if (clas.equals("Business")) {
            this.businessClassSeat -= 1;
        }
    }


}
