class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();

        buildAncestor(p, list1);
        buildAncestor(q, list2);

        for(int i=0; i<list1.size(); i++){
            Node n = list1.get(i);
            if(list2.contains(n)) return n;
        }

        return null;

    }
    private void buildAncestor(Node p, List<Node> list){
        if(p.parent != null){
            list.add(p);
            buildAncestor(p.parent, list);
        }else{
            list.add(p);
            return;
        }
    }
}