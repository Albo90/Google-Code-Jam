def snapper_chain_2010(snippers_num, knocks_num):
    first_ok = (2 ** snippers_num)
    start = first_ok - 1
    if ((knocks_num >= start) and (knocks_num - start) % first_ok == 0):
        return "ON"
    else:
        return "OFF"


num_cases = int(input())
for case in range(1, num_cases + 1):
    input_str = str(input())
    input_num = input_str.split()
    res = snapper_chain_2010(int(input_num[0]), int(input_num[1]))
    print(f'Case #{case}: {res}')
