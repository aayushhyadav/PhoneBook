import random

min = 1
max = 6

roll_again = "yes"

while roll_again == "yes":
    print (random.randint(min, max))
    roll_again = input("Role the dice again?")

