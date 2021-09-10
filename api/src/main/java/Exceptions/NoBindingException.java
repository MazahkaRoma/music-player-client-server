package Exceptions;

public class NoBindingException extends Exception {

    private String binding;

    public NoBindingException(String binding) {
        this.binding = binding;
    }

    @Override
    public String getMessage() {
        return "No such binding exists " + binding;
    }
}
