package main.java.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Make the following equation true using each of the following numbers once.
 * 1,2,3,4,5,6
 * __ __
 * x __
 * ------
 * __ __ __
 * 
 * ab * c = def
 * 
 * @author tmckinnon
 *
 */
public class FillInTheBlank {

	private static final int[] numbers = {1,2,3,4,5,6};
	
	private static int counter = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final List<Integer> _answer = fillInTheBlank();
		printAnswer(_answer);
		
		final List<Integer> _fillInTheBlank_recursive = fillInTheBlank_recursive(new ArrayList<Integer>(), 0);
		printAnswer(_fillInTheBlank_recursive);
		System.out.println("the counter is " + counter);
	}

	private static List<Integer> fillInTheBlank_recursive(final List<Integer> pList, final int pNum) {
		final List<Integer> _clone = new ArrayList<Integer>(pList);
		if (_clone.contains(pNum)) {
			return null; // invalid combination
		}
		if (pNum != 0) {
			_clone.add(pNum);
		}
		if (_clone.size() == numbers.length) {
			if (checkAnswer(_clone)) {
				return _clone;
			} else {
				return null;
			}
		}
		// continue recursion
		List<Integer> _return = null;
		for (int _num : numbers) {
			_return = fillInTheBlank_recursive(_clone, _num);
			if (_return != null) {
				break;
			}
		}
		return _return;
	}
	
	private static List<Integer> fillInTheBlank() {
		final List<Integer> _numbers = new ArrayList<Integer>();
		for (int one : numbers) {
			_numbers.clear();
			_numbers.add(one);
			for (int two : numbers) {
				if (_numbers.contains(two)) {
					continue;
				} else {
					_numbers.add(two);
				}
				for (int three : numbers) {
					if (_numbers.contains(three)) {
						continue;
					} else {
						_numbers.add(three);
					}
					for (int four : numbers) {
						if (_numbers.contains(four)) {
							continue;
						} else {
							_numbers.add(four);
						}
						for (int five : numbers) {
							if (_numbers.contains(five)) {
								continue;
							} else {
								_numbers.add(five);
							}
							for (int six : numbers) {
								if (_numbers.contains(six)) {
									continue;
								} else {
									_numbers.add(six);
								}
								if (checkAnswer(_numbers)) {
									return _numbers;
								} else {
									_numbers.remove(5);
								}
							}
							_numbers.remove(4);
						}
						_numbers.remove(3);
					}
					_numbers.remove(2);
				}
				_numbers.remove(1);
			}
		}
		return null;
	}
	
	private static boolean checkAnswer(final List<Integer> pAnswer) {
		int _first = (pAnswer.get(0) * 10) + pAnswer.get(1);
		int _second = pAnswer.get(2);
		int _product = (pAnswer.get(3) * 100) + (pAnswer.get(4) * 10) + pAnswer.get(5);
		printAnswer(pAnswer);
		return _first * _second == _product;
	}
	
	private static void printAnswer(final List<Integer> pAnswer) {
		counter++;
		final StringBuilder _string = new StringBuilder("answer: ");
		if (pAnswer == null) {
			_string.append("no answer found...");
		} else {
			_string.append(String.format("%d%d * %d = %d%d%d", pAnswer.get(0), pAnswer.get(1), pAnswer.get(2), pAnswer.get(3), pAnswer.get(4), pAnswer.get(5)));
		}
		System.out.println(_string.toString());
	}
}
