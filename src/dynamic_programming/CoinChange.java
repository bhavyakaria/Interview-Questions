/*
 * Finding the number of ways of making change from giving array of coins of a particular unit.
 */
package dynamic_programming;

import java.util.HashMap;

/**
 *
 * @author Parzival
 */
public class CoinChange {
    
    public static void main(String[] args) {
        int coins[] = {2,5,3,6};
        int money = 10;
        
        int ways = makeChange(coins, money);
        System.out.println(ways);
    }

    private static int makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<String, Integer>());
    }

    private static int makeChange(int[] coins, int money, int i, HashMap<String, Integer> memo) {
        if(money == 0) {
            return 1;
        }
        
        if(i >= coins.length) {
            return 0;
        }
        String key = money+"-"+i;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int amountWithCoins = 0;
        int ways = 0;
        
        while(amountWithCoins <= money) {
            int rem = money - amountWithCoins;
            ways += makeChange(coins,rem,i+1,memo);
            amountWithCoins += coins[i];
        }
        memo.put(key, ways);
        return ways;
    }
    
}
