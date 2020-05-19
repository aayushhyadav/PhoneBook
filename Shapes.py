import turtle
import math

class Shapes():
    def area(self):
        print("Each shape has an area associated with it which can be calculated")
    
class line():
    def area(self):
        print("area is zero")
    
    def draw(self):
        turtle.goto(10, 10)
    
class polygon():
    def sides(self):
        print("Has 4 or more sides")

    def perimeter(self):
        print("Perimeter can be calculated by adding up the length of all sides")

class circle():
    def circumference(self, r):
        self.__c = 3.142 * 2 * r
        return self.__c
    
    def area(self, r):
        self.__a = 3.142 *r * r
        return a
    
    def draw(self, r):
        turtle.circle(r)

class rectangle():
    def area(self, l, b):
        self.__a = l * b
        return self.__a
    
    def perimeter(self, l, b):
        self.__p = 2 * (l + b)
        return self.__p
    
    def draw(self, l, b):
        turtle.goto(l, 0)
        turtle.goto(l, b)
        turtle.goto(0, b)
        turtle.goto(0, 0)
    
class square():
    def area(self, s):
        self.__a = s * s
        return self.__a
    
    def perimeter(self, s):
        self.__p = 4 * s
        return self.__p
    
    def draw(self, s):
        turtle.goto(s, 0)
        turtle.goto(s, s)
        turtle.goto(0, s)
        turtle.goto(0, 0)

class triangle():
    def perimeter(self, a, b, c):
        self.__p = a + b + c
        return self.__p

    def area(self, b, h):
        self.__a = .5 * b * h 
        return self.__a

class equilateral():
    def area(self, s):
        self.__a = (1.72/2) * s * s
        return self.__a
    
    def perimeter(self, s):
        self.__p = s + s + s
        return self.__p
    
    def draw(self, a):
        turtle.goto(a, 0)
        turtle.left(120)
        turtle.forward(a)
        turtle.left(120)
        turtle.forward(a)

class rightangled():
    def area(self, b, h):
        self.__a = .5 * b * h
        return self.__a

    def perimeter(self, a, b, c):
        self.__p = a + b + c
        return self.__p
    
    def draw(self, b, h, hypo):
        self.__angle = math.degrees((math.atan(h / b)))
        turtle.goto(b, 0)
        turtle.left(180 - self.__angle)
        turtle.forward(hypo)
        turtle.left(90 + self.__angle)
        turtle.forward(h)

class isosceles():
    def area(self, b, h):
        self.__a = .5 * b * h
        return self.__a
    
    def perimeter(self, a, b, c):
        self.__p = a + b + c
        return self.__p

    def draw(self, b, h):
        turtle.goto(b, 0)
        self.__angle = math.degrees(math.atan(h / (b / 2)))
        self.__side = math.sqrt(h**2 + (b / 2)**2)
        turtle.left(180 - self.__angle)
        turtle.forward(self.__side)
        turtle.left(2 * self.__angle)
        turtle.forward(self.__side)

print(rectangle().area(100, 200))
print(rectangle().perimeter(100, 200))
rectangle().draw(100, 200)
"""
print(square().area(200))
print(square().perimeter(200))
square().draw(200)

print(equilateral().area(200))
print(equilateral().perimeter(200))
equilateral().draw(100)


print(rightangled().area(300, 400))
print(rightangled().perimeter(300, 400, 500))
rightangled().draw(300, 400, 500)
"""