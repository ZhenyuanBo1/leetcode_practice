class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int p1 = 0;
        int p2 = p1 + 1;

        Arrays.sort(products);


        List<List<String>> res = new ArrayList<>();


        while(p2 <= searchWord.length()){
            String prefix = searchWord.substring(p1, p2);
            List<String> curr = new ArrayList<>();

            for(String product: products){
                if(product.startsWith(prefix) && curr.size()<3){
                    curr.add(product);
                }
            }

            res.add(curr);
            p2++;
        }

        return res;
    }
}