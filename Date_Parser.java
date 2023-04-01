import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (in any format): ");
        String input = scanner.nextLine();

        LocalDate date = null;
        String[] possibleFormats = {"MM/dd/yyyy", "M/dd/yyyy", "MM/d/yyyy", "M/d/yyyy",
                                    "MM/dd/yy", "M/dd/yy", "MM/d/yy", "M/d/yy",
                                    "yyyy/MM/dd", "yyyy/M/dd", "yyyy/MM/d", "yyyy/M/d",
                                    "yyyy-MM-dd", "yyyy-M-dd", "yyyy-MM-d", "yyyy-M-d",
                                    "dd/MM/yyyy", "d/MM/yyyy", "dd/M/yyyy", "d/M/yyyy",
                                    "dd/MM/yy", "d/MM/yy", "dd/M/yy", "d/M/yy"};

        for (String format : possibleFormats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                date = LocalDate.parse(input, formatter);
                break;
            } catch (DateTimeParseException e) {
                // Do nothing, try the next format
            }
        }

        if (date != null) {
            System.out.println("Parsed date: " + date.toString());
        } else {
            System.out.println("Unable to parse date.");
        }
    }
}
