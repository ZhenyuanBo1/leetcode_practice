/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        String hostname = startUrl.split("//")[1].split("/")[0];
        Queue<String> q = new LinkedList<>();
        q.add(startUrl);

        List<String> visited = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String url = q.remove();
                if(visited.contains(url)) continue;
                String currhostname = url.split("//")[1].split("/")[0];
                if(currhostname.equals(hostname)){
                    visited.add(url);
                    q.addAll(htmlParser.getUrls(url));
                }
            }
        }

        return visited;
    }
}