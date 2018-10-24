package com.s.practice.main;

import com.s.practice.constants.PracticeConstants;
import com.s.practice.constants.PracticeConstants.Separators;
import com.s.practice.exception.AvgException;
import com.s.practice.impl.AverageService;

public class FindTheAverage {

	public static void main(String[] args) throws AvgException {

		AverageService services = new AverageService();
		String fileName = "files/inputs.csv";
		Separators separator = PracticeConstants.Separators.COMMA_SEPARATOR;
		services.getAverageFile(fileName, separator);
		
	}

}
