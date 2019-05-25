#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from functools import cmp_to_key

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=cmp_to_key(lambda x, y: int(y + x) - int(x + y)))

    return ''.join(numbers) if numbers[0] != '0' else '0'
