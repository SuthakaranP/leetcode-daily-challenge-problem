class Solution {
    public List<Integer> getRow(int rowIndex) 
    {
     List<Integer> al = new ArrayList<>();
     al.add(1);
     for(int i=1;i<=rowIndex;i++)
     {
        List<Integer> fl = new ArrayList<>();
        fl.add(1);
        for(int j=1;j<i;j++)
        {
            fl.add(al.get(j-1)+al.get(j));
        }
        fl.add(1);
        al = fl;
     }
     return al;

     }
    }
