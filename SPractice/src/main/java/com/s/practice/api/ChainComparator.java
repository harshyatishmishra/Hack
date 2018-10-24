package com.s.practice.api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.s.practice.model.OutputDetails;

public class ChainComparator implements Comparator<OutputDetails> {

	List<Comparator<OutputDetails>> listOfComparator;
	
	
	public ChainComparator(Comparator<OutputDetails>... listOfComparator) {
		this.listOfComparator = Arrays.asList(listOfComparator);
	}


	@Override
	public int compare(OutputDetails o1, OutputDetails o2) {
		for(Comparator<OutputDetails> comparator : listOfComparator) {
			int result = comparator.compare(o1, o2);
			if(result !=0) {
				return result;
			}
		}
		return 0;
	}

}
