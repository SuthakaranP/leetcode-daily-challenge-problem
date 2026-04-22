class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0)
        {
            return s;
        }
        int size = s.length();
        String source[] = new String[s.length()];
        char arr[] = s.toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            source[i] = String.valueOf(arr[i]);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(List<Integer> index:pairs)
        {
            graph.get(index.get(0)).add(index.get(1));
            graph.get(index.get(1)).add(index.get(0));
        }
        
        boolean visited[] = new boolean[size];
        List<List<Integer>> count = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            if(!visited[i])
            {
                List<Integer> group =new ArrayList<>();
                dfs(i,group,graph,visited);
                List<Character> chars = new ArrayList<>();
                for(int index:group)
                {
                  chars.add(arr[index]);
                }
                Collections.sort(group);
                Collections.sort(chars);
                for(int j=0;j<group.size();j++)
                {
                    arr[group.get(j)] = chars.get(j);
                }



               
                
            }
        }
      
        
        return new String(arr);
        
  
    }
    public void dfs(int node,List<Integer> group, List<List<Integer>> graph,boolean visited[])
    {
        visited[node] = true;
        group.add(node);
        for(int neighbour:graph.get(node))
        {
            if(!visited[neighbour])
            {
                dfs(neighbour,group,graph,visited);
            }
        }
    }
}