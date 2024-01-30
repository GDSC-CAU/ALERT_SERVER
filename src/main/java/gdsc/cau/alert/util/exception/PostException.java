package gdsc.cau.alert.util.exception;

import gdsc.cau.alert.util.api.ResponseCode;

public class PostException extends BaseException {

    public PostException(ResponseCode responseCode) {
        super(responseCode);
    }
}
