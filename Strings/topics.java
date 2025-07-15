package Strings;

public class topics {
    public static void subString(String str,int si, int ei){
        String substr ="";
        for(int i=si; i<ei;i++){
            substr+=str.charAt(i);
        }
        System.out.println(substr);
    }  
    public static void Comparing(){
        String[] arr ={"apple","banana","mango"};
        String largest =arr[0];
        for(int i=1;i<arr.length;i++){
            if (largest.compareTo(arr[i])<0) {
                /*
                 * -ve smaller
                 * 0 equal
                 * +ve largest
                 */
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }
    public static void StringbuilderConcept(){
        /*Strings in Java are immutable, meaning their values cannot be changed after creation.
        // Any modification (e.g., append, replace) creates a new string object.
        // This leads to increased memory usage and higher time complexity for frequent changes.
        // Multiple intermediate objects are created for even minor modifications.
        // To handle such cases efficiently, use StringBuilder or StringBuffer for mutable strings.
        */
        StringBuilder sb = new StringBuilder();
        for(char ch='a';ch<='z';ch++ ){
            sb.append(ch);
        }
        System.out.println(sb.length());
        System.out.println(sb);
    }
    
    public static void main(String[] args) {
        /*String word = "HELLO WORLD";
        System.out.println(word.substring(0,5));
        subString(word, 0, 5);
        */
        //Comparing();
        StringbuilderConcept();
    }
}
