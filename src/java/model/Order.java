/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ItemEvent;
import java.util.List;

/**
 *
 * @author dochu
 */
public class Order {
    private String id;
    private List<Item> items;
    private double sumPrice;
    private String created;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    
    public Order(String id, List<Item> items, double sumPrice, String created) {
        this.id = id;
        this.items = items;
        this.sumPrice = sumPrice;
        this.created = created;
    }
    
    
}
