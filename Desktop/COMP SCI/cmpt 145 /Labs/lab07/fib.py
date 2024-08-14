"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""

import treenode as tn

def fibonacci(n):
    """
    Purpose:
        The Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, 13, ...
    Preconditions:
        :param n: a non-negative integer
    Return:
        :return: the nth Fibonacci number, starting with fib(0) = 0
    """
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        f1 = fibonacci(n-1)
        f2 = fibonacci(n-2)
        return f1 + f2

def fibtree(n):
    """
    Purpose:
        Create a Fibonacci tree for n.
    Preconditions:
        :param n: a non-negative integer
    Return:
        :return: a TreeNode representing the root of the Fibonacci tree
    """
    if n == 0:
        return tn.create('0')
    elif n == 1:
        return tn.create('1')
    else:
        left_subtree = fibtree(n-1)
        right_subtree = fibtree(n-2)
        return tn.create(n, left_subtree, right_subtree)

def fibm(n):
    """
    Purpose:
        The Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, 13, ...
    Preconditions:
        :param n: a non-negative integer
    Return:
        :return: the nth Fibonacci number, starting with fib(0) = 0
    """
    memo = {}
    def memoized_fib(n):
        if n == 0:
            return 0
        elif n == 1:
            return 1
        elif n in memo:
            return memo[n]
        else:
            f1 = memoized_fib(n-1)
            f2 = memoized_fib(n-2)
            memo[n] = f1 + f2
            return f1 + f2

    return memoized_fib(n)

def fibmtree(n):
    """
    Purpose:
        Create a Fibonacci tree for n showing memoization.
    Preconditions:
        :param n: a non-negative integer
    Return:
        :return: the nth Fibonacci number, starting with fib(0) = 0
    """
    memo = {}
    def memoized(n):
        if n == 0 or n == 1:
            # put brackets around the leaf nodes so they stand out
            return tn.create('('+str(n)+')')
        elif n in memo:
            # put brackets around memo lookups so they stand out
            return tn.create('['+str(n)+']')
        else:
            tl = memoized(n-1)
            tr = memoized(n-2)
            memo[n] = True
            return tn.create(n, tl, tr)
    return memoized(n)

def moosonacci(n):
    """
    Purpose:
        Calculate the nth Moosonacci number
        The Moosonacci numbers are: 0, 1, 2, 3, 6, 11, 20, 37, ...
    Preconditions:
        :param n: a non-negative integer
    Return:
        :return: the nth Moosonacci number, starting with moos(0) = 0
    """
    if n == 0:
        return 0
    elif n == 1:
        return 1
    elif n == 2:
        return 2
    else:
        return moosonacci(n-1) + moosonacci(n-2) + moosonacci(n-3)

def display_tree(atnode):
    """
    Purpose:
        Display a tree.
    Preconditions:
        :param atnode: A treenode
    Postconditions:
        The tree is displayed on the output.
        Root on the left.
        Right subtree is above the root
        Left subtree is below the root
        Subtrees are indented
        No branches drawn.
    Return:
        :return: None
    """
    def disp(tnode, indent):
        if tnode is not None:
            disp(tn.get_right(tnode), indent+2)
            print(' '*(indent-1), tn.get_data(tnode))
            disp(tn.get_left(tnode), indent+2)
    disp(atnode, 0)

def count_nodes(node):
    """
    Purpose:
        Count the total number of nodes in the tree.
    Preconditions:
        :param node: A treenode
    Return:
        :return: Total number of nodes in the tree.
    """
    if node is None:
        return 0
    return 1 + count_nodes(tn.get_left(node)) + count_nodes(tn.get_right(node))

def tree_height(node):
    """
    Purpose:
        Calculate the height of the tree.
    Preconditions:
        :param node: A treenode
    Return:
        :return: Height of the tree.
    """
    if node is None

print()