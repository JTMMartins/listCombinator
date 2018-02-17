package com.noshio.ListCombinator;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ListCombinatorTest extends TestCase {
	List<String> listOne = new ArrayList<>();
	List<String> listTwo = new ArrayList<>();
	List<Integer> listThree = new ArrayList<>();
	List<Integer> listFour = new ArrayList<>();

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	/**
	 * set of tests with different sized lists and emptyLists
	 */

	public void testMergeDiscardTwoListsDifferentSize() {
		regenerateDataLists();
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("A");
		expectedResult.add("10");
		expectedResult.add("B");
		expectedResult.add("20");
		expectedResult.add("C");
		expectedResult.add("30");
		expectedResult.add("D");
		expectedResult.add("40");
		expectedResult.add("E");
		expectedResult.add("50");

		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergeDiscard());
	}
	
	public void testMergeAppendsListsDifferentSize() {
		regenerateDataLists();
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("A");
		expectedResult.add("10");
		expectedResult.add("B");
		expectedResult.add("20");
		expectedResult.add("C");
		expectedResult.add("30");
		expectedResult.add("D");
		expectedResult.add("40");
		expectedResult.add("E");
		expectedResult.add("50");
		expectedResult.add("F");
		expectedResult.add("G");
		expectedResult.add("H");

		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergeAppend());
	}
	
	public void testMergePrependListsDifferentSize() {
		regenerateDataLists();
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("C");
		expectedResult.add("D");
		expectedResult.add("10");
		expectedResult.add("E");
		expectedResult.add("20");
		expectedResult.add("F");
		expectedResult.add("30");
		expectedResult.add("G");
		expectedResult.add("40");
		expectedResult.add("H");
		expectedResult.add("50");


		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergePrepend());
	}

	public void testMergeDiscardWithOneEmptyList() {
		regenerateDataLists();
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("C");
		expectedResult.add("D");
		expectedResult.add("E");
		expectedResult.add("F");
		expectedResult.add("G");
		expectedResult.add("H");
		listOne.clear();
		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergeDiscard());
	}
	
	public void testMergeAppendWithOneEmptyList() {
		regenerateDataLists();
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("C");
		expectedResult.add("D");
		expectedResult.add("E");
		expectedResult.add("F");
		expectedResult.add("G");
		expectedResult.add("H");
		listOne.clear();
		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergeAppend());
	}
	
	public void testMergePrependWithOneEmptyList() {
		regenerateDataLists();
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("A");
		expectedResult.add("B");
		expectedResult.add("C");
		expectedResult.add("D");
		expectedResult.add("E");
		expectedResult.add("F");
		expectedResult.add("G");
		expectedResult.add("H");
		listOne.clear();
		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergePrepend());
	}
	
	public void testMergeDiscardWithTwoEmptyList() {
		List<String> expectedResult = new ArrayList<>();
		listOne.clear();
		listTwo.clear();
		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergeDiscard());
	}
	
	public void testMergeAppendWithTwoEmptyList() {
		List<String> expectedResult = new ArrayList<>();
		listOne.clear();
		listTwo.clear();
		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergeAppend());
	}
	
	public void testMergeprependWithTwoEmptyList() {
		List<String> expectedResult = new ArrayList<>();
		listOne.clear();
		listTwo.clear();
		ListCombinator<String> listCombinator = new ListCombinator<>(listOne, listTwo);
		Assert.assertEquals(expectedResult, listCombinator.mergePrepend());
	}
	
	

	private void regenerateDataLists() {
		listOne.clear();
		listTwo.clear();
		listThree.clear();
		listFour.clear();
		listOne.add("10");
		listOne.add("20");
		listOne.add("30");
		listOne.add("40");
		listOne.add("50");

		listTwo.add("A");
		listTwo.add("B");
		listTwo.add("C");
		listTwo.add("D");
		listTwo.add("E");
		listTwo.add("F");
		listTwo.add("G");
		listTwo.add("H");

		listThree.add(10);
		listThree.add(35);
		listThree.add(32);
		listThree.add(12);
		listThree.add(16);

		listFour.add(10);
		listFour.add(35);
		listFour.add(32);
		listFour.add(12);
		listFour.add(16);

	}
}