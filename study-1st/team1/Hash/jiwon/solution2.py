def solution(phone_book):
    f = 0
    pb = phone_book.copy()
    for i in range(len(pb)):
        del pb[i]
        for number in pb:
            if phone_book[i] in number:
                print(phone_book[i], number)
                f += 1
        pb = phone_book.copy()
    if f !=0 :
        return False
    else:
        return True

a = ['12','123','1235','567','88']
print(solution(a))

# 코드가 효율적이지 않은건 알겠는데 정확성이 왜 60밖에 안나오는지 모르겠어요 ㅠ ㅠ 
# 입출력예제는 다 맞습니다 
