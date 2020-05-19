count = 0
num1 = 2
pairs = []
while count < 10:
    flag = 0
    sum = 0
    for i in pairs:
        if(i == num1):
            flag = 1

    if(flag == 0):        
        for i in range(1, num1):
            if(num1 % i == 0):
                sum = sum + i

        num2 = sum
        sum = 0
        for i in range(1, num2):
            if(num2 % i == 0):
                sum = sum + i

        if(sum == num1):
            if(num1 != num2):
                pairs.append(num1)
                pairs.append(num2)
                print(num1, num2)
                count = count + 1

    num1 = num1 + 1
