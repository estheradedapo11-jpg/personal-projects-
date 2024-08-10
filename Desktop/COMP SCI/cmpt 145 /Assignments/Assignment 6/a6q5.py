"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""

class treenode:
    def __init__(self, data, left=None, right=None):
        """
        Purpose:
            Initialize a new treenode with the given data and optional left and right children.
        Pre-conditions:
            data: The data value to be stored in the node (any type).
            left: A reference to the left child (another treenode or None).
            right: A reference to the right child (another treenode or None).
        Post-conditions:
            A new treenode is created with the specified data, left child, and right child.
        Returns:
            None
        """
        self.data = data
        self.left = left
        self.right = right


def ordered(tnode):
    """
    Purpose:
        Determines if a binary tree is ordered according to binary search tree (BST) properties.

    Pre-conditions:
        :param tnode: The root node of the binary tree (can be None for an empty tree).

    Post-conditions:
        The function performs an in-order traversal to determine if the tree is ordered.

    Returns:
        True if the tree is ordered (i.e., follows BST properties), False otherwise.
    """

    def is_ordered_recursive(node, lower_bound, upper_bound):
        """
        Purpose:
            Helper function to recursively check if a subtree is ordered.

        Pre-conditions:
            :param node: The current node in the binary tree.
            :param lower_bound: The lower bound for the node's data value.
            :param upper_bound: The upper bound for the node's data value.

        Post-conditions:
            Checks if the current node's value is within the specified bounds and recursively
            validates the left and right subtrees.

        Returns:
            True if the subtree rooted at `node` is ordered, False otherwise.
        """
        if node is None:
            return True
        if not (lower_bound < node.data < upper_bound):
            return False
        return (is_ordered_recursive(node.left, lower_bound, node.data) and
                is_ordered_recursive(node.right, node.data, upper_bound))

    return is_ordered_recursive(tnode, float('-inf'), float('inf'))