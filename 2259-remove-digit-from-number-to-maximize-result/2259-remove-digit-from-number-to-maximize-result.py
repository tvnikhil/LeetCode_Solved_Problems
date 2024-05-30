class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        maxi = -1
        for i in range(0, len(number)):
            temp = -1
            if i < len(number) - 1 and number[i] == digit:
                temp = number[:i] + number[i + 1:]
            elif i == len(number) - 1 and number[i] == digit:
                temp = number[:i]
            maxi = max(int(maxi), int(temp))
        return str(maxi)