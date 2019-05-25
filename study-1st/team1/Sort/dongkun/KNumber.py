def solution(array, commands):
    answer = []
    for command in commands:
        start = command[0] - 1
        end = command[1] - 1
        sliced = array[start:end+1]
        sortedList = sorted(sliced)
        answer.append(sortedList[command[2]-1])
    return answer