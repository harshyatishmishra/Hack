package com.s.practice.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.s.practice.api.ChainComparator;
import com.s.practice.api.CountryComparator;
import com.s.practice.api.GenderComparator;
import com.s.practice.constants.PracticeConstants.Separators;
import com.s.practice.exception.AvgException;
import com.s.practice.exception.FileReadException;
import com.s.practice.model.Details;
import com.s.practice.model.OutputDetails;
import com.s.practice.utils.PracticeUtils;

public class AverageService {

	public void getAverageFile(String fileName, Separators separator) throws AvgException {
		
		List<OutputDetails> result = new ArrayList<>();
		List<Details> listOfDetails = PracticeUtils.readFile(fileName, separator);
		listOfDetails.forEach(System.out::println);
		System.out.println();
		
		Map<String, List<Details>> countryWiseMap = PracticeUtils.generateMapOfCountry(listOfDetails);
		
		countryWiseMap.forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});
		
		for (String country : countryWiseMap.keySet()) {
			List<Details> list = countryWiseMap.get(country);
			get(list, result);
		}
		
		System.out.println();
		Collections.sort(result, new ChainComparator(new CountryComparator(), new GenderComparator()));
		result.forEach(System.out::println);
		
		PracticeUtils.writeFile(result);
	}
	
	
	private static void get(List<Details> detail, List<OutputDetails> result) {
		Float maleAverage = 0.0f, femaleAverage = 0.0f;
		OutputDetails male = null, female = null;
		int maleCount = 0, femaleCount = 0;
		for (Details det : detail) {
			if (det.getGender().equals("M")) {
				male = new OutputDetails();
				male.setCountry(det.getCountry());
				male.setGender(det.getGender());
				maleCount++;
				maleAverage += Float.parseFloat(det.getIncome());
			} else {
				female = new OutputDetails();
				female.setCountry(det.getCountry());
				female.setGender(det.getGender());
				femaleCount++;
				femaleAverage += Float.parseFloat(det.getIncome());
			}
		}
		if (male != null) {
			maleAverage = maleAverage/maleCount;
			male.setIncome(maleAverage.toString());
			result.add(male);
		}
		if (female != null) {
			femaleAverage = femaleAverage/femaleCount;
			female.setIncome(femaleAverage.toString());
			result.add(female);
		}
	}
}
