def solution(brown, red):
    lec = brown + red
    for r in range(1, red // 2 + 2):
        if red % r == 0:
            for b in range(r + 2, brown // 2 + 2):
                if lec % b == 0 and lec // b > red // r + 1:
                    return [lec // b, b]
