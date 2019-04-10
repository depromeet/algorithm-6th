def solution(baseball):
    ans = 0
    for i in range(123, 988):
        found = True
        nums = list(str(i))
        if '0' in nums or nums[0] == nums[1] or nums[0] == nums[2] or nums[1] == nums[2]:
            continue
        for bb in baseball:
            nums2 = list(str(bb[0]))
            s = 0
            b = 0

            for j in range(3):
                if nums[j] == nums2[j]:
                    s += 1
                elif nums2[j] in nums:
                    b += 1

            if s != bb[1] or b != bb[2]:
                found = False
                break

        if found:
            ans += 1

    return ans
