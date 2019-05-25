def solution(baseball):
    possible = []
    allcase = [case for case in range(123,988) if len(set(list(str(case)))) == 3 and not('0' in str(case))]
    for case in allcase:
        for game in baseball:
            strikeCount = strike(case, game[0])
            ballCount = ball(case, game[0])
            if strikeCount != game[1] or ballCount != game[2]:
                break
        else:
            possible.append(case)
    return len(possible)

def strike(n1, n2):
    return len([c1 for c1, c2 in zip(str(n1),str(n2)) if c1 == c2 ])

def ball(n1, n2):
    return len([c for c in str(n1) if c in str(n2)]) - strike(n1, n2)

print(solution([[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]))