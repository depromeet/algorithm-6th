def solution(answers):
    list = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    checks = [0,0,0]
    for idx, answer in enumerate(answers):
        for i in range(3):
            checks[i] += 1 if list[i][idx%len(list[i])] == answer else 0
    answer = [idx + 1 for idx,check in enumerate(checks) if check == max(checks)]
    return answer

print(solution([1,2,3,4,5]))
print(solution([1,3,2,4,2]))