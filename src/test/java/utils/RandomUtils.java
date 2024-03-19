package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomUtils {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10)),
            year = new SimpleDateFormat("yyyy").format(new Date()),
            month = new SimpleDateFormat("MMMM", new Locale("en")).format(new Date()),
            day = new SimpleDateFormat("d").format(new Date()),
            fullTemporaryAddress = faker.address().fullAddress(),
            fullPermanentAddress = faker.address().fullAddress();
}