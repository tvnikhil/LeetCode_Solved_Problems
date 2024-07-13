class Solution:
    def getJustHigh(self, arr, target):
        low, high = 0, len(arr)-1
        ans = -1
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] > target:
                ans = mid
                high = mid - 1
            else:
                low = mid + 1
        return ans
    
    def survivedRobotsHealths(self, position: List[int], healths: List[int], directions: str) -> List[int]:
        healthDict = {}
        rightList, leftList = [], []
        n = len(position)
        for i in range(0, n):
            if directions[i] == "R":
                rightList.append(position[i])
            else:
                leftList.append(position[i])
            healthDict[position[i]] = healths[i]
        rightList = sorted(rightList)
        leftList = sorted(leftList)
        rightLen, leftLen = len(rightList), len(leftList)
        right = rightLen-1
        while (right >= 0):
            justHigh = self.getJustHigh(leftList, rightList[right])
            if justHigh == -1:
                right -= 1
                continue
            else:
                if healthDict[rightList[right]] > healthDict[leftList[justHigh]]:
                    healthDict[rightList[right]] -= 1
                    healthDict[leftList[justHigh]] = 0
                    leftList.pop(justHigh)
                elif healthDict[rightList[right]] < healthDict[leftList[justHigh]]:
                    healthDict[leftList[justHigh]] -= 1
                    healthDict[rightList[right]] = 0
                    right -= 1
                else:
                    healthDict[rightList[right]] = 0
                    healthDict[leftList[justHigh]] = 0
                    right -= 1
                    leftList.pop(justHigh)
        ans = []
        for i in range(0, n):
            if healthDict[position[i]] != 0:
                ans.append(healthDict[position[i]])
        return ans
        