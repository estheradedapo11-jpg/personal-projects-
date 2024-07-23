"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""

from node import Node

def to_string(node_chain):
    """
    Convert a node chain into a string format that represents each node and its link.
    """
    if node_chain is None:
        return "EMPTY"

    result = []
    current = node_chain

    while current is not None:
        result.append(f"[ {current.get_data()} | * -]")
        if current.get_next() is None:
            result[-1] = result[-1].replace("* -", "/")
        current = current.get_next()

    return " - - >".join(result)

def check_chains(chain1, chain2):
    """
    Check if two node chains are identical or have the same values.
    """
    if chain1 is chain2:
        return "same chain"

    current1, current2 = chain1, chain2
    while current1 is not None and current2 is not None:
        if current1.get_data() != current2.get_data():
            return "different"
        current1 = current1.get_next()
        current2 = current2.get_next()

    if current1 is None and current2 is None:
        return "same values"

    return "different"

def copync(node_chain):
    """
    Create a duplicate of the given node chain.
    """
    if node_chain is None:
        return None

    new_chain = Node(node_chain.get_data())
    current_new = new_chain
    current_old = node_chain.get_next()

    while current_old is not None:
        current_new.set_next(Node(current_old.get_data()))
        current_new = current_new.get_next()
        current_old = current_old.get_next()

    return new_chain

def double_up(node_chain):
    """
    Modify the node chain so that every node is duplicated.
    """
    current = node_chain

    while current is not None:
        duplicate = Node(current.get_data())
        duplicate.set_next(current.get_next())
        current.set_next(duplicate)
        current = duplicate.get_next()

# Test cases
# Test check_chains
chain1 = Node(1, Node(1, Node(9)))
chain2 = Node(2, Node(15))
chain3 = Node(1, Node(1, Node(9)))
print(check_chains(chain1, chain1))  # Expected: "same chain"
print(check_chains(chain1, chain2))  # Expected: "different"
print(check_chains(chain1, chain3))  # Expected: "same values"

# Test copync
chain1 = Node(1, Node(1, Node(9)))
chain2 = copync(chain1)
print(check_chains(chain1, chain2))  # Expected: "same values"

# Test double_up
chain1 = Node(1, Node(2, Node(9)))
before_str = to_string(chain1)
double_up(chain1)
after_str = to_string(chain1)
print("before:", before_str)  # Expected: "before: [ 1 | * -] - - >[ 2 | * -] - - >[ 9 | / ]"
print("after:", after_str)    # Expected: "after: [ 1 | * -] - - >[ 1 | * -] - - >[ 2 | * -] - - >[ 2 | * -] - - >[ 9 | * -] - - >[ 9 | / ]"
