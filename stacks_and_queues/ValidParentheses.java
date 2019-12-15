import java.util.*;
/*
 * Validate a string of parentheses.
 * Input:
 * {([])}
 * Output
 * true
 * 
 * Approach:
 * 1. Use stack's push and pop features(LIFO)
 
 Time Complexity:
 O(n)
 */

/**
 *
 * @author Parzival
 */
class ValidParentheses {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String inputString = sc.nextLine();
		boolean isValid = false;
		Stack<String> stack = new Stack<>();

		if (inputString.length() != 0) {
			outerloop: for (int i = 0; i < inputString.length(); i++) {
				String s = Character.toString(inputString.charAt(i));
				if (s.equals("(") || s.equals("{") || s.equals("[")) {
					stack.push(s);
				} else {
					if (!stack.empty()) {
						isValid = isMatchingPair(s, stack.pop());
					} else {
						isValid = false;
					}

					if (!isValid) {
						break outerloop;
					}
				}
			}
		} else {
			isValid = true;
		}

		if (!stack.empty()) {
			isValid = false;
		}

		System.out.println(isValid);
		sc.close();
	}

	static boolean isMatchingPair(String one, String two) {
		if (one.equals(")") && two.equals("(")) {
			return true;
		}

		if (one.equals("}") && two.equals("{")) {
			return true;
		}

		if (one.equals("]") && two.equals("[")) {
			return true;
		}
		return false;
	}
}
