class Animals():
    def habitat(self):
        pass

    def species(self):
        pass

    def eats(self):
        pass

class Herbivores(Animals):
    def eats(self):
        print("Usually plants, fruits, grass")
    
    def habitat(self):
        print("live on land")
    
class Carnivores(Animals):
    def eats(self):
        print("Usually flesh")
    
    def habitat(self):
        print("live on land")
    
class Omnivores(Animals):
    def eats(self):
        print("Usually plants, flesh, fruits")
    
    def habitat(self):
        print("live on land")

class Horse(Herbivores):
    def eats(self):
        Herbivores().eats()
    
    def habitat(self):
        Herbivores().habitat()

    def species(self):
        print("It is a mammal")
    
    def features(self):
        print("horses run very fast and are very strong")

class cats(Carnivores):

    def eats(self):
        Carnivores().eats()

    def habitat(self):
        Carnivores().habitat()

    def features(self):
        print("they four limbs, the big cats belong to this family")

class bear(Omnivores):

    def eats(self):
        Omnivores().eats()

    def habitat(self):
        Omnivores().habitat()

    def features(self):
        print("can also swim, they hibernate in winter season")

class lion(cats, Carnivores):

    def features(self):
        cats().features()
        print("referred as the king of the jungle, very powerful and fierce, found in Asia and Africa")

Horse().eats()
bear().habitat()
lion().features()
cats().eats()