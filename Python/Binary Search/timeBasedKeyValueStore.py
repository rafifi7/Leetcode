from collections import defaultdict


class TimeMap:

    def __init__(self):
        self.dct = defaultdict(list)


    def set(self, key: str, value: str, timestamp: int) -> None:
        self.dct[key].append((value, timestamp))
        return        

    def get(self, key: str, timestamp: int) -> str:
        # most recent one value
        timeList = self.dct[key]
        l, r = 0, len(timeList) - 1
 
        while l <= r:
            m = (l + r) // 2
            if timeList[m][1] <= timestamp:
                l = m + 1
            else:
                r = m - 1
        if r >= 0:
            return timeList[r][0]
        else:
            return ""
# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)