class Animals():
    def habitat(self):
        pass

    def species(self):
        pass

    def eats(self):
        pass

class Herbivores():
    def __eats(self):
        print("Usually plants, fruits, grass")
    
    def __habitat(self):
        print("live on land")
    
class Carnivores():
    def __eats(self):
        print("Usually flesh")
    
    def __habitat(self):
        print("live on land")
    
class Omnivores():
    def __eats(self):
        print("Usually plants, flesh, fruits")
    
    def __habitat(self):
        print("live on land")

class Horse():

    def species(self):
        print("It is a mammal")
    
    def features(self):
        print("horses run very fast and are very strong")

class cats():

    def features(self):
        print("they four limbs, the big cats belong to this family")

class bear():

    def features(self):
        print("can also swim, they hibernate in winter season")

class lion():

    def features(self):
        print("referred as the king of the jungle, very powerful and fierce, found in Asia and Africa")

lion().features()
Omnivores().eats()