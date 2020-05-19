page_list = [2, 4, 6, 12, 16, 17, 20, 21]
flag = 0

for i in range(1,26):
    for j in page_list:
        if(i == j):
            flag = 1

    if(flag == 0):
        print(i)

    flag = 0
