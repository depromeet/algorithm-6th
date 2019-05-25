from itertools import permutations

def primen(num):
    if num > 1:
        for i in range(2, num//2 + 1):
            if (num/i) == (num//i):
                return False
            else:
                return True
    else:
        return False

def solution(numbers):
    p = list()
    s = list()
    count = 0
    for i in range(len(numbers)):
        n = list(permutations(list(numbers), i+1))
        p.extend(n)
    for i in range(len(p)):
        s.append("".join(p[i]))
    s = list(set(list(map(int, s))))
    for num in s:
        if primen(num):
            count += 1
    return count

numbers = "17"
print(solution(numbers))