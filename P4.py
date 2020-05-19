import random

number = random.randint(1,100)
guess_num = int(input("Guess the number-"))

if(guess_num > number):
    print("The actual number is smaller")

elif(guess_num < number):
    print("The actual number is greater")

elif(guess_num == number):
    print("That's correct")
        
count = 1

while (guess_num != number) and (count < 5):
    guess_num = int(input("Guess the number-"))
    if(guess_num > number):
        print("The actual number is smaller")

    elif(guess_num < number):
        print("The actual number is greater")

    elif(guess_num == number):
        print("That's correct")

    count = count + 1


