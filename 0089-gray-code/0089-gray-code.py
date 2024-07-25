class Solution:
    def generateBin(self, n, leng):
        res = ""
        while n > 0:
            res = str(n % 2) + res
            n = n//2
        if leng == len(res): return res
        else: return "0"*(leng-len(res)) + res
    
    def getPossibilities(self, num, binArr, binDec, visited):
        ans = []
        binary = binArr[num]
        for i in range(len(binary)):
            if binary[i] == "0":
                temp = binary[0:i] + "1" + binary[i+1:]
            else:
                temp = binary[0:i] + "0" + binary[i+1:]
            if visited[binDec[temp]] == False:
                ans.append(binDec[temp])
        return ans
    
    def dfs(self, n, num, seq, binArr, visited, binDec):
        if visited[num] == False:
            visited[num] = True
            seq.append(num)
            pos = self.getPossibilities(num, binArr, binDec, visited)
            if len(pos) != 0:
                for j in pos:
                    if self.dfs(n, j, seq, binArr, visited, binDec) != False:
                        return seq
            else: return seq
            seq.pop()
            visited[num] = False
    
    def grayCode(self, n: int) -> List[int]:
        seq = []
        binArr, binDec = {}, {}
        l = pow(2, n)
        for i in range(0, l):
            binArr[i] = self.generateBin(i, n)
            binDec[binArr[i]] = i
        visited = {}
        for i in binArr: visited[i] = False
        if self.dfs(n, 0, seq, binArr, visited, binDec) != False:
            return seq
        