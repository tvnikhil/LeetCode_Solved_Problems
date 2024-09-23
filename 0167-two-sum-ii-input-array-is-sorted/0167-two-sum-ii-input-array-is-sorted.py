class Solution:
    def twoSum(self, arr: List[int], target: int) -> List[int]:
        p, q = 0, len(arr)-1
        while p < q:
            if arr[p]+arr[q] == target:
                return [p+1,q+1]
            if arr[p]+arr[q] > target:
                q -= 1
            else:
                p += 1
        return [0,0]
            