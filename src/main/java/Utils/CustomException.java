package Utils;

import net.bytebuddy.implementation.bind.annotation.Super;

public class CustomException extends RuntimeException{

    public CustomException(String msg){
        super(msg);
    }
}
