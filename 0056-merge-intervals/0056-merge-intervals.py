class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals, key = lambda x:x[0])
        ans = []
        i = 0
        while i < len(intervals):
            left, right = intervals[i][0], intervals[i][1]
            while (i < len(intervals) and intervals[i][0] <= right):
                right = max(right, intervals[i][1])
                i += 1
            ans.append([left, right])
        return ans
        