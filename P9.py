num = 2
count = 0
print("1")

while count < 9:
    sum = 0
    div = 0
    for i in range(1, num + 1):

        if(num % i == 0):
            sum = sum + 1 / i
            div = div + 1

    har_mean = div / sum

    if(har_mean.is_integer()):
        print(num)
        count = count + 1

    num = num + 1
