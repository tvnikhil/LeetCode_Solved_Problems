class Solution:
    def largestOddNumber(self, num: str) -> str:
        ptr = len(num)-1
        even = set(["0","2","4","6","8"])
        
        while ptr >= 0:
            if num[ptr] in even:
                ptr -= 1
                continue
            return num[:ptr+1]
        
        return ""
        