import java.util.*;

public class StockSpan {

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        // for first day span is 1
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            // this for loop used to go at the particular day and get the current price
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                // this loop is ensuring that the previous element in the
                // stack is not the lower value than current price
                // Removing all lower values from the stack since they cannot be part of the
                // span

                /*
                 * another way : when u take current price u take a look that the
                 * stack is not having lesser than value of currprice as
                 * higher cannot take seat on lower
                 * The stack maintains indices of previous higher stock prices.
                 * If the current stock price is greater than the one at the top of the stack,
                 * we pop elements until we find a higher price.
                 * 
                 * for ex: currPrice 30
                 * and in stack u have 25
                 * 30 cannot be seated on 25 so 25 will be poped out and 30 will pushed
                 */
                s.pop();
            }
            if (s.isEmpty()) {
                // If stack is empty, it means no greater element exists on the left, so span =
                // i+1

                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                // bycoming to this step u will have the stack in an series
                // so last element will be high ie prevHigh so subtracting with the currday
                // price ull get the span
                span[i] = i - prevHigh;
            }

            s.push(i);
        }

    }

    public static void main(String[] args) {
        int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stock.length];
        stockSpan(stock, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }
}
