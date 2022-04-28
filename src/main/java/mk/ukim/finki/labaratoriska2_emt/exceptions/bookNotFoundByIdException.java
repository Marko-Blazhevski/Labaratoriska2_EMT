package mk.ukim.finki.labaratoriska2_emt.exceptions;

public class bookNotFoundByIdException extends RuntimeException {
    public bookNotFoundByIdException(String message) {
        super(message);
    }
}
