public class TrappingWater {
    public static int TWF(int[] height){
        int n= height.length;
        //base cases
        if (n==1 || n==2) {
            System.out.println("oops water spilled out");
            return 0;
        }

        //1. left max boundary array(LMB)
        int[] LMB= new int[n];
        LMB[0]=height[0];
        for(int i=1;i<n;i++){
            LMB[i]= Math.max(height[i], LMB[i-1]);
        }

        //2. right max boundary array(RMB)
        int[] RMB = new int[n];
        RMB[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            RMB[i]=Math.max(height[i],RMB[i+1]);
        }

        //3. loop{  water level (wl = min(LMB,RMB))
        //          trapped water =(wl-height)*width}
        int tw=0;
        for(int i=0;i<n;i++){
            int wl=Math.min(LMB[i], RMB[i]);
            tw+= wl-height[i];
        }
        return tw;
    }
    public static void main(String[] args) {
        int[] he={2,3,4,5,6,7};
        //int[] he={1};
        System.out.println(TWF(he));
    }
}
