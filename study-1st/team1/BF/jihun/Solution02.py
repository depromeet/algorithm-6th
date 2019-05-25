import math


def solution(numbers):
    num_list = list(numbers)
    d = {}
    for i in num_list:
        d[i] = d.get(i, 0) + 1

    num_list.sort(reverse=True)
    max_num = int("".join(num_list))
    check_list = [True for _ in range(max_num + 1)]

    for i in range(2, int(math.sqrt(max_num)) + 1):
        if check_list[i]:
            j = i * 2
            while j <= max_num:
                check_list[j] = False
                j += i

    ans = 0
    for i in range(2, max_num + 1):
        if check_list[i] and is_num(d, i):
            ans += 1

    return ans


def is_num(d, n):
    l = list(str(n))
    d2 = {}
    for i in l:
        d2[i] = d2.get(i, 0) + 1

    for key in d2.keys():
        if d2[key] > d.get(key, 0):
            return False

    return True

