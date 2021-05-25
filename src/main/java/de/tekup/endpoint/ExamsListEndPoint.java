package de.tekup.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import de.tekup.service.ExamsListService;
import de.tekup.whitetest.soap.ws.whitetest.ExamsRequest;
import de.tekup.whitetest.soap.ws.whitetest.ExamsResponse;
import de.tekup.whitetest.soap.ws.whitetest.WhiteTestResponse;
@Endpoint
public class ExamsListEndPoint {

	public static final String nameSpace = "http://www.tekup.de/soap/models/whitetest";
	
	@Autowired
	private ExamsListService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "ExamsRequest")
	@ResponsePayload
	public WhiteTestResponse getExams(@RequestPayload ExamsRequest examsRequest)
	{
		return service.examsList(examsRequest);
	}

}

