
import java.util.regex.Pattern;

public class ValidationService {

    public static void validateName(String name) throws ValidationException {
        if (!Pattern.matches("^[A-Za-z]{3,}$", name)) {
            throw new ValidationException("Vārdam jābūt vismaz 3 burtiem!");
        }
    }

    public static void validateEmail(String email) throws ValidationException {
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            throw new ValidationException("Nepareizs e-pasts!");
        }
    }

    public static void validatePersonalCode(String code) throws ValidationException {
        if (!Pattern.matches("^[0-9]{11}$", code)) {
            throw new ValidationException("Personas kodam jābūt 11 cipariem!");
        }
    }
}