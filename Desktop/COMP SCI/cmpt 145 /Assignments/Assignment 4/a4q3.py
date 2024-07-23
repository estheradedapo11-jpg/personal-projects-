"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""

from node import Node

def to_string(node_chain):
    """
    Purpose:
     Convert a node chain into a string format that represents each node and its link.
     Use '[' for nodes, '|' for separating value, '*' for the link, '-' for continuation, and '/' for the end of the chain.

    Preconditions:
     node_chain: A node-chain, possibly empty (None).

    Postconditions: None

    Return: A string representation of the nodes.
    """
    if node_chain is None:
        return "EMPTY"

    result = []
    current = node_chain

    while current is not None:
        result.append("[ " + str(current.get_data()) + " | * -]")
        if current.get_next() is None:
            result[-1] = result[-1].replace("* -", "/")
        current = current.get_next()

    return " - - >".join(result)

def fun(data_in):
    # Replace with your actual function implementation
    return data_in

# Test case
data_in = Node(3, Node(0, Node(6)))
expected = Node(6, Node(0, Node(3)))
expected_str = to_string(expected)
result = fun(data_in)
result_str = to_string(result)

# Compare expected and result strings
if expected_str != result_str:
    print("Test failed: expected '" + expected_str + "', got '" + result_str + "'")
else:
    print("Test passed")
