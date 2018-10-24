package com.s.practice.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.s.practice.constants.PracticeConstants.Separators;
import com.s.practice.exception.AverageServiceException;
import com.s.practice.exception.AvgException;
import com.s.practice.exception.FileReadException;
import com.s.practice.main.FindTheAverage;
import com.s.practice.mapper.DetailsMapper;
import com.s.practice.model.Details;
import com.s.practice.model.OutputDetails;

public class PracticeUtils {

	public static List<Details> readFile(File file, Separators separator) throws AvgException {
		try {
			
			CSVReader reader = new CSVReader(new FileReader(file), separator.getSeparator());
			List<Details> listOfDetails = DetailsMapper.getDetail(reader);
			listOfDetails.forEach(System.out::println);
			return listOfDetails;
		} catch (IOException e) {
			System.err.println("Error Occured while reading the file "+ e.getLocalizedMessage());
			throw new FileReadException("Error Occured while reading the file "+ e.getLocalizedMessage(), e);
		}catch(Exception e) {
			System.err.println("Error Occured "+ e.getLocalizedMessage());
			throw new AverageServiceException("Error Occured while reading the file "+ e.getLocalizedMessage(), e);
		}
	}
	public static List<Details> readFile(String fileName, Separators separator) throws AvgException {
		
		try {
			ClassLoader classloader = new FindTheAverage().getClass().getClassLoader();
			File file = new File(classloader.getResource(fileName).getFile());	
			CSVReader reader = new CSVReader(new FileReader(file), separator.getSeparator());
			List<Details> listOfDetails = DetailsMapper.getDetail(reader);
			
			return listOfDetails;
		} catch (IOException e) {
			System.err.println("Error Occured while reading the file "+ e.getLocalizedMessage());
			throw new FileReadException("Error Occured while reading the file "+ e.getLocalizedMessage(), e);
		}catch(Exception e) {
			System.err.println("Error Occured "+ e.getLocalizedMessage());
			throw new AverageServiceException("Error Occured while reading the file "+ e.getCause().getMessage(), e);
		}
	}
	public static Map<String, List<Details>> generateMapOfCountry(List<Details> listOfDetails) {
		Map<String, List<Details>> countryWiseMap = new ConcurrentHashMap<>();
		System.out.println();

		for (Details detail : listOfDetails) {
			if (countryWiseMap.containsKey(detail.getCountry())) {
				List<Details> temp = new ArrayList<>();
				temp = countryWiseMap.get(detail.getCountry());
				temp.add(detail);
				countryWiseMap.put(detail.getCountry(), temp);
			} else {
				List<Details> temp = new ArrayList<>();
				temp.add(detail);
				countryWiseMap.put(detail.getCountry(), temp);
			}
		}
		return countryWiseMap;
	}
	public static void writeFile(List<OutputDetails> result) throws AvgException {
		Writer csvWriter = null;
		try {
			csvWriter = new FileWriter("output.csv");
			StatefulBeanToCsv bc = new StatefulBeanToCsvBuilder(csvWriter).withOrderedResults(true).withSeparator(Separators.COMMA_SEPARATOR.getSeparator()).build();
			bc.write(result);
		} catch (IOException e) {
			System.err.println("Error Occured while writing the file "+ e.getLocalizedMessage());
			throw new FileReadException("Error Occured while writing the file "+ e.getLocalizedMessage(), e);
		} catch (CsvException e) {
			System.err.println("Error Occured while using opencsv");
			throw new com.s.practice.exception.CsvException("Error Occured while writing the file "+ e.getLocalizedMessage(), e);
		} finally {
			try {
				csvWriter.close();
			} catch (IOException e) {
				throw new FileReadException("Error Occured while closing writer the file "+ e.getLocalizedMessage(), e);
			}
		}
		
	}
}
