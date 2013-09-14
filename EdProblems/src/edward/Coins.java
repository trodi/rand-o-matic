package edward;

import java.util.HashSet;
import java.util.Set;

public class Coins {

	private static final int[] coins = {1,2,5,10,20,50};
	private static final int totalValue = 374;
	
	/**
	 * Find the combination of coins that adds up to 374 cents. You must use 3 types of coins. You must use the same number of each type of coin.
	 * Possible coin values: 1,2,5,10,20,50
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> _selectedCoins = coins();
		printAnswer(_selectedCoins);
	}

	/** @return the {@link Set} of coin types to solve problem or {@code null} if none were found. */
	private static Set<Integer> coins() {
		for (int _firstCoin : coins) {
			final Set<Integer> _selectedCoins = new HashSet<Integer>();
			_selectedCoins.add(_firstCoin);
			
			for (int _secondCoin : coins) {
				if (!_selectedCoins.add(_secondCoin)) {
					continue;
				}
				
				for (int _thirdCoin : coins) {
					if (!_selectedCoins.add(_thirdCoin)) {
						continue;
					}
					
					if (checkCombination(_selectedCoins)) {
						return _selectedCoins;
					} else {
						_selectedCoins.remove(_thirdCoin);
					}
				}
				_selectedCoins.remove(_secondCoin);
			}
		}
		return null;
		
	}
	
	private static void printAnswer(final Set<Integer> pAnswer) {
		if (pAnswer == null) {
			System.out.print("answer not found...");
			return;
		}
		for (int answer : pAnswer) {
			System.out.print(String.valueOf(answer) + ' ');
		}
	}
	
	/** @return {@link boolean} if given set of coins meets problem criteria.*/
	private static boolean checkCombination(Set<Integer> pSelectedCoins) {
		for (int i=1; i<200; i++) {
			int _value = 0;
			final StringBuilder _string = new StringBuilder("checking: ");
			for (int _coin : pSelectedCoins) {
				_string.append(_coin).append(' ');
			}
			for (int _coin : pSelectedCoins) {
				_value += (_coin * i);
			}
			if (_value == totalValue) {
				System.out.println(_string.append(String.format("num coins [%d] | [%d] == [%d]", i, _value, totalValue)).toString());
				return true;
			}
		}
		return false;
	}
}
