package com.example.mery.drugbox;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class DrugList implements Parcelable {
    private String drug_id;
    private String pharm_id;
    private String DrugName;
    private String Type;
    private String Producer;
    private String Pharmacy;
    private String Address;
    private String Telephone;
    private String Available;
    private String Price;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(drug_id);
        dest.writeString(pharm_id);
        dest.writeString(DrugName);
        dest.writeString(Type);
        dest.writeString(Producer);
        dest.writeString(Pharmacy);
        dest.writeString(Address);
        dest.writeString(Telephone);
        dest.writeString(Available);
        dest.writeString(Price);
    }

    public DrugList(Parcel in) {
        drug_id = in.readString();
        pharm_id = in.readString();
        DrugName = in.readString();

        Type = in.readString();
        Producer = in.readString();
        Pharmacy = in.readString();
        Address = in.readString();
        Telephone = in.readString();
        Available = in.readString();
        Price = in.readString();
    }


    public static final Parcelable.Creator<DrugList> CREATOR = new Parcelable.Creator<DrugList>() {
        public DrugList createFromParcel(Parcel in) {
            return new DrugList(in);
        }

        public DrugList[] newArray(int size) {
            return new DrugList[size];
        }
    };

    public String getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(String drug_id) {
        this.drug_id = drug_id;
    }

    public String getPharm_id() {
        return pharm_id;
    }

    public void setPharm_id(String pharm_id) {
        this.pharm_id = pharm_id;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getPharmacy() {
        return Pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        Pharmacy = pharmacy;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAvailable() {
        return Available;
    }

    public void setAvailable(String available) {
        Available = available;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
