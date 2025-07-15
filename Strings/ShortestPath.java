package Strings;

public class ShortestPath{
    public static float FindShortestDistance(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir =path.charAt(i);
            if (dir =='N'||dir== 'n') {
                y++;
            }
            if (dir =='S'||dir== 's') {
                y--;
            }
            if (dir =='E'||dir== 'e') {
                x++;
            }
            if (dir =='W'||dir== 'w') {
                x--;
            }
        }
        return (float) (Math.sqrt((x*x)+(y*y)));
    }
    public static void main(String[] args) {
        System.out.println(FindShortestDistance("WNEENESENNN"));
    }
}