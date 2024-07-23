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
