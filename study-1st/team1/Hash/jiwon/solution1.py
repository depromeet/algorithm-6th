def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if completion[i] != participant[i]:
            return participant[i]
        elif completion[i] == completion[-1:][0]:
            return participant[i+1]
