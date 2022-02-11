/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;


/**
 *
 * @author flvivet
 */

@Entity
public class Travel {
    @Id
    private int id;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private TrainStation departureStation;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private TrainStation arrivalStation;
    private float price;

    public Travel(int id, TrainStation departureStation, TrainStation arrivalStation) {
        this.id = id;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.price = calcTotalPrice();
        
    }
    
    private float calcTotalPrice(){
        float totPrice = 0;
        List<TrainStation> stationsDepart = this.departureStation.getLine().getList();
        for(TrainStation station : stationsDepart) {
            if (station.getId() <= departureStation.getId()){
                totPrice += station.getPrice();
            }
        }
        
        List<TrainStation> stationsArrive = this.arrivalStation.getLine().getList();
        for(TrainStation station : stationsArrive) {
            if (station.getId() <= arrivalStation.getId()){
                totPrice += station.getPrice();
            }
        }
        return totPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
