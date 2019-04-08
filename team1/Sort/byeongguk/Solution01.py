#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def solution(array, commands):
    answer = []

    for command in commands:
        temp = sorted(array[command[0] - 1:command[1]])
        answer.append(temp[command[2] - 1])

    return answer
