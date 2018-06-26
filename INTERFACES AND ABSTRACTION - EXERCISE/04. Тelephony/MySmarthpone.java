import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySmarthpone implements Phone, Smartphone {

    private static final String INVALID_PHONE_MESSAGE = "Invalid number!";
    private static final String INVALID_URL = "Invalid URL!";

    @Override
    public String call(String phoneNumber) {
        Matcher matcher = Pattern.compile("\\w[^0-9]").matcher(phoneNumber);
        if (matcher.find()) {
            throw new IllegalArgumentException(INVALID_PHONE_MESSAGE);
        }

        return String.format("Calling... %s", phoneNumber);
    }

    @Override
    public String browseInInternet(String url) {
        Matcher matcher = Pattern.compile("\\d").matcher(url);
        if (matcher.find()) {
            throw new IllegalArgumentException(INVALID_URL);
        }

        return String.format("Browsing: %s!", url);
    }
}
