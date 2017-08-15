package com.deloitte.ucl.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ucl.exception.ErrorInfo;

@RestController
@RequestMapping(value = "/test")
public class TestUnSecuredResourceController {
	final Logger logger = LoggerFactory.getLogger(TestUnSecuredResourceController.class);

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getData() {
		logger.error("{} called..", "getData");
		boolean flag = true;
		if(flag)
		throw new RuntimeException("asdad");
		return Arrays.asList(new String[]{"1", "2"});
	}
	
	@RequestMapping(value = "/postMessage", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<String> postData() {
		logger.error("{} called..", "postData");
		return Arrays.asList(new String[]{"1", "2"});
	}
	
	 @ExceptionHandler(Exception.class)
	    @ResponseBody ErrorInfo
	    handleUnacceptableRequest(HttpServletRequest req, Exception ex) {
	    	logger.error(ex.getMessage());
	        return new ErrorInfo(req.getRequestURI(), ex.getLocalizedMessage());
	    }
}
