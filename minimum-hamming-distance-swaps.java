class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int size = target.length;
        int result = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int swap[]:allowedSwaps)
        {
            graph.get(swap[0]).add(swap[1]);
            graph.get(swap[1]).add(swap[0]);
        }
        boolean visited[] = new boolean[size];
        for(int i=0;i<size;i++)
        {
            if(!visited[i])
            {
                List<Integer> group = new ArrayList<>();
                dfs(i,group,graph,visited);
                Map<Integer,Integer> hm = new HashMap<>();
                for(int index:group)
                {
                    hm.put(source[index],hm.getOrDefault(source[index],0)+1);

                }
                for(int index:group)
                {
                    if(hm.getOrDefault(target[index],0)>0)
                    {
                        hm.put(target[index],hm.get(target[index])-1);
                    }
                    else
                    {
                        result++;
                    }
                }

            }
        }
        return result;
    }
    public void dfs(int node,List<Integer> group,List<List<Integer>>graph,boolean visited[])
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