class Solution {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for(int i=0;i<colors.length;i++)
        {
            if(i==colors.length-1)
            {
                break;
            }
            int count = 0;
            for(int j=i+1;j<colors.length;j++)
            {
                count++;
               if(colors[i] != colors[j])
               {
                 max = Math.max(max,count);
               }
               

            }
            result = Math.max(result,max);
            
        }
        return result;
    }
}