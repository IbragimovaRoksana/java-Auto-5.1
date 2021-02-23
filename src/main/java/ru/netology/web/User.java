package ru.netology.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

public class User {
    private final String city;
    private final LocalDate localDate;
    private final String name;
    private final String phone;

    public User(String city, LocalDate localDate, String name, String phone) {
        this.city = city;
        this.localDate = localDate;
        this.name = name;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
