package com.deloitte.ucl.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	private static final Logger logger = LoggerFactory
			.getLogger(GlobalExceptionController.class);

    /**
     *
     * @param req the request
     * @param ex the exception
     * @return the error info
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(Exception.class)
    @ResponseBody ErrorInfo
    handleUnacceptableRequest(HttpServletRequest req, Exception ex) {
    	logger.error(ex.getMessage());
        return new ErrorInfo(req.getRequestURI(), ex.getLocalizedMessage());
    }
    
	@ExceptionHandler(CustomBusinessException.class)
	public ModelAndView handleCustomException(CustomBusinessException ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		logger.error("**********inside CustomBusinessException");
		return model;
	}

	/*@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");
		
		logger.error("**********inside Exception");
		return model;
	}*/

}