package Strings;

public class compression {
    public static String comp(String str){
        StringBuilder st = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count =1;
            while (i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;
                i++;
            }
            st.append(str.charAt(i));
            if (count > 1) {
                st.append(count.toString());
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {
        String stri = "aaabbbccd";
        System.out.println(comp(stri));
    }
}
