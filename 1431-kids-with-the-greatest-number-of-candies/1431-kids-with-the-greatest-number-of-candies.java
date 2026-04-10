class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
   ArrayList<Boolean> result =new ArrayList<>();
   int max=0;
   for(int ch:candies){
    if(ch>max)
    max=ch;
   }     
   for(int ch:candies){
    if(ch+extraCandies>=max)
    result.add(true);
    else
    result.add(false);
   }
   return result;
    }
}