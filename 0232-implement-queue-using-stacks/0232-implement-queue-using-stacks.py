class MyQueue:

    def __init__(self):
        self.stk1 = list()
        self.stk2 = list()

    def push(self, x: int) -> None:
        self.stk1.append(x)

    def pop(self) -> int:
        ans = None
        while len(self.stk1) > 1:
            x = self.stk1.pop(len(self.stk1)-1)
            self.stk2.append(x)
        ans = self.stk1.pop(len(self.stk1)-1)
        while self.stk2:
            self.stk1.append(self.stk2.pop(len(self.stk2)-1))
        return ans

    def peek(self) -> int:
        if self.stk1:
            return self.stk1[0]

    def empty(self) -> bool:
        if len(self.stk1)>0:
            return False
        return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()