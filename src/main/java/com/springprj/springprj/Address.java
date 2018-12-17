package com.springprj.springprj;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(as = Address.class)
public class Address {

    private String rue;
    private String zipCode;

    public Address() {
    }

    public Address(String rue, String zipCode) {
        this.rue = rue;
        this.zipCode = zipCode;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(rue, address.rue) &&
                Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rue, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "rue='" + rue + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
