package mk.ukim.finki.labaratoriska2_emt.exceptions;

public class authorNotFoundByIdException extends RuntimeException{
    public authorNotFoundByIdException(String message) {
        super(message);
    }
}
