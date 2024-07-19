"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture ection: L02"""


class Card:
    suits = ['H', 'D', 'S', 'C']
    values = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
    value_map = {'A': 1, 'J': 11, 'Q': 12, 'K': 13}

    def create(self):
        deck = []
        for suit in self.suits:
            for value in self.values:
                deck.append(value + suit)
        return deck

    def deal(self, num_cards, num_players, deck):
        import random
        random.shuffle(deck)
        players_hands = [[] for _ in range(num_players)]
        card_index = 0

        for _ in range(num_cards):
            for player in players_hands:
                if card_index < len(deck):
                    player.append(deck[card_index])
                    card_index += 1
                else:
                    break

        return players_hands

    def value(self, card):
        value = card[:-1]
        return self.value_map.get(value, int(value))

    def highest(self, list_of_cards):
        return max(list_of_cards, key=self.value)

    def lowest(self, list_of_cards):
        return min(list_of_cards, key=self.value)

    def average(self, list_of_cards):
        total_value = sum(self.value(card) for card in list_of_cards)
        return total_value / len(list_of_cards) if list_of_cards else 0


# Example usage:
card = Card()
deck = card.create()
print(deck)

dealt_cards = card.deal(5, 3, deck)
print(dealt_cards)

card_value = card.value("KS")
print(card_value)

highest_card = card.highest(["5D", "10H", "QS", "8C", "JH"])
print(highest_card)

lowest_card = card.lowest(["5D", "10H", "QS", "8C", "JH"])
print(lowest_card)

average_value = card.average(["5D", "10H", "QS", "8C", "JH"])
print(average_value)
