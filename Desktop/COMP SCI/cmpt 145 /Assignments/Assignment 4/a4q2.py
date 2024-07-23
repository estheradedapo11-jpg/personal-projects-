"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""

from Queue import Queue


def battle_simulation(filename):
    # Initialize the queue and lists for defeated monsters
    space_monsters = Queue()
    godzilla_defeated = []
    mothra_defeated = []

    # Open the file and process each monster
    with open(filename, 'r') as file:
        for line in file:
            monster = line.strip()
            if monster == 'Godzilla':
                if not space_monsters.empty():
                    godzilla_defeated.append(space_monsters.get())
            elif monster == 'Mothra':
                if not space_monsters.empty():
                    mothra_defeated.append(space_monsters.get())
            else:
                space_monsters.put(monster)

    # Determine the outcome of the battle
    if space_monsters.empty():
        print("The space monsters were beaten!")
        print("Godzilla defeated:")
        for monster in godzilla_defeated:
            print(monster)
        print("Mothra defeated:")
        for monster in mothra_defeated:
            print(monster)
    else:
        print("Oh no! The space monsters won thanks to", space_monsters.queue[0])

# Example usage
battle_simulation('monsters1.txt')
battle_simulation('monsters2.txt')


