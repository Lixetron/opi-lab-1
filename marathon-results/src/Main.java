import domain.*;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Laboratory work #1. GIT\nVariant #1 (11). Marathon Results\nAuthor: Dmitry Khlopchenko");
        Path path = Paths.get("marathon-results/data.txt");
        File f = new File(path.toUri());
        if (!f.exists()) {
            try (FileWriter fileWriter = new FileWriter("marathon-results/data.txt", false)) {
                for (String string : Utility.MARATHONERS_STRINGS) {
                    fileWriter.write(string);
                    fileWriter.write(System.lineSeparator());
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        List<Marathoner> marathoners = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            scanner.useDelimiter(System.lineSeparator());
            while (scanner.hasNext()) {
                String next = scanner.next();
                String[] strings = next.split("\\s+");
                Marathoner marathoner = new Marathoner();
                marathoner.setNumber(Integer.parseInt(strings[0]));
                marathoner.setSurname(strings[1]);
                marathoner.setName(strings[2]);
                marathoner.setPatronymic(strings[3]);
                marathoner.setStartTime(LocalTime.parse(strings[4]));
                marathoner.setFinishTime(LocalTime.parse(strings[5]));
                marathoner.setClubName(strings[6]);
                marathoners.add(marathoner);
            }
            System.out.println("\nAll marathoners:");
            marathoners.forEach(System.out::println);

            System.out.println("\nMarathoners with Club: \"Спартак\":");
            marathoners.stream().filter(marathoner -> marathoner.getClubName().equals("\"Спартак\"")).forEach(System.out::println);

            System.out.println("\nMarathoners with result better then 2:50:00:");
            marathoners.stream()
                    .filter(marathoner -> marathoner.getDurationRun().toSeconds() < LocalTime.parse("02:50:00").toSecondOfDay())
                    .forEach(System.out::println);

            System.out.println("\nMarathoners sorted by duration run (Bubble Sort):");
            Sort.bubbleSort(marathoners, new MarathonerTimeComparator());
            marathoners.forEach(System.out::println);

            System.out.println("\nMarathoners sorted by Club and Surname inside Club (Quick Sort):");
            Sort.quickSort(marathoners, new MarathonerClubNameComparator().thenComparing(new MarathonerSurnameComparator()));
            marathoners.forEach(System.out::println);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}