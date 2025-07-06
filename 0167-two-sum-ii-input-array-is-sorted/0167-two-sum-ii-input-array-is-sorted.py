class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        p1, p2 = 0, len(numbers)-1

        while p1 < p2:
            if numbers[p1]+numbers[p2] == target:
                return [p1+1, p2+1]
            if numbers[p1]+numbers[p2] < target:
                p1 += 1
            else:
                p2 -= 1
        
        return []
        