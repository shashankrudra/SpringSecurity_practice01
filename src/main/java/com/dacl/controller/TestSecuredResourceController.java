package com.dacl.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class TestSecuredResourceController {
	private final static Logger logger = LoggerFactory.getLogger(TestSecuredResourceController.class);

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getData() {
		logger.error("{} called..", "getData");
		return Arrays.asList(new String[]{"1", "2"});
	}	
}
