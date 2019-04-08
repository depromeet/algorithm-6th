def solution(answers):
    guesses = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]

    cor = [0, 0, 0]
    for idx, ans in enumerate(answers):
        for i in range(3):
            if guesses[i][idx%len(guesses[i])] == ans:
                cor[i] += 1

    m = max(cor)
    answer = []
    for i, c in enumerate(cor):
        if c == m:
            answer.append(i + 1)

    return answer
