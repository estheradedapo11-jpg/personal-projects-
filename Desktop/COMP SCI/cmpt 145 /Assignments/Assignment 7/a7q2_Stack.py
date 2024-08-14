"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""


from a7q2_Container import Container

class Stack(Container):

    def __init__(self):
        """
        Purpose
            creates an empty stack
        """
        Container.__init__(self)


    def push(self, value):
        """
        Purpose
            adds the given data value to the stack
        Pre-conditions:
            value: data to be added
        Post-condition:
            the value is added to the stack
        Return:
            (none)
        """
        self.data.append(value)


    def pop(self):
        """
        Purpose
            Removes and returns a data value from the stack.
            Note: the stack cannot be empty!
        Post-condition:
            the first value is removed from the stack
        Return:
            the first value in the stack, or None
        """
        assert not self.is_empty(), 'popped an empty stack'

        return self.data.pop()


    def peek(self):
        """
        Purpose
            returns the value from the top of given stack
            without removing it
            Note: the stack cannot be empty!
        Post-condition:
            None
        Return:
            the value at the top of the stack
        """
        assert not self.is_empty(), 'peeked into an empty stack'

        return self.data[-1]

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
        return "Stack: " + str(self.data)