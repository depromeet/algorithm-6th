def solution(clothes):
    d = {}
    for clothe in clothes:
        d[clothe[1]] = d.get(clothe[1], 1) + 1

    answer = 1
    for count in d.values():
        answer = answer * count

    return answer - 1
