class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<String> al = new ArrayList<>();
        char arr[] = s.toCharArray();
        char brr[] = t.toCharArray();
        ArrayList<String> fl = new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            al.add(String.valueOf(arr[i]));
        }
        for(int j=0;j<t.length();j++)
        {
            fl.add(String.valueOf(brr[j]));
        }
        Collections.sort(al);
        Collections.sort(fl);
        if(al.equals(fl))
        {
            return true;
        }
        return false;
    }
}