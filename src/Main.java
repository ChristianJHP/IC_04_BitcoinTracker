import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "bitcoin_prices_lite.txt";
    public static void main(String[] args) {
	// write your code here

        try {
            // Creating a Scanner reference (named file) that scans a file object
            // which is linked to FILE_NAME ("bitcoin_prices_lite.txt")
            Scanner file = new Scanner(new File(FILE_NAME));
            double price, sum = 0, min=Double.MAX_VALUE, max=Double.MIN_VALUE, average;
            NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
            int count = 0;

            // Read a String from Scammer : file.nextLine()
            // Skip over header
            file.nextLine();
            // loop where # of iterations is unknown
            // Read a double from Scanner: file.nextDouble()
            while (file.hasNextDouble())
            {
                price = file.nextDouble();
                // Each price we read from the file:
                // 1. Add 1 to the count
                count++;
                // 2. Add price to the sum
                sum += price;
                // 3. Determine max
                if (price > max)
                    max = price;
                // 4. Determine min
                if (price < min)
                    min = price;

            }
            // 5. Calculate average AFTER while loop
            average = sum / count;

            // Close the file after use so other people can
            file.close();

            // 6. Print statistics

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Bitcoin Statistics: Dec 2014 - Jun 2018");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Number of price quotes: " + count);
            System.out.println("Average price: " + defaultFormat.format(average));
            System.out.println("Lowest price: " + defaultFormat.format(min));
            System.out.println("Highest price: " + defaultFormat.format(max));

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening " + e.getMessage());
        }
    }
}
