import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - register");
            System.out.println("2 - show");
            System.out.println("3 - remove");
            System.out.println("4 - edit");
            System.out.println("5 - exit");

            String choice = scanner.nextLine();

            try {
                switch (choice) {

                    case "1":
                        System.out.print("Vārds: ");
                        String name = scanner.nextLine();
                        ValidationService.validateName(name);

                        System.out.print("Uzvārds: ");
                        String lastName = scanner.nextLine();
                        ValidationService.validateName(lastName);

                        System.out.print("E-pasts: ");
                        String email = scanner.nextLine();
                        ValidationService.validateEmail(email);

                        System.out.print("Personas kods: ");
                        String code = scanner.nextLine();
                        ValidationService.validatePersonalCode(code);

                        String date = LocalDateTime.now().toString();

                        Student student = new Student(name, lastName, email, code, date);
                        RegistrationService.register(student);

                        System.out.println("Students veiksmīgi reģistrēts!");
                        break;

                    case "2":
                        List<Student> students = FileHandler.readAll();
                        printStudents(students);
                        break;

                    case "3":
                        System.out.print("Ievadi personas kodu dzēšanai: ");
                        RegistrationService.remove(scanner.nextLine());
                        System.out.println("Students dzēsts!");
                        break;

                    case "4":
                        System.out.print("Ievadi personas kodu rediģēšanai: ");
                        String editCode = scanner.nextLine();

                        System.out.print("Jaunais vārds: ");
                        String newName = scanner.nextLine();
                        ValidationService.validateName(newName);

                        System.out.print("Jaunais uzvārds: ");
                        String newLast = scanner.nextLine();
                        ValidationService.validateName(newLast);

                        System.out.print("Jaunais e-pasts: ");
                        String newEmail = scanner.nextLine();
                        ValidationService.validateEmail(newEmail);

                        RegistrationService.edit(editCode, newName, newLast, newEmail);
                        System.out.println("Dati atjaunoti!");
                        break;

                    case "5":
                        System.exit(0);

                    default:
                        System.out.println("Nepareiza izvēle!");
                }

            } catch (Exception e) {
                System.out.println("Kļūda: " + e.getMessage());
            }
        }
    }

    public static void printStudents(List<Student> students) {

        System.out.printf("%-15s %-15s %-25s %-15s %-25s%n",
                "Vārds", "Uzvārds", "E-pasts", "PK", "Reģ.datums");

        System.out.println("------------------------------------------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-15s %-15s %-25s %-15s %-25s%n",
                    s.getFirstName(),
                    s.getLastName(),
                    s.getEmail(),
                    s.getPersonalCode(),
                    s.getRegistrationDate());
        }
    }
}