class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;

        List<List<TreeNode>> levels = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int currSize = queue.size();
            List<TreeNode>currLevel = new ArrayList<>();
            for(int i=0; i<currSize; i++){
                TreeNode currNode = queue.remove();
                currLevel.add(currNode);
                if(currNode != null) queue.add(currNode.left);
                if(currNode != null) queue.add(currNode.right);
            }
            levels.add(currLevel);
        }

        levels.remove(levels.size()-1);
        
        //check if every level is filled
        for(int i=0; i<levels.size() - 1; i++){
            List<TreeNode> currLevel = levels.get(i);
            if(currLevel.contains(null)) return false;
        }
        
        List<TreeNode> lastLevel = levels.get(levels.size()-1);
        boolean hasSeenNull = false;
        for(int k=0; k<lastLevel.size(); k++){
            if(lastLevel.get(k) == null){
                hasSeenNull = true;
            }else if(lastLevel.get(k) != null && hasSeenNull){
                return false;
            }
        }

        return true;
    }
}