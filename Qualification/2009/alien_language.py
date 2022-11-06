import re

def matcher(pattern, words):
    pattern = pattern.replace("(", "[").replace(")", "]")
    res_1 = 0
    for word in words:
        match = re.search(pattern, word)
        res_1 = res_1 + 1 if match else res_1
    return res_1


line = str(input()).split()
num_cases = int(line[2])
words_num = int(line[1])
words = []
for words_num in range(1, words_num + 1):
    words.append(str(input()))
for case in range(1, num_cases + 1):
    res_main = matcher(str(input()), words)
    print(f'Case #{case}: {res_main}')
