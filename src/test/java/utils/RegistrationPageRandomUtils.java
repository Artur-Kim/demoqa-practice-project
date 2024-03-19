package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RegistrationPageRandomUtils {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static String
            gender = faker.options().option("Male", "Female", "Other"),
            subject = faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                    "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                    "Maths", "Physics", "Social Studies"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            imageFile = faker.options().option("img.png", "img2.gif", "img3.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = randomCity();

    public static String randomCity() {
        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
                System.out.println("Штат " + state + " не найден.");
        }
        return city;
    }
}