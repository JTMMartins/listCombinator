/**
 * 
 */
package com.noshio.ListCombinator;

import java.util.ArrayList;
import java.util.List;



/**
 * @author JMartins
 *         <h1>Merge two Lists</h1> This class allows the merge of two lists
 *         of same or different sizes it provides 3 methods of merge.
 *         ListMergeDiscard, discards the last elements of the bigger sized list,
 *         ListMergeAppendLast merges the lists and
 *         appends the remaining elements of the bigger list to the end,
 *         ListMergePrePendInits takes the extra initial elements of the bigger
 *         sized list and prepend them to the merged list
 * @param <T>
 */
public final class ListCombinator<T> {
	
	private List<T> listOne;
	private List<T> listTwo;
	
	public ListCombinator(List<T> listOne, List<T> listTwo) throws IllegalArgumentException {
		if (listOne==null || listTwo==null) {
			throw new IllegalArgumentException("ListCombinator can't receive null arguments");
		}
	
		this.listOne=listOne;
		this.listTwo=listTwo;
	}
	
	/**
	 * This method is used to merge two lists of the same type. if the supplied
	 * lists have different sizes the bigger list will be reduced to the same size
	 * as the smaller one, and all the remaining elements will be discarded. If the
	 * supplied lists have the same size, a standard merge is done.
	 * 
	 * @return List<T> the merged list without the last elements of the bigger list,
	 *         if any.
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public  <T> List<T> mergeDiscard() throws IllegalArgumentException {
		List<T> mergedResult = new ArrayList<>();
		List<T> biggerList=(List<T>) listOne;//assuming they have the same size
		List<T> smallerList=(List<T>) listTwo;
		
		if (listOne.size() != listTwo.size()) { //change if they don't
			biggerList = getBiggerList();
			smallerList = getSmallerList();
		} 
		
		if (smallerList.size() > 0) {
			for (int index = 0; index < smallerList.size(); index++) {
				mergedResult.add(biggerList.get(index));
				mergedResult.add(smallerList.get(index));
			}
		} else {//in case one list is empty we need this check
			for (int index = 0; index < biggerList.size(); index++) {
				mergedResult.add(biggerList.get(index));
			}
		}
		return mergedResult;
	}
	/**
	 * This method is used to merge two lists of the same type. if the supplied
	 * lists have different sizes the bigger list will be reduced to the same size
	 * as the smaller one, and all the remaining elements will be appended to the
	 * end of the result list. If the
	 * supplied lists have the same size, a standard merge is done.

	 * @return List<T> the merged list with the extra elements of the bigger list
	 *         if any, appended to the end of the list
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> mergeAppend() {

		List<T> mergedResult = new ArrayList<>();
		List<T> biggerList=(List<T>) listOne;//assuming they have the same size
		List<T> smallerList=(List<T>) listTwo;
		
		if (listOne.size() != listTwo.size()) {//change if they don't
			biggerList = getBiggerList();
			smallerList = getSmallerList();
		}

		int lastOffset=0;
		if (smallerList.size()==0){
			lastOffset=-1;//adjusting offset for empty list
		}
		for (int index = 0; index < smallerList.size(); index++) {
			mergedResult.add(biggerList.get(index));
			mergedResult.add(smallerList.get(index));
			lastOffset = index;
		}
		// appending the remaining elements from the bigger list
		
		for (int index = lastOffset+1; index < biggerList.size(); index++) {
			mergedResult.add(biggerList.get(index));
		}
		return mergedResult;
	}
	/**
	 * This method is used to merge two lists of the same type. if the supplied
	 * lists have different sizes the initial elements of the bigger list will 
	 * be prepended to the beginning of the result list. If the
	 * supplied lists have the same size, a standard merge is done.

	 * @return List<T> the merged list with the initial extra elements of the bigger list
	 *         if any, prepended to the begining of the list
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public  <T> List<T> mergePrepend() {

		List<T> mergedResult = new ArrayList<>();
		List<T> biggerList= (List<T>) listOne;;//assuming they have the same size
		List<T> smallerList= (List<T>) listTwo;;
		
		if (listOne.size() != listTwo.size()) {//change if they don't
			biggerList = getBiggerList();
			smallerList = getSmallerList();
		}
		
		// Appending the extra initial ones from the bigger list
		
		int deltaSize = biggerList.size() - smallerList.size();
		for (int index = 0; index < deltaSize; index++) {
			mergedResult.add(biggerList.get(index));
		}

		for (int index = 0; index < smallerList.size(); index++) {
			mergedResult.add(biggerList.get(index + deltaSize));
			mergedResult.add(smallerList.get(index));
		}

		return mergedResult;
	}
	/**
	 * 	returns the list with more elements
	 * @return List<T>
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	private <T> List<T> getBiggerList() {
		return listOne.size() > listTwo.size() ? (List<T>) listOne : (List<T>) listTwo;
	}
	/**
	 * 	returns the list with less elements
	 * @return List<T>
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	private  <T> List<T> getSmallerList() {
		return listOne.size() > listTwo.size() ? (List<T>) listTwo : (List<T>) listOne;
	}

}
