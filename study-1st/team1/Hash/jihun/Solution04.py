from collections import defaultdict


def solution(genres, plays):
    answer = []
    d = defaultdict(lambda: [0, []])

    for i, g in enumerate(genres):
        d[g][0] += plays[i]
        d[g][1].append((plays[i], i))

    for _, l in sorted(d.values(), reverse=True):
        songs = sorted(l, reverse=True)[:2]

        if len(songs) == 2 and songs[0][0] == songs[1][0]:
            songs[0], songs[1] = songs[1], songs[0]

        answer += [i for _, i in songs]

    return answer
