def solution(participant, completion):
    d = {}
    for c in completion:
        d[c] = d.get(c, 0) + 1

    for p in participant:
        if d.get(p, 0) == 0:
            return p
        d[p] = d.get(p) - 1
