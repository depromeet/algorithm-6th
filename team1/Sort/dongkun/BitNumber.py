from functools import cmp_to_key

def sortFunction(n1,n2):
    return int(str(n1)+str(n2))-int(str(n2)+str(n1))

def solution(numbers):
    sortedNumbers = [str(n) for n in sorted(numbers, key=cmp_to_key(sortFunction), reverse=True)]
    return str(int("".join(sortedNumbers)))