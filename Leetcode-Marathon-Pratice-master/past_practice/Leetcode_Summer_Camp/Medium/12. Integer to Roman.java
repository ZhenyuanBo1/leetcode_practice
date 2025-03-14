class Solution {
    public String intToRoman(int num) {
       String res = "";
       while(num>0){
          if(num>=1 && num<5){
              if(num/4==1){
                  res+="IV";
                  num-=4;
              }else{
                  res += buildSymbol(num);
                  break;
              }
          }else if(num>=5 && num<10){
              if(num/9==1){
                  res+="IX";
                  num-=9;
              }else{
                  res+='V';
                  num-=5;
              }
          }else if(num>=10 && num<50){
              if(num/40==1){
                  res+="XL";
                  num-=40;
              }else{
                  res+='X';
                  num-=10;
              }
          }else if(num>=50 && num<100){
              if(num/90==1){
                  res+="XC";
                  num-=90;
              }else{
                  res+='L';
                  num-=50;
              }
          }else if(num>=100 && num<500){
              if(num/400==1){
                  res+="CD";
                  num-=400;
              }else{
                  res+='C';
                  num-=100;
              }
          }else if(num>=500 && num<1000){
              if(num/900==1){
                res+="CM";
                num-=900;
              }else{
                res+='D';
                num-=500;
              }
          }else if(num>=1000){
              res+='M';
              num-=1000;
          }
       }
       return res;
    }
    private String buildSymbol(int num){
        String symbol="";
        for(int i=0; i<num; i++){
            symbol+="I";
        }
        return symbol;
    }
}