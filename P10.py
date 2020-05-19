first_term = int(input("enter the first term"))
ratio = int(input("enter the ratio"))
temp = first_term
print(temp)

for i in range(1, 10):
    term = temp * ratio
    temp = term
    print(term)
