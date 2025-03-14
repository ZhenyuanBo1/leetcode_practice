public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private int id = 0;
    private String prefixURL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(++id, longUrl);
        return prefixURL + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int targetID = Integer.parseInt(shortUrl.substring(prefixURL.length()));
        return map.get(targetID);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));