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
public class Transactions {
    private int id;
    private String user_session;
    private String user_name;
    private String user_email;
    private String user_phone;
    private String address;
    private String message;
    private String amount;
    private String payment;
    private String status;
    private String created;

    public Transactions() {
    }

    public Transactions(int id, String user_session, String user_name, String user_email, String user_phone, String address, String message, String amount, String payment, String status, String created) {
        this.id = id;
        this.user_session = user_session;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.address = address;
        this.message = message;
        this.amount = amount;
        this.payment = payment;
        this.status = status;
        this.created = created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_session(String user_session) {
        this.user_session = user_session;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getUser_session() {
        return user_session;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }

    public String getAmount() {
        return amount;
    }

    public String getPayment() {
        return payment;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated() {
        return created;
    }
    
    
    
}
