class Solution:
    def getPossibilities(self, word, vis, letters):
        ans = []
        for i in range(0, len(word)):
            for j in letters[i]:
                temp = word[0:i] + j + word[i+1:]
                if temp != word and temp in vis and vis[temp] == 0:
                    ans.append(temp)
        return ans
    
    def ladderLength(self, beginWord: str, endWord: str, wL: List[str]) -> int:
        vis,letters = {},{}
        for i in range(0, len(beginWord)):
            letters[i] = set()
        wordList = set(wL)
        for i in wordList:
            vis[i] = 0
            for j in range(0, len(i)):
                letters[j].add(i[j])
        que = [beginWord]
        ans = 1
        vis[beginWord] = 1
        while len(que) != 0:
            size = len(que)
            for s in range(size):
                word = que.pop(0)
                if word == endWord:
                    return ans
                pos = self.getPossibilities(word, vis, letters)
                for p in pos:
                    que.append(p)
                    vis[p] = 1
            ans += 1
        return 0