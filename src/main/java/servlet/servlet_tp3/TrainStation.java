/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author flvivet
 */

@Entity
@Table
public class TrainStation implements Serializable {
    
    /*@Embeddable
    public class Address implements Serializable{
        protected String road; 
        protected String city;
        protected int postal_code; 
        
        public Address(String road, String city, int postal_code) {
            this.road = road;
            this.city = city;
            this.postal_code = postal_code;
        }
        
        public Address() {
        }
    }*/
    
    @Id
    @Column
    private int id;
    @Column
    private String name;
    /*@Embedded
    private Address address;*/
    @Column
    private String road;
    @Column
    private String city;
    @Column
    private int postal_code;
    @Column
    private float price;
    @JoinColumn
    @ManyToOne(optional=true)
    private Line line ;

    public TrainStation() {
    }


    public TrainStation(int id, String name, String road, String city, int postal_code, float price) {
        this.id = id;
        this.name = name;
        //this.address = new Address(road, city, postal_code);
        this.road = road;
        this.city = city;
        this.postal_code = postal_code;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(int postal_code) {
        this.postal_code = postal_code;
    }
    
    

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
