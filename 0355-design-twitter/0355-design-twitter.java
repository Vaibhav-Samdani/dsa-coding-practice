class Twitter {

    class Tweet {
        int id;
        int time;

        Tweet(int tweetId, int time) {
            this.id = tweetId;
            this.time = time;
        }
    }

    class Node {
        int userId;
        int index; // Current tweet index in this user's list
        Tweet tweet;

        Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }

    private int time;
    private Map<Integer, List<Tweet>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
     time = 0;
            tweetMap = new HashMap<>();
            followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        List<Tweet> tweets = tweetMap.get(userId);
        tweets.add(new Tweet(tweetId, time++));

        // Keep only latest 10 tweets
        if (tweets.size() > 10) {
            tweets.remove(0);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.tweet.time - a.tweet.time);

        // Add yourself
        if (tweetMap.containsKey(userId)) {
            List<Tweet> tweets = tweetMap.get(userId);
            int last = tweets.size() - 1;
            pq.offer(new Node(userId, last, tweets.get(last)));
        }

        // Add followees
        for (int followee : followMap.getOrDefault(userId, Collections.emptySet())) {
            if (!tweetMap.containsKey(followee)) continue;

            List<Tweet> tweets = tweetMap.get(followee);
            int last = tweets.size() - 1;

            pq.offer(new Node(followee, last, tweets.get(last)));
        }

        while (!pq.isEmpty() && ans.size() < 10) {
            Node curr = pq.poll();
            ans.add(curr.tweet.id);

            // Push previous tweet of same user
            if (curr.index > 0) {
                int prev = curr.index - 1;
                List<Tweet> tweets = tweetMap.get(curr.userId);

                pq.offer(new Node(curr.userId, prev, tweets.get(prev)));
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
