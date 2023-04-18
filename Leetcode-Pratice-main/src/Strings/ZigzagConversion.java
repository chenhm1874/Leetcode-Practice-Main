package Strings;

public class ZigzagConversion {
    public static String conversion(String s,int numRows){
        if (numRows ==1 ){
            return s;
        }
        char[] sChar=s.toCharArray();
        char[] res=new char[s.length()];
        int index=0;
        int root=2*numRows-2;
        for(int n=0;n<=numRows;n++){
            for (int i=0;i<s.length();i++){
                if((i+n)%root==0 || (i-n)%root == 0){
                    res[index]=sChar[i];
                    index++;
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String demo1="PAYPALISHIRING";
        String demo2="PAYPALISHIRING";
        String ans1=conversion(demo1,3);
        String ans2=conversion(demo2,4);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}