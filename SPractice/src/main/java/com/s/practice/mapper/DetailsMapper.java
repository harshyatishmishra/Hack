package com.s.practice.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.s.practice.model.Details;

public class DetailsMapper {

	public static List<Details> getDetail(CSVReader reader) throws IOException {
		List<Details> details = new ArrayList<Details>();
		
		String record[] = null;
		reader.readNext();
		while((record = reader.readNext())!= null) {
			Details det = new Details();
			det.setCountry(record[0]);
			det.setCountry_Code(record[4]);
			det.setGender(record[2]);
			det.setIncome(record[3]);
			det.setCity(record[1]);
			details.add(det);
		}
		return details;
	}
}
