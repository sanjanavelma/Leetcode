import java.util.*;

class Solution {
    // Use a memoization map to store previously computed results
    private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        // If the result is already computed for the current expression, return it
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Traverse the expression and split by operator
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the current character is an operator, divide the expression into two parts
            if (c == '+' || c == '-' || c == '*') {
                // Compute the left and right parts
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // Combine the results from the left and right parts based on the operator
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        // If the expression is a pure number without operators, parse and return the number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Store the result in the memo map
        memo.put(expression, result);
        return result;
    }
}
