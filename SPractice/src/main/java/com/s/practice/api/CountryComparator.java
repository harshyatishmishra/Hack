package com.s.practice.api;

import java.util.Comparator;

import com.s.practice.model.OutputDetails;

public class CountryComparator implements Comparator<OutputDetails> {

	@Override
	public int compare(OutputDetails detail_1, OutputDetails detail_2) {
		return detail_1.getCountry().compareTo(detail_2.getCountry());
	}

}
