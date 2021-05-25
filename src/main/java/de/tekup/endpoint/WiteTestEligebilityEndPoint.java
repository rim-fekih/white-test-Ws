package de.tekup.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.service.WhiteTestService;
import de.tekup.whitetest.soap.ws.whitetest.StudentRequest;
import de.tekup.whitetest.soap.ws.whitetest.WhiteTestResponse;


@Endpoint
public class WiteTestEligebilityEndPoint {
 public final static String nameSpace = "http://www.tekup.de/soap/models/whitetest" ;
	@Autowired
	private WhiteTestService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse checkLoanEligebilty (@RequestPayload StudentRequest sudentRequest) {
		//call Service
		return null;
}}
