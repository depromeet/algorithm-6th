#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def solution(clothes):
    combi = 1
    cloth_list = []
    cloth_dict = {}

    for _, parts in clothes:
        if parts not in cloth_dict:
            cloth_dict[parts] = 0
        cloth_dict[parts] += 1


    cloth_list = list(cloth_dict.values())

    if len(cloth_list) == 1:
            return combi * cloth_list[0]

    for count in cloth_list:
        combi *= count + 1

    return combi - 1
