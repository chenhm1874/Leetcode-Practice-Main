package Strings;

public class MultiplyStrings {
    public static String multiply(String num1,String num2){
        int n=num1.length()+num2.length();
        int[] res=new int[n];
        if(num1=="0"|| num2=="0"){
            return "0";
        }
        for(int i=0;i<num1.length();i++){
            for (int j=0;j<num2.length();j++){
                res[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for(int i=n-1;i>0;i--){
            res[i-1]+=res[i]/10;
            res[i]%=10;
        }
        String ans="";
        for(int i=0;i<n;i++){
            if(res[i]==0 && ans.length()==0){
                continue;
            }
            else {
                ans+=(char)(res[i]+'0');
            }
        }
        return ans;
    }
    public static String multiply2(String num1,String num2){
        int n=num1.length()+num2.length();
        int[] res=new int[n];
        for(int i=num1.length()-1;i>=0;i--){
            for (int j=num2.length()-1;j>=0;j--){
                int sum=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1=i+j;
                int p2=i+j+1;
                sum+=res[p2];
                res[p1]+=sum/10;
                res[p2]=sum%10;
            }
        }
        int i=0;
        while(i<res.length && res[i]==0){
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(;i< res.length;i++){
            sb.append(res[i]+"");
        }
        return sb.length()==0? "0":sb.toString();

    }

    public static void main(String[] args) {
        String a1="123";
        String a2="456";
        String ans1=multiply(a1,a2);
        String ans2=multiply2(a1,a2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
