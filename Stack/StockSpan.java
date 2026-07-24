// package Stack;

import java.util.Stack;

/**
 * Topic: Stack
 * Problem: Stock Span Problem
 * 
 * Description: 
 * The span of the stock's price today is defined as the maximum number of consecutive 
 * days (starting from today and going backward) for which the price of the stock 
 * was less than or equal to today's price.
 * 
 * Intuition:
 * Use a stack to maintain the indices of the previous higher prices.
 * For each day, pop elements from the stack while the stack is not empty and 
 * the current price is greater than the price at the top of the stack.
 * If the stack becomes empty, it means all previous prices were smaller, so span = day + 1.
 * Otherwise, span = day - index of previous higher price.
 * 
 * Complexity: O(N) Time (each element is pushed/popped at most once), O(N) Space.
 */
public class StockSpan {
    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        
        // Base case: span for the first day is always 1
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            
            // Pop while current price is greater than or equal to the price at the stack's top index
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }
            
            // If stack is empty, all previous elements were smaller
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            // Push current index
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stock = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stock.length];
        
        stockSpan(stock, span);

        System.out.println("Stock Prices: ");
        for (int p : stock) System.out.print(p + " ");
        
        System.out.println("\nSpans: ");
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }
}
