class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       int n=grid.length;
       int total=n*n;
       int missing=-1;
       int repeat=-1;
       int arr[]=new int[total+1];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            arr[grid[i][j]]++;
        }
       } 
       for(int i=0;i<=total;i++){
        if(arr[i]==2){
            repeat=i;
        }
        else if(arr[i]==0){
            missing=i;
        }
       }   
       return new int[]{repeat,missing};
    }
}