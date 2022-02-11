/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.servlet_tp3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author flvivet
 */

@Entity
@Table
public class Line implements Serializable {
    
    @Id
    private int id;
    @OneToMany(cascade=CascadeType.ALL,
               fetch=FetchType.LAZY,
               mappedBy="line")
    private List<TrainStation> list;

    public Line() {
        list = new ArrayList<>();
    }
    
    public void addStation(TrainStation station) {
        this.list.add(station);
    }
    
    public List<TrainStation> getList() {
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
}