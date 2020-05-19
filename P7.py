min = int(input("enter lower limit"))
max = int(input("enter upper limit"))

for i in range(min, max):
    sum = 0
    n = i
    while i > 0:
        sum = sum + (i % 10) ** 3
        i = i // 10

    if(sum == n):
        print(sum)
