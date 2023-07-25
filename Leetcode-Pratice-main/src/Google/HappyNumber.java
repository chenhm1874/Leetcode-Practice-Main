package Google;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n){
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n=getNewNumber(n);

        }
        return true;
    }
    private int getNewNumber(int n){
        int sum=0;
        while (n!=0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }
}
