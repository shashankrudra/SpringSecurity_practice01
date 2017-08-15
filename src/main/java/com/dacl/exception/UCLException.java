package com.deloitte.ucl.exception;

/**
 * @author tgunter
 *
 */
public class UCLException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String ERROR_PERFORMING = "Error performing operation";
        public UCLException() {}
 
        /**
         * @param message
         */
        public UCLException(String message)
        {
            super(message);
        }

        /**
         * @param cause
         */
        public UCLException(Throwable cause)
        {
            super(cause);
        }
 
        /**
         * Constructor with message and original exception.
         * @param message
         * @param cause
         */
        public UCLException(String message, Throwable cause)
        {
            super(message, cause);
        }
 
        /**
         * Constructor with message, original exception, enableSuppression flag, and writableStackTrace falg.
         * @param message
         * @param cause
         * @param enableSuppression
         * @param writableStackTrace
         */
        public UCLException(String message, Throwable cause,
                                           boolean enableSuppression, boolean writableStackTrace)
        {
            super(message, cause, enableSuppression, writableStackTrace);
        }
        
        public String getDisplayMessage() {
            return ERROR_PERFORMING;
        }

}
