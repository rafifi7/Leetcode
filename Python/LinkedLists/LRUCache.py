class LRUCache:

    def __init__(self, capacity: int):
        # we can use a hashmap that contains the key value pairs
        # a field to the key that was least recently used
        # a size field that gives us our size 

        # stores int key: int values
        # we can make our recent keys a linked list of most recent to least recent
        # 1 <-> 2

        self.cache = {} 
        self.recentKey = None
        self.size = capacity


    def get(self, key: int) -> int:
        if key in self.cache:
            self.recentKey = key
            return self.cache[key]
        return -1

    def put(self, key: int, value: int) -> None:
        if self.size == len(self.cache):
            del self.cache[self.recentKey]
        self.cache[key] = value


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)