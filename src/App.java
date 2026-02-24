import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application for analyzing CO2 emissions from the World Indicators dataset.
 */
public class App {

    public static void main(String[] args) {

        File file = new File("/workspaces/data-analysis-project-Jalyn135/src/data/WorldIndicators2000.csv");
        ArrayList<Data> dataList = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);

            // Skip header
            if (scan.hasNextLine()) {
                scan.nextLine();
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");

                if (parts.length < 5) continue;

                String country = parts[0].trim();
                String dateStr = parts[1].trim();
                String emissionStr = parts[4].trim();

                if (dateStr.isEmpty() || emissionStr.isEmpty()) continue;

                try {
                    // Extract year from date like 12/1/2000
                    String[] dateParts = dateStr.split("/");
                    int year = Integer.parseInt(dateParts[2]);

                    double emissions = Double.parseDouble(emissionStr);

                    Data d = new Data(country, emissions, year);
                    dataList.add(d);

                } catch (Exception e) {
                    continue; // skip bad rows
                }
            }

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        if (dataList.isEmpty()) {
            System.out.println("No valid data loaded.");
            return;
        }

        Data max = findMaxEmissions(dataList);
        double avg = computeAverageEmissions(dataList);

        System.out.println("Rows loaded: " + dataList.size());
        System.out.println("Highest emissions: " + max);
        System.out.println("Average emissions: " + avg);
        System.out.println("Country with the most emissions: " + max.getCountry());
    }

    public static Data findMaxEmissions(ArrayList<Data> list) {
        Data max = list.get(0);

        for (Data d : list) {
            if (d.getEmissions() > max.getEmissions()) {
                max = d;
            }
        }

        return max;
    }

    public static double computeAverageEmissions(ArrayList<Data> list) {
        double sum = 0;

        for (Data d : list) {
            sum += d.getEmissions();
        }

        return sum / list.size();
    }
}