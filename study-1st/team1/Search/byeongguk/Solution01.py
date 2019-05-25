#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def solution(answers):
    order = []
    points = [0, 0, 0]
    patterns = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]

    for index, answer in enumerate(answers):
        if answer == patterns[0][index % 5]: points[0] += 1
        if answer == patterns[1][index % 8]: points[1] += 1
        if answer == patterns[2][index % 10]: points[2] += 1

    for index, point in enumerate(points, 1):
        if point == max(points):
            order.append(index)

    return order
