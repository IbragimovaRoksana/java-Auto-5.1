package ru.netology.web;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static User RegistrationUser() {
            Faker faker = new Faker(new Locale("ru"));
            Random random = new Random();
            int plusDaysToLocal = random.nextInt(10) + 3;
            User value = new User(faker.address().city(),
                    LocalDate.now().plusDays(plusDaysToLocal),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
            return value;
        }
    }

}
