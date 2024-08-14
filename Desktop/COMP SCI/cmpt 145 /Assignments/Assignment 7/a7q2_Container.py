"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""

class Container(object):
    """
    A generic container class that uses a list to store elements.
    """

    def __init__(self):
        """
        Initialize an empty Container object.

        Pre-conditions:
            None
        Post-conditions:
            An empty container is created.
        """
        self.data = list()

    def is_empty(self):
        """
        Check if the container is empty.

        Pre-conditions:
            None
        Post-conditions:
            None
        Return:
            True if the container is empty, False otherwise.
        """
        return len(self.data) == 0

    def size(self):
        """
        Return the number of elements in the container.

        Pre-conditions:
            None
        Post-conditions:
            None
        Return:
            The number of elements in the container.
        """
        return len(self.data)

    def __str__(self):
        """
        Return a string representation of the container's contents.

        Pre-conditions:
            None
        Post-conditions:
            None
        Return:
            A string that represents the container's elements.
        """
        return str(self.data)
