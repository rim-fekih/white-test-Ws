package de.tekup.service;

import org.springframework.stereotype.Service;

import de.tekup.whitetest.soap.ws.whitetest.Exam;
import de.tekup.whitetest.soap.ws.whitetest.ExamsRequest;
import de.tekup.whitetest.soap.ws.whitetest.ExamsResponse;
import de.tekup.whitetest.soap.ws.whitetest.ObjectFactory;
import de.tekup.whitetest.soap.ws.whitetest.WhiteTestResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamsListService {
	public  List<Exam> AvailableExams = new ArrayList<Exam>();
	
	public WhiteTestResponse examsList(ExamsRequest examRequest)
	{
		AvailableExams.add(new Exam("code_OCA","OCA"));
		AvailableExams.add(new Exam("code_OCP","OCP"));
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
		if (examRequest.isListExams())
		{
			System.out.println("Available");

			response.setExam(AvailableExams);
		}
		return response;
	}
}

