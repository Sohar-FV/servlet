/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;


/**
 *
 * @author flvivet
 */

public class Travel {
    
    private TrainStation departureStation;
    private TrainStation arrivalStation;
    private float price;

    public Travel(TrainStation departureStation, TrainStation arrivalStation) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.price = departureStation.getPrice() + arrivalStation.getPrice();
    }

    public TrainStation getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(TrainStation departureStation) {
        this.departureStation = departureStation;
    }

    public TrainStation getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(TrainStation arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
