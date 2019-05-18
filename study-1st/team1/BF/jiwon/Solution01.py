:rom itertools import cycle

def solution(answers):
    ppl1=[1, 2, 3, 4, 5]
    ppl2=[2, 1, 2, 3, 2, 4, 2, 5]
    ppl3=[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    people1 = people2 = people3 = mmax = 0
    aanswer = list()
    a = list()
    for p1, p2, p3, answer in zip(cycle(ppl1), cycle(ppl2), cycle(ppl3), answers):
        if p1 == answer: people1 +=1
        if p2 == answer: people2 +=1
        if p3 == answer: people3 +=1
    aanswer.extend([people1, people2, people3])
    mmax = max(people1, people2, people3)
    if mmax == people1: a.append(1)
    if mmax == people2: a.append(2)
    if mmax == people3: a.append(3)
    return a
