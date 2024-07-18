# CMPT 145 Course material
# Copyright (c) 2017-2020 Michael C Horsch
# All rights reserved.
#
# This document contains resources for homework assigned to students of
# CMPT 145 and shall not be distributed without permission.  Posting this 
# file to a public or private website, or providing this file to a person 
# not registered in CMPT 145, constitutes Academic Misconduct, according 
# to the University of Saskatchewan Policy on Academic Misconduct.

# Synopsis:
#   Defines the Registry ADT
#   A registry records a Boolean value for a range of integers.
#   It can be used to record observations or events.

"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""


class Registry(object):

    def __init__(self, size, value):
        """
        Purpose:
            Initialize a registry of a give size filled with the 
            given value
        Pre-conditions:
            size: number of elements in the registry
            value: the default initial value for all elements
        """
        self.__reg = [value for i in range(size)]


    def set(self, i):
        """
        Purpose:
            Set the registry element at i to True
        Pre-conditions:
            i: an index, in the correct range for reg
        Post-conditions:
            the registry value at i is set to True
        Return:
            (none)
        """
        self.__reg[i] = True


    def reset(self, i):
        """
        Purpose:
            Set the registry element at i to False
        Pre-conditions:
            i: an index, in the correct range for reg
        Post-conditions:
            the registry value at i is set to False
        Return:
            (none)
        """
        self.__reg[i] = False


    def is_registered(self, i):
        """
        Purpose:
            Returns the value stored at registry element i
        Pre-conditions:
            i: an index, in the correct range for reg
        Post-conditions:
            (none)
        Return:
            the value stored at element i
        """
        return self.__reg[i]

    def show(self):
        """
        Purpose:
            Shows the current Registry values
        Pre-conditions:
            (none)
        Post-conditions:
            (none)
        Returns:
            (none)
        """
        print(self.__reg)

    def extend(self, size, value):
        """
        Purpose:
            Extend the registry. This grows the registry to the given size.
            The value given will be the new default value for the extended registers.
        Pre-conditions:
            size: number of elements in the registry
            value: the default initial value for all elements
        Post-conditions:
            IMPORTANT: The previous entries in the registry retain their values.
            The registry is expanded. Entries up to the original size are kept the same.
            New entries are set to the value provided in the argument.
        Returns:
            (none)

        Warnings:
            This method asserts that the new size is greater than the original Registry size.
        """
        assert size > len(self.__reg), ("Error in Registry method extend(size, value).\n "
                               "Provided size must be greater than the original Registry size.")
        # TODO your implementation here
        new_elements = size - len(self.__reg)
        # Extend the registry with the new elements, each set to the value provided
        self.__reg.extend([value] * new_elements)
