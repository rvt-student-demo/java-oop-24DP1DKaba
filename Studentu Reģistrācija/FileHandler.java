import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "students.csv";

    public static void saveAll(List<Student> students) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Student s : students) {
            writer.write(s.toCSV());
            writer.newLine();
        }
        writer.close();
    }

    public static List<Student> readAll() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return students;

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                students.add(new Student(
                        data[0], data[1], data[2], data[3], data[4]
                ));
            }
        }

        reader.close();
        return students;
    }
}