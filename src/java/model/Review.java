/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dochu
 */
public class Review {
    private String id;
    private String name;
    private String email;
    private String product_id;
    private String concent;
    private String created;

    public Review() {
    }

    public Review(String id, String name, String email, String product_id, String concent, String created) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.product_id = product_id;
        this.concent = concent;
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getConcent() {
        return concent;
    }

    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", name=" + name + ", email=" + email + ", product_id=" + product_id + ", concent=" + concent + ", created=" + created + '}';
    }
    
    
    
}
