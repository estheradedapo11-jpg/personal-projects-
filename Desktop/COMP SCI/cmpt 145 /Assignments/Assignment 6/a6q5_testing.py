"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lab Section: L02"""
from a6q5 import TreeNode, ordered

def run_tests():
    # Test case 1: Empty tree
    assert ordered(None) == True, "Test case 1 failed"

    # Test case 2: Single node tree
    t1 = TreeNode(10)
    assert ordered(t1) == True, "Test case 2 failed"

    # Test case 3: Ordered tree
    t2 = TreeNode(10, TreeNode(5), TreeNode(15))
    assert ordered(t2) == True, "Test case 3 failed"

    # Test case 4: Unordered tree
    t3 = TreeNode(10, TreeNode(15), TreeNode(5))
    assert ordered(t3) == False, "Test case 4 failed"

    # Test case 5: Larger ordered tree
    t4 = TreeNode(10, TreeNode(5, TreeNode(2), TreeNode(7)), TreeNode(15, TreeNode(12), TreeNode(20)))
    assert ordered(t4) == True, "Test case 5 failed"

    print("All test cases passed!")

if __name__ == "__main__":
    run_tests()
