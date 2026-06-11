
class Twitter {
    private Tweet[] tweets = new Tweet[10];
    HashMap<Integer, Set<Integer>> follows = new HashMap<>();
    int size =0;

    private void ensureSize(){
        if (this.size == tweets.length)
            tweets = Arrays.copyOf(this.tweets, this.tweets.length * 2);
    }

    public void postTweet(int userId, int tweetId) {
        ensureSize();
        tweets[size++] = new Tweet(userId, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> valid = follows.getOrDefault(userId, Set.of(userId));

        for (int i = size -1; i >= 0 && feed.size() < 10; i--){
            if (valid.contains(tweets[i].getUserId()))
                feed.add(tweets[i].getId());
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        follows.compute(followerId, (k,v) -> {
            if (v == null){
                v = new HashSet<>();
                v.add(followerId);
            }
            v.add(followeeId);
            return v;
        });
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        follows.computeIfPresent(followerId, (k,v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}

class Tweet {
    private final int id;
    private final int userId;

    public Tweet(int userId, int tweetId){
        this.id = tweetId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}