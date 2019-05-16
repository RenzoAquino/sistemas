package commons.exception;

public class BusinessException extends Exception{
    public BusinessException(String message/*, ErrorCode code*/) {
        super(message);
        //this.code = code;
    }
}
