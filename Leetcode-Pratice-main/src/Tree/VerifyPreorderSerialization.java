package Tree;

public class VerifyPreorderSerialization {
    public boolean isValidSerializeation(String preorder){
        if(preorder ==null || preorder.length()==0){
            return true;
        }
        //degree=outbound-inbound,root默认有两出度一入度
        int degree=1;
        String[] chars=preorder.split(",");
        for(String c:chars){
            degree--;
            if(degree<0){
                return false;
            }
            if(!c.equals("#")){
                degree+=2;
            }

        }
        return degree==0;
    }
}
