package gdsc.cau.alert.util.exception;

import gdsc.cau.alert.util.api.ResponseCode;

public class UserException extends BaseException {

    public UserException(ResponseCode responseCode) {
        super(responseCode);
    }
}
