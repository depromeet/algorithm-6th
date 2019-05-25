#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def solution(phone_book):
    numbers = list()
    
    for phone in phone_book:
        for number in numbers:
            if phone.startswith(number) or number.startswith(phone):
                return False

        numbers.append(phone)
        
    return True
