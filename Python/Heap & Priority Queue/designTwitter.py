from collections import defaultdict
import heapq
from typing import List


class Twitter:

    def __init__(self):
        self.timestamp = 0

        class User:
            def __init__(self):
                self.following = set()
                self.posts = []

        self.users = defaultdict(User)


    def postTweet(self, userId: int, tweetId: int) -> None:
        self.timestamp += 1
        #follow yourself
        self.users[userId].following.add(userId)
        
        # using time giving timestamp to our posts list
        self.users[userId].posts.append((-self.timestamp, tweetId))

        return None

    def getNewsFeed(self, userId: int) -> List[int]:
        ret = []
        maxHeap = []
        
        # get the user's following set
        following = self.users[userId].following

        for followee in following:
            posts = self.users[followee].posts
            if posts:
                # add (timestamp, postId, tweeterId)
                heapq.heappush(maxHeap, (posts[-1][0], posts[-1][1], followee, 1) )

        while len(ret) < 10 and maxHeap:
            timestamp, postId, tweeterId, index = heapq.heappop(maxHeap)

            ret.append(postId)
            tweeterPosts = self.users[tweeterId].posts
            if len(tweeterPosts) > index:
                # push into maxheap the timestamp, postId, followee, index
                newIndex = index + 1
                newPost = tweeterPosts[-newIndex]
                newTimestamp = newPost[0]
                newPostId = newPost[1]
                heapq.heappush(maxHeap, (newTimestamp, newPostId, tweeterId, newIndex))

        
        return ret



    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId:
            return
        # followerId will add followeeId to their set
        self.users[followerId].following.add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.users[followerId].following.discard(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)