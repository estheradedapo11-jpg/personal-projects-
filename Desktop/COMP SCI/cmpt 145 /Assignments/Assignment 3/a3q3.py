"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""


class Statistics:
    def __init__(self):
        self.data = []
        self._count = 0
        self._sum = 0.0

    def add(self, value):
        self.data.append(value)
        self._count += 1
        self._sum += value

    def count(self):
        return self._count

    def mean(self):
        if self._count == 0:
            return 0
        return self._sum / self._count

    def range(self):
        if self._count == 0:
            return None
        return max(self.data) - min(self.data)

    def mode(self):
        if self._count == 0:
            return None
        frequency = {}
        for value in self.data:
            if value in frequency:
                frequency[value] += 1
            else:
                frequency[value] = 1
        mode_value = max(frequency, key=frequency.get)
        return mode_value

    def max(self):
        if self._count == 0:
            return None
        return max(self.data)

    def min(self):
        if self._count == 0:
            return None
        return min(self.data)
