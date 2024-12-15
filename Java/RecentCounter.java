class RecentCounter {

    List<Integer> recentRequests = new ArrayList<>();
    int bot = 0;

    public RecentCounter() {
        recentRequests = new ArrayList<>();
        bot = 0;
    }
    
    public int ping(int t) {
        bot = t - 3000;
        recentRequests.add(t);
        
        while (recentRequests.size() > 0 && recentRequests.get(0) < bot) {
            recentRequests.remove(0);
        }
        return recentRequests.size();

    }
}
