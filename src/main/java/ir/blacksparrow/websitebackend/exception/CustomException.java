package ir.blacksparrow.websitebackend.exception;

import javax.servlet.http.HttpServletRequest;

public class CustomException extends RuntimeException{

    public CustomException(String messageLabelKey, HttpServletRequest request) {
        super(getMessageByKey(messageLabelKey, request));
    }

    getMessageByKey
}
