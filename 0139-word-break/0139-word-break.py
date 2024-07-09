class Solution:
    def helper(self, s, idx, wordDict, mem):
        if idx >= len(s):
            return True
        if idx in mem:
            return mem[idx]
        for word in wordDict:
            if word == s[idx:idx+len(word)]:
                if self.helper(s, idx+len(word), wordDict, mem):
                    mem[idx] = True
                    return True
        mem[idx] = False
        return False
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        return self.helper(s, 0, wordDict, {})