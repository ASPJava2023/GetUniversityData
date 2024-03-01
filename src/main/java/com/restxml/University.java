package com.restxml;

import java.util.ArrayList;

import lombok.Data;

@Data
public class University {
	private String name;
	private String stateprovince;
    private String country;
    private ArrayList<String> domains;
    private ArrayList<String> web_pages;

    // Add other fields as needed

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                "stateprovince='" +stateprovince+ '\'' +
                ", country='" + country + '\'' +
                // Add other fields as needed
                ", domains='" + domains + '\'' +
                ", web_pages='" + web_pages + '\'' +
                '}';
    }
}
