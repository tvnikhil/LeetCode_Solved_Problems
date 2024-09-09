class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        level = 0
        que = deque(["0000"])
        vis = set()
        vis.add("0000")
        dead = set()
        for d in deadends:
            dead.add(d)
        
        while que:
            for _ in range(len(que)):
                curr = que.popleft()
                if curr in dead:
                    continue
                if curr == target:
                    return level
                for i in range(4):
                    pos1,pos2 = (int(curr[i])+1)%10, int(curr[i])-1
                    if pos2 < 0: pos2 = 10 + pos2
                    for pos in [pos1, pos2]:
                        combo = curr[0:i]+str(pos)+curr[i+1:]
                        if combo not in vis:
                            vis.add(combo)
                            que.append(combo)
            level += 1
        
        return -1