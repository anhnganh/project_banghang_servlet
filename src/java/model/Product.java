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
public class Product {
    private String id;
    private String catalog_id;
    private String name;
    private String price;
    private String status;
    private String description;
    private String content;
     private String discount;
    private String image_link;
    private String created;
   

    public Product() {
    }

    public Product(String id, String catalog_id, String name, String price, String status, String description, String content,
            String discount, String image_link, String created) {
        this.id = id;
        this.catalog_id = catalog_id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.description = description;
        this.content = content;
        this.discount = discount;
        this.image_link = image_link;
        this.created = created;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", catalog_id=" + catalog_id + ", name=" + name + ", price=" + price + ", status=" + status + ", description=" + description + ", content=" + content + ", image_link=" + image_link + ", created=" + created + ", discount=" + discount + '}';
    }

   
    
    
   
    
            
}
