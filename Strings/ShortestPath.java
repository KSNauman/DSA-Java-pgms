// package Strings;

/**
 * Topic: Strings
 * Problem: Shortest Path
 * 
 * Description: 
 * Given a string containing 'N', 'S', 'E', 'W' representing movements (North, South, East, West),
 * calculate the shortest distance from the origin (0, 0) to the final destination.
 * 
 * Intuition:
 * Each character changes the coordinate:
 * 'N' -> y++
 * 'S' -> y--
 * 'E' -> x++
 * 'W' -> x--
 * After processing all moves, the shortest path is the Euclidean distance from (0,0) to (x,y):
 * Distance = sqrt(x^2 + y^2).
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class ShortestPath {
    public static float findShortestDistance(String path) {
        int x = 0, y = 0;
        
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            
            // Move North/South/East/West
            if (dir == 'N' || dir == 'n') y++;
            else if (dir == 'S' || dir == 's') y--;
            else if (dir == 'E' || dir == 'e') x++;
            else if (dir == 'W' || dir == 'w') x--;
        }
        
        // Euclidean distance formula
        return (float) Math.sqrt((x * x) + (y * y));
    }
    
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println("Path: " + path);
        System.out.println("Shortest Distance: " + findShortestDistance(path));
    }
}