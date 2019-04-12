import math

def solution(brown, red):
    end = int(math.sqrt(red))
    for i in range(1,end+1):
        if red % i == 0:
            width = int(red/i)
            height = i
            needBrown = (width + height)*2 + 4
            if needBrown == brown:
                return [width + 2, height + 2]

print(solution(10,2))
print(solution(8,1))
print(solution(24,24))