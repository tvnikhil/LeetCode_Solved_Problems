class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        hm = {}
        ans = ""
        
        for i in s:
            if i in hm:
                hm[i] += 1
            else:
                hm[i] = 1
        sHm = sorted(hm.items(), key=lambda x: x[1], reverse=True)
        for i in sHm:
            ans += i[0] * i[1]
        
        return ans