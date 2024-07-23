"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""


def check_chains(chain1, chain2):
    """
    Purpose:
    - Checks 2 node chains.
    - If they are identical (the same objects), returns "same chain".
    - If they are equal (same data values in the same order), returns "same values".
    - Otherwise, returns "different".

    Preconditions:
    - chain1: A node-chain, possibly empty.
    - chain2: A node-chain, possibly empty.

    Postconditions: None

    Return:
    - A string indicating the relationship between the two chains.
    """
    # Check if both chains are the exact same object
    if chain1 is chain2:
        return "same chain"

    # Check if both chains have the same values
    current1, current2 = chain1, chain2
    while current1 is not None and current2 is not None:
        if current1.get_data() != current2.get_data():
            return "different"
        current1 = current1.get_next()
        current2 = current2.get_next()

    # Both chains must be of the same length to be considered "same values"
    if current1 is None and current2 is None:
        return "same values"

    return "different"



def copync(node_chain):
    """
    Purpose:
    - Creates a duplicate of the given node chain.

    Preconditions:
    - node_chain: A node-chain, possibly empty.

    Postconditions: None

    Return:
    - A new node chain, a node-for-node copy of the given one.
    """
    if node_chain is None:
        return None

    # Create the head of the new chain
    new_chain = node(node_chain.get_data())
    current_new = new_chain
    current_old = node_chain.get_next()

    # Copy the rest of the chain
    while current_old is not None:
        current_new.set_next(node(current_old.get_data()))
        current_new = current_new.get_next()
        current_old = current_old.get_next()

    return new_chain

def double_up(node_chain):
    """
    Purpose:
    - Modifies the node chain so that every node is duplicated.
    - E.g., given 1 -> 2 -> 3 changes to 1 -> 1 -> 2 -> 2 -> 3 -> 3.

    Preconditions:
    - node_chain: A node-chain, possibly empty.

    Postconditions:
    - The chain is modified to have each node repeated once.

    Return:
    - None
    """
    current = node_chain

    while current is not None:
        # Create a duplicate node
        duplicate = node(current.get_data())
        # Insert the duplicate node after the current node
        duplicate.set_next(current.get_next())
        current.set_next(duplicate)
        # Move to the node after the duplicate
        current = duplicate.get_next()

