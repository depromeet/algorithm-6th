def solution(array, commands):
    start = list()
    last = list()
    pick = list()
    aanswer = list()
    answer = list()
    for i in range(len(commands)):
        start.append(commands[i][0])
        last.append(commands[i][1])
        pick.append(commands[i][2])
    for i in range(len(start)):
        c = array.copy()
        c = array[start[i]-1:last[i]]
        c.sort()
        aanswer.append(c)
    for i in range(len(pick)):
        answer.append(aanswer[i][pick[i]-1])
    return answer

array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
print(solution(array, commands))

# pick : [3, 1, 3]
# answer: [[2, 3, 5, 6], [6], [1, 2, 3, 4, 5, 6, 7]]