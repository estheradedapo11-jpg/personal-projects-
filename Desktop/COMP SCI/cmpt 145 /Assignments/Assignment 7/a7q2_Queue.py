"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""

from a7q2_Container import Container

class Queue(Container):
    def __init__(self):
        """
        Purpose:
            Creates an empty queue.
        """
        Container.__init__(self)  # Corrected the typo here

    def enqueue(self, value):
        """
        Purpose:
            Adds the given data value to the queue.
        Pre-conditions:
            value: The data to be added.
        Post-condition:
            The value is added to the queue.
        Return:
            None
        """
        self.data.append(value)  # Changed self.__data to self.data

    def dequeue(self):
        """
        Purpose:
            Removes and returns a data value from the queue.
            Note: the queue cannot be empty!
        Post-condition:
            The first value is removed from the queue.
        Return:
            The first value in the queue, or None.
        """
        assert not self.is_empty(), 'Dequeued from an empty queue'
        return self.data.pop(0)  # Changed self.__data to self.data

    def peek(self):
        """
        Purpose:
            Returns the value from the front of the queue without removing it.
            Note: the queue cannot be empty!
        Post-condition:
            None
        Return:
            The value at the front of the queue.
        """
        assert not self.is_empty(), 'Peeked into an empty queue'
        return self.data[0]  # Changed self.__data to self.data

    def __str__(self):
        """
        Purpose:
            Return a string representation of the queue's contents.
        Pre-conditions:
            None
        Post-conditions:
            None
        Return:
            A string that represents the queue's elements in a FIFO order.
        """
        return "Queue: " + str(self.data)  # Changed self.__data to self.data
