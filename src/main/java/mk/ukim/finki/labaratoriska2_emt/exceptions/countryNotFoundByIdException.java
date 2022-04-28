package mk.ukim.finki.labaratoriska2_emt.exceptions;

public class countryNotFoundByIdException extends RuntimeException {
    public countryNotFoundByIdException(String message) {
        super(message);
    }
}
