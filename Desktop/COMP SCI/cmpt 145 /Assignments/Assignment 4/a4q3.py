"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""


def to_string(node_chain):
    """
    Create a string representation of the node chain.

    Preconditions:
    - node_chain: A node-chain, possibly empty (None).
    Postconditions:
    Return: A string representation of the nodes.
    """
    if node_chain is None:
        return "EMPTY"

    result = []
    current = node_chain

    while current is not None:
        result.append(f"[ {current.value} | * -]")
        if current.next is None:
            result[-1] = result[-1].replace("* -", "/")
        current = current.next

    return " - - >".join(result)
