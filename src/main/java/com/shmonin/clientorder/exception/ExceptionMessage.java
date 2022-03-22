package com.shmonin.clientorder.exception;

import static java.lang.String.format;

public enum ExceptionMessage {

    CLIENT {
        public String getMessage(Long id) {
            return format("There is no client with id=%d in database", id);
        }
    },
    ORDER {
        public String getMessage(Long id) {
            return format("There is no order with id=%d in database", id);
        }
    };

    public abstract String getMessage(Long id);
}
