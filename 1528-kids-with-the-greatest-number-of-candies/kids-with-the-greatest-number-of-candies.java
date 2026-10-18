class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       List<Boolean> list=new ArrayList<>();
       int max=candies[0];
       for(int i=0;i<candies.length;i++){
         if(candies[i]>max){
            max=candies[i];
         }
       } 
       boolean j=true;
       for(int i=0;i<candies.length;i++){
        int s=candies[i]+extraCandies;
         if(s>=max){
            j=true;
            list.add(j);
         }
         else{
            j=false;
            list.add(j);
         }
       
       }
       return list;
    }
}