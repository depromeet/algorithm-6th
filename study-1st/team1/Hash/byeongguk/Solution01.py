#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from collections import Counter

def solution(participant, completion):
    participant_dict = Counter(participant)

    for comp in completion:
        if comp in participant_dict:
            participant_dict[comp] -= 1

    for person, count in participant_dict.items():
        if count != 0:
            return person
