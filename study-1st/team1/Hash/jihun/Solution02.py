def solution(phone_book):
    for i, num1 in enumerate(phone_book):
        for j in range(i + 1, len(phone_book)):
            num2 = phone_book[j]
            if len(num1) < len(num2):
                s = num1
                l = num2
            else:
                s = num2
                l = num1

            if l.startswith(s):
                return False

    return True
