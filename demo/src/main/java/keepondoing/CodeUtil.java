package keepondoing;

import javax.xml.bind.SchemaOutputResolver;

public class CodeUtil {
     //仿造实现string中第一次出现比较字符的位置
     public static int indexof(String tar,String sour)throws Exception{

         if(null==tar||null==sour||tar.length()<1||sour.length()<1||tar.length()>sour.length()){
             return -1;
         }
         System.out.println("比较字符串长度"+tar.length()+"；qita："+sour.length());
         char[] tararray = tar.toCharArray();
         char[] sourarray = sour.toCharArray();
         int tarlength = tararray.length;
         int sourlength = sourarray.length;
         System.out.println("目标长度"+tarlength+"比较源："+sourlength);

         for(int i=0;i<sourlength;i++){
             boolean r=false;
             char c = sourarray[i];
             if(c==tararray[0] && (i+tarlength<=sourlength)){

                 int count=0;
                for(int j = 0; j<tarlength; j++){//注意下标越界
                    if(sourarray[i+j]==tararray[j]){
                        count+=1;

                    }
                    if(count==tarlength){//确定是比较数组的长度
                        r=true;
                    }
                   if(r){

                      return i;
                   }
                }
             }

         }

         return -1;
     }
// 第二种思路，对比较源字符串进行相应长度substring(i;son.length())，再equals比较0

    //求一个数的阶乘

    public static void main(String[] args) {
        String sour="abljixjhghg";//11
        String AIM="hg";
        Integer find=null;
        try {
            find = indexof(AIM, sour);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("下标位置"+find);
    }

     }





