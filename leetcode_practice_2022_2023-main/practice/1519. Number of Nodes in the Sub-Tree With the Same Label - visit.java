class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        //bi-directional
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(map.containsKey(node1)){
                map.get(node1).add(node2);
            }else{
                List<Integer> nodes = new ArrayList<>();
                nodes.add(node2);
                map.put(node1, nodes);
            }
            if(map.containsKey(node2)){
                map.get(node2).add(node1);
            }else{
                List<Integer> nodes = new ArrayList<>();
                nodes.add(node1);
                map.put(node2, nodes);
            }
        }

        int[] ans = new int[n];
        char[] labelsArr = labels.toCharArray();

        dfs(0, -1, map, labelsArr, ans);
        
        return ans;
    }

    private int[] dfs(int node, int parentNode, Map<Integer, List<Integer>> map, char[] labels, int[] ans){
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node]-'a'] = 1;

        for(int childNode: map.get(node)){
            if(childNode == parentNode) continue;
            int[] childNodeCounts = dfs(childNode, node, map, labels, ans);

            for(int i=0; i<26; i++){
                nodeCounts[i] += childNodeCounts[i];
            }
        }

        ans[node] = nodeCounts[labels[node]-'a'];

        return nodeCounts;
    }
}