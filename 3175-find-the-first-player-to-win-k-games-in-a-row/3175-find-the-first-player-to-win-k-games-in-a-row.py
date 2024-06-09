class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        maxSkill = max(skills)
        wins, winningPlayer = 0, -1
        tempSkills = list(skills)
        while wins < k:
            if winningPlayer == maxSkill:
                break
            if (tempSkills[0] > tempSkills[1]):
                if winningPlayer == -1:
                    winningPlayer = tempSkills[0]
                    wins += 1
                elif winningPlayer == tempSkills[0]:
                    wins += 1
                elif winningPlayer != tempSkills[0]:
                    winningPlayer = tempSkills[0]
                    wins = 1
                ele = tempSkills.pop(1)
                tempSkills.append(ele)
            else:
                if winningPlayer == -1:
                    winningPlayer = tempSkills[1]
                    wins += 1
                elif winningPlayer == tempSkills[1]:
                    wins += 1
                elif winningPlayer != tempSkills[1]:
                    winningPlayer = tempSkills[1]
                    wins = 1
                ele = tempSkills.pop(0)
                tempSkills.append(ele)
        for i in range(0, len(skills)):
            if skills[i] == winningPlayer:
                return i
        return -1
                
        