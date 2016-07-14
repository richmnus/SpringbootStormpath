package com.mporium.testcase.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/demo")
public class RestWsController {

	@ApiOperation(value = "testGet", nickname = "testGet")
	@RequestMapping(method = RequestMethod.GET, path = "/testGet")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "name in greeting", required = false, dataType = "string", paramType = "query", defaultValue = "Amigo") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public @ResponseBody String testGet(@RequestParam(value = "name", defaultValue = "Unknown") String request) {
		return "Hello " + request;
	}

	@ApiOperation(value = "testPost", nickname = "testPost")
	@RequestMapping(method = RequestMethod.POST, path = "/testPost")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "name in greeting", required = false, dataType = "string", paramType = "query", defaultValue = "Amigo") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public @ResponseBody String testPost(@RequestParam(value = "name", defaultValue = "Unknown") String request) {
		return "Hello " + request;
	}

}
