package com.example.eventjinni.view.View.model;

public class OrderInfoModel {
    private int id;
    private String service_name;
    private String provider_name;
    private String customer_name;
    private String phone;
    private String address;
    private String date_time;

    public OrderInfoModel(int id, String service_name, String provider_name, String customer_name, String phone, String address, String date_time) {
        this.id = id;
        this.service_name = service_name;
        this.provider_name = provider_name;
        this.customer_name = customer_name;
        this.phone = phone;
        this.address = address;
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
