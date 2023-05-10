package starter.utils;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Faker {
    private static final String[] EMAIL_DOMAINS = { "gmail.com", "yahoo.com", "hotmail.com", "outlook.com" };
    private static final Random RANDOM = new Random();

    public static String generateRandomEmail() {
        String username = RandomStringUtils.randomAlphanumeric(8);
        String domain = EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)];
        return username + "@" + domain;
    }

    public static String generateRandomFullName() {
        String firstName = RandomStringUtils.randomAlphabetic(6);
        String lastName = RandomStringUtils.randomAlphabetic(8);
        return firstName + " " + lastName;
    }

    public static String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }
}
