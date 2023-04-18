package zuochengyun;

//给定一个仅包含r,e,d组成的字符串，定义一个好e：这个e的左右字符为r和d，改变一个位置的字符的代价为1
//输出一个字符串获得尽可能多e所需要的最小修改次数
public class minCostMostE {
    public static class Info{
        public int mostGoodE;
        public int minCost;
        public Info(int good,int cost){
            mostGoodE=good;
            minCost=cost;
        }
    }
    //i-2-> prepre,i-1->pre,i可以成全i-1，返回最多的好e和最小的代价
    public static Info helper(char[] s,int i,char prepre,char pre){
        if(i==s.length){
            return new Info(0,0);
        }
        int mostE=0;
        int minCost=Integer.MAX_VALUE;
        //可能性1：i->r
        int cur1Value=prepre=='d'&& pre=='e'?1:0;
        int cur1Cost=s[i]=='r'?0:1;
        Info info1=helper(s,i+1,pre,'r');
        int p1Value=cur1Value+info1.mostGoodE;
        int p1Cost=cur1Cost+info1.minCost;
        //可能性2：i->e
        int cur2Value=0;
        int cur2Cost=s[i]=='e'?0:1;
        Info info2=helper(s,i+1,pre,'e');
        int p2Value=cur2Value+info2.mostGoodE;
        int p2Cost=cur2Cost+info2.minCost;
        //可能性3：i->d
        int cur3Value=prepre=='r'&& pre=='e'?1:0;
        int cur3Cost=s[i]=='d'?0:1;
        Info info3=helper(s,i+1,pre,'d');
        int p3Value=cur3Value+info3.mostGoodE;
        int p3Cost=cur3Cost+info3.minCost;
        if(mostE<p1Value){
            mostE=p1Value;
            minCost=p1Cost;
        }else if(mostE==p1Value){
            minCost=Math.min(minCost,p1Cost);
        }
        if(mostE<p2Value){
            mostE=p2Value;
            minCost=p2Cost;
        }else if(mostE==p2Value){
            minCost=Math.min(minCost,p2Cost);
        }
        if(mostE<p3Value){
            mostE=p3Value;
            minCost=p3Cost;
        }else if(mostE==p3Value){
            minCost=Math.min(minCost,p3Cost);
        }
        return new Info(mostE,minCost);
    }

}
