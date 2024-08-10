"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""


class node(object):
    """ A version of the node class with **public** attributes.
        This makes the use of node objects a bit more conveinient for 
        implementing LList class.  
        
        Since there are no setters and getters, we use the attributes directly.
        
        This is safe because the node class is defined in this module.  
        No one else will use this version of the class.
    """

    def __init__(self, data, next=None):
        """
        Create a new node for the given data.
        Pre-conditions:
            data:  Any data value to be stored in the node
            next:  Another node (or None, by default)
        """
        self.data = data
        self.next = next
    
    # Note: use the attributes directly; no setters or getters!


class LList(object):
    def __init__(self):
        """
        Purpose
            creates an empty list
        """
        self._size = 0     # how many elements in the stack
        self._head = None  # the node chain starts here; initially empty
        self._tail = None


    def is_empty(self):
        """
        Purpose
            Checks if the given list has no data in it
        Return:
            :return True if the list has no data, or False otherwise
        """
        return self.size() == 0


    def size(self):
        """
        Purpose
            Returns the number of data values in the given list
        Return:
            :return The number of data values in the list
        """
        return self._size


    def prepend(self, val):
        """
        Purpose
            Insert val at the front of the node chain
        Preconditions:
            :param val:   a value of any kind
        Post-conditions:
            The list increases in size.
            The new value is at index 0.
            The values previously in the list appear after the new value.
        Return:
            :return None
        """
        anode = node(val, self._head)
        if self.is_empty():
            self._tail = anode
        self._head = anode
        self._size += 1


    def append(self, val):
        """
        Purpose
            Insert val at the end of the node chain
        Preconditions:
            :param val:   a value of any kind
        Post-conditions:
            The list increases in size.
            The new value is last in the list.
        Return:
            :return None
        """
        anode = node(val)
        if self.is_empty():
            self._head = anode
        else:
            self._tail.next = anode
        self._tail = anode
        self._size += 1


    def retrieve_data(self, idx):
        """
        Purpose
            Return the value stored at the index idx
        Preconditions:
            :param idx:   a non-negative integer
        Post-conditions:
            none
        Return:
            :return (True, val) if val is stored at index idx and idx is valid
            :return (False, None) if the idx is not valid for the list
        """
        if idx < 0 or idx >= self.size():
            return False, None
        anode = self._head
        i = 0
        while anode is not None and i < idx:
            anode = anode.next
            i += 1
        return True, anode.data


    def set_data(self, idx, val):
        """
        Purpose
            Store val at the index idx
        Preconditions:
            :param val:   a value of any kind
            :param idx:   a non-negative integer
        Post-conditions:
            The value stored at index idx changes to val
        Return:
            :return True if the index was valid, False otherwise
        """
        if idx < 0 or idx >= self.size():
            return False
        anode = self._head
        i = 0
        while anode is not None and i < idx:
            anode = anode.next
            i += 1
        anode.data = val
        return True


    def remove_from_front(self):
        """
        Purpose
            Removes and returns the first value 
        Post-conditions:
            The list decreases in size.
            The returned value is no longer in in the list.
        Return:
            :return The pair (True, value) if self is not empty
            :return The pair (False, None) if self is empty
        """
        if self.is_empty():
            return False, None
        if self.size() == 1:
            self._tail = None
        anode = self._head
        self._head = anode.next 
        self._size -= 1
        return True, anode.data 


    def remove_from_back(self):
        """
        Purpose
            Removes and returns the last value
        Post-conditions:
            The list decreases in size.
            The returned value is no longer in in the list.
        Return:
            :return The pair True, value if self is not empty
            :return The pair False, None if self is empty
        """
        if self.is_empty():
            return False, None

        if self.size() == 1:
            anode = self._head
            self._head = None
            self._tail = None
            self._size = 0
            return True, anode.data

        # general case
        aprev = self._head
        anode = aprev.next 
        while anode.next is not None:
            aprev = anode
            anode = anode.next

        self._tail = aprev
        aprev.next = None 
        self._size -= 1
        return True, anode.data


    def get_index_of_value(self, val):
        """
        Purpose
            Return the smallest index of the given val.
        Preconditions:
            :param val:   a value of any kind
        Post-conditions:
            none
        Return:
            :return True, idx if the val appears in self
            :return False, None if the vale does not appear in self
        """
        anode = self._head
        i = 0
        while anode is not None:
            if anode.data == val:
                return True, i
            anode = anode.next
            i += 1
        return False, None
    

    ### Additional methods for OOP Lab HERE:
    # to_string()
    # copy()
    # extend(other)

    def to_string(self):
        """
        Purpose:
            Create a string representation of the node chain. E.g.,
            [ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]
        Pre-conditions:
        Post_conditions:
            None
        Return:
            A string representation of the nodes.
        """
        if self.is_empty():
            return "EMPTY"

        result = ""
        anode = self._head
        while anode is not None:
            if anode.next is None:
                result += f"[ {anode.data} | / ]"
            else:
                result += f"[ {anode.data} | *-]-->"
            anode = anode.next
        return result

    def copy(self):
        """
        Purpose:
            Copy a LList and its values.
        Pre-conditions:
        Post_conditions:
            A new LList is created and it contains NEW nodes with the same values.
            The original LList is unmodified.
        Return:
            A LList.
        """
        new_list = LList()
        if self.is_empty():
            return new_list

        current = self._head
        while current is not None:
            new_list.append(current.data)
            current = current.next
        return new_list

    def extend(self, other):
        """
        Purpose:
            Extend the current LList by linking a copy of the `other` LList to the end.
        Pre-conditions:
            :param other:  A LList
        Post_conditions:
            `other` is added to the end of the current LList.
            The current LList size has grown by the size of `other`.
            `other` is not modified
        Return:
            None
        """
        if other.is_empty():
            return

        copy_of_other = other.copy()
        if self.is_empty():
            self._head = copy_of_other._head
            self._tail = copy_of_other._tail
        else:
            self._tail.next = copy_of_other._head
            self._tail = copy_of_other._tail

        self._size += copy_of_other.size()


# Testing to verify correctness of your method implementations
if __name__ == "__main__":
    ###
    ### Testing to_string
    ###

    #### UNIT TEST CASES
    test_item = 'to_string()'
    data_in = LList()
    expected = 'EMPTY'
    reason = 'Empty node chain'

    result = data_in.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


    # testing standard stringified LList
    chain1 = LList()
    chain1.append(1)
    chain1.append(2)
    chain1.append(3)

    test_item = 'to_string()'
    data_in = chain1
    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]'
    reason = 'Chain with 3 nodes'

    result = data_in.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))
    
    # testing appended LList
    chain1.append(5)

    test_item = 'to_string()'
    data_in = chain1
    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | *-]-->[ 5 | / ]'
    reason = 'Chain with 4 nodes after appending'
    
    result = data_in.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

    ###
    ### Testing copy
    ###

    # testing copy with empty LList
    chain_empty = LList()
    chain0 = chain_empty.copy()

    test_item = 'copy()'
    data_in = chain0
    expected = 'EMPTY'
    reason = 'Copying an empty chain'
    
    result = data_in.copy().to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))
    
    # Confirming that an emprt list copy results in different references
    test_item = 'copy()'
    expected = False
    reason = 'chain0 should not have the same reference as chain_empty. True copy failed.'
    result = chain0 is chain_empty

    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

    # testing copy with standard LList
    chain1 = LList()
    chain1.append(1)
    chain1.append(2)
    chain1.append(3)

    test_item = 'copy()'
    data_in = chain1
    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]'
    reason = 'Copy with 3 nodes.'
    
    result = data_in.copy().to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))
    
    
    # Note that the data needs to be properly copied as well.
    # The node references should be different, but the data should be the same
    result = chain1.copy()
    walker1 = chain1._head
    walker2 = result._head
    while walker1 != None and walker2 != None:

        if walker1 is walker2: 
            print('Test failed: {}: After a copy, node references should differ.'.format(test_item))
        if walker1.data != walker2.data:
            print('Test failed: {}: After a copy, node data values should be equal.'.format(test_item))
        walker1 = walker1.next
        walker2 = walker2.next

    ###
    ### Testing extend()
    ###
        
    # Adding chain1 and chain2 together
    chain2 = chain1.copy()
    test_item = 'extend()'
    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]'
    reason = 'chain2 should remain the same after extending chain1 by chain2.'

    chain1.extend(chain2)
    result = chain2.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | *-]-->[ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]'
    reason = 'chain1 should be extended by chain2.'
    result = chain1.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

    # Extending chain1 with an empty LList
    test_item = 'extend()'
    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]'
    reason = 'chain2 should remain the same after extending it by an empty LList.'
    chain2.extend(LList())
    result = chain2.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

    # Extending an Empty LList with chain2
    chain0 = LList()
    chain0.extend(chain2)
    test_item = 'extend()'
    expected = '[ 1 | *-]-->[ 2 | *-]-->[ 3 | / ]'
    reason = 'chain0 should contain the same contents of chain2 since it was empty when extending chain2.'
    result = chain0.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

        # Extending an Empty LList with an empty LList
    chain0 = LList()
    chain0.extend(LList())
    test_item = 'extend()'
    expected = 'EMPTY'
    reason = 'chain0 should still be empty after extending it by an empty LList.'
    result = chain0.to_string()
    if result != expected:
        print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))
