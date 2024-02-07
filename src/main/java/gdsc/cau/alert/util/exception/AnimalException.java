package gdsc.cau.alert.util.exception;

import gdsc.cau.alert.util.api.ResponseCode;

public class AnimalException extends BaseException {

    public AnimalException(ResponseCode responseCode) {
        super(responseCode);
    }
}
