#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from itertools import permutations

def solution(numbers):
    combinations = set()
    for size in range(1, len(numbers) + 1):
        for combination in list(permutations(numbers, size)):
            combinations.add(int("".join(combination)))

    composite = set([0, 1])
    maximum = max(combinations)
    prime_list = [False, False] + [True] * (maximum - 1)
    for i, is_prime in enumerate(prime_list):
        if not i == 0 and not i == 1:
            for j in range(i, maximum + 1, i):
                if i != j and is_prime:
                    prime_list[j] = False
                    if j in combinations:
                        composite.add(j)

    return len(combinations - composite)
