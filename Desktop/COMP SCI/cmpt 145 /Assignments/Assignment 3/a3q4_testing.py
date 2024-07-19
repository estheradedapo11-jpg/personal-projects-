"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""


import a3q4 as CardModule

def close_enough(a, b, tolerance=0.0001):
    return abs(a - b) < tolerance

# Test Card.create()
deck = CardModule.Card.create()
expected_length = 52
if len(deck) != expected_length:
    print('Error in Card.create(): expected', expected_length, 'but got', len(deck), ' -- Should create a standard 52-card deck')

# Test Card.deal()
deck = CardModule.Card.create()
num_players = 3
num_cards = 5
hands = CardModule.Card.deal(num_cards, num_players, deck)
if len(hands) != num_players:
    print('Error in Card.deal(): expected', num_players, 'hands but got', len(hands), ' -- Should deal the correct number of cards to each player')

for hand in hands:
    if len(hand) != num_cards:
        print('Error in Card.deal(): expected hand size', num_cards, 'but got', len(hand), ' -- Should deal the correct number of cards to each player')

# Test Card.value()
card = "KS"
expected_value = 13
result = CardModule.Card.value(card)
if result != expected_value:
    print('Error in Card.value("KS"): expected', expected_value, 'but got', result, ' -- King should have a value of 13')

card = "4D"
expected_value = 4
result = CardModule.Card.value(card)
if result != expected_value:
    print('Error in Card.value("4D"): expected', expected_value, 'but got', result, ' -- Four should have a value of 4')

# Test Card.highest()
cards = ["5D", "10H", "QS", "8C", "JH"]
expected_highest = "QS"
result = CardModule.Card.highest(cards)
if result != expected_highest:
    print('Error in Card.highest(): expected', expected_highest, 'but got', result, ' -- Queen of Spades should be the highest card')

# Test Card.lowest()
cards = ["5D", "10H", "QS", "8C", "JH"]
expected_lowest = "5D"
result = CardModule.Card.lowest(cards)
if result != expected_lowest:
    print('Error in Card.lowest(): expected', expected_lowest, 'but got', result, ' -- Five of Diamonds should be the lowest card')

# Test Card.average()
cards = ["5D", "10H", "QS", "8C", "JH"]
expected_average = 9.2
result = CardModule.Card.average(cards)
if not close_enough(result, expected_average):
    print('Error in Card.average(): expected', expected_average, 'but got', result, ' -- Average value should be 9.2')

print('*** Test script completed ***')
