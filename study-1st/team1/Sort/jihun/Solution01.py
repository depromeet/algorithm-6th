def solution(array, commands):
    answer = []
    for cms in commands:
        l = sorted(array[cms[0]-1:cms[1]])
        answer.append(l[cms[2]-1])

    return answer
