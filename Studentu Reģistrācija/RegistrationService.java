import java.util.List;

public class RegistrationService {

    public static void register(Student student) throws Exception {
        List<Student> students = FileHandler.readAll();

        for (Student s : students) {
            if (s.getEmail().equals(student.getEmail())) {
                throw new DuplicateStudentException("E-pasts jau eksistē!");
            }
            if (s.getPersonalCode().equals(student.getPersonalCode())) {
                throw new DuplicateStudentException("Personas kods jau eksistē!");
            }
        }

        students.add(student);
        FileHandler.saveAll(students);
    }

    public static void remove(String personalCode) throws Exception {
        List<Student> students = FileHandler.readAll();
        students.removeIf(s -> s.getPersonalCode().equals(personalCode));
        FileHandler.saveAll(students);
    }

    public static void edit(String personalCode, String newName,
                            String newLastName, String newEmail) throws Exception {

        List<Student> students = FileHandler.readAll();

        for (Student s : students) {
            if (s.getPersonalCode().equals(personalCode)) {
                s.setFirstName(newName);
                s.setLastName(newLastName);
                s.setEmail(newEmail);
            }
        }

        FileHandler.saveAll(students);
    }
}