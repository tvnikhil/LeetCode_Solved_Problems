class Solution:
    def findMedianSortedArrays(self, arr1: List[int], arr2: List[int]) -> float:
        mergedArr = []
        p1, p2 = 0, 0

        while p1 < len(arr1) and p2 < len(arr2):
            if arr1[p1] <= arr2[p2]:
                mergedArr.append(arr1[p1])
                p1 += 1
            else:
                mergedArr.append(arr2[p2])
                p2 += 1
        while p1 < len(arr1):
            mergedArr.append(arr1[p1])
            p1 += 1
        while p2 < len(arr2):
            mergedArr.append(arr2[p2])
            p2 += 1

        size = len(mergedArr)
        if size % 2 == 0:
            mid = (size//2)
            return (mergedArr[mid-1] + mergedArr[mid])/2
        else:
            return mergedArr[size//2]
        