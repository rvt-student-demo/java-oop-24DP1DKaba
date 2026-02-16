

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    public  String personalCode;
    public String registrationDate;

    public Student(String firstName, String lastName, String email,
                   String personalCode, String registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPersonalCode() { return personalCode; }
    public String getRegistrationDate() { return registrationDate; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    public String toCSV() {
        return firstName + "," + lastName + "," + email + "," +
                personalCode + "," + registrationDate;
    }
}
