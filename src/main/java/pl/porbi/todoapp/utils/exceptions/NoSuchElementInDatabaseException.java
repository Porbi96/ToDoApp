package pl.porbi.todoapp.utils.exceptions;

public class NoSuchElementInDatabaseException extends RuntimeException{
    public NoSuchElementInDatabaseException() {
        super("Element not found in database!");
    }
}
