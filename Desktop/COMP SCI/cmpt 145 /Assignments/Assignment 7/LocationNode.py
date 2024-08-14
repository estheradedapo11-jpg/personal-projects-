"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""

import SuperNode as N

class LocationNode(N.SuperNode):
    def __init__(self, value=None, next_node=None):
        """
        Purpose: creates a LocationNode with optional data and next node
        Pre-condition: None
        Post-condition: A LocationNode is created, optionally with data and a reference to the next node.
        Return: None
        """
        N.SuperNode.__init__(self, value, next_node)  # Corrected the constructor call

    def get_current_location(self):
        """
        Purpose:
            Returns the current location stored in the node.
        Pre-conditions:
            None
        Post-condition:
            None
        Return:
            Returns current location stored in the node, or None if it is empty.
        """
        return self.get_data()

    def get_next_location(self):
        """
        Purpose:
            Returns the next location node.
        Pre-conditions:
            None
        Post-condition:
            None
        Return:
            Returns the next location node, or None if it is empty.
        """
        return self.get_next()

    def set_current_location(self, value):
        """
        Purpose:
            Sets the value of the current location node.
        Pre-conditions:
            value: The data value to be stored in the current location node.
        Post-condition:
            Current location node now contains the data value.
        Return:
            None
        """
        self.set_data(value)  # Corrected to pass the value to set_data

    def set_next_location(self, next_location):
        """
        Purpose:
            Sets the next location node.
        Pre-conditions:
            next_location: The node to be set as the next node.
        Post-condition:
            The next field now points to the next location node, i.e., next_location.
        Return:
            None
        """
        self.set_next(next_location)  # Corrected to set the next node

    def to_string(self):
        """
        Purpose: Create a string representation of the container.  E.g.,
        [ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]
        where 1 is the head of the container and 3 is the end of the container.
        Pre-conditions: None
        Post-conditions: None
        Return: A string representation of the container.
        """
        # Special case: empty node
        if self.get_data() is None:  # Corrected the check for None
            result = 'EMPTY'
        else:
            walker = self
            value = walker.get_current_location()

            result = '[ ' + str(value) + ' |'
            while walker.get_next_location() is not None:
                walker = walker.get_next_location()
                value = walker.get_current_location()

                result += ' *-]-->[ ' + str(value) + ' |'

            result += ' / ]'

        return result
