package exceptions;

public class NotAllowedInfoException extends Exception {
    public NotAllowedInfoException(){
        super("Informação não está de acordo com as regras, verifique novamente!");
    }

    public NotAllowedInfoException(String message){
        super(message);
    }
}
