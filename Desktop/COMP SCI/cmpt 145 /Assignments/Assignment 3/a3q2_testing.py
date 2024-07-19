"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""

import Statistics as S

def close_enough(a, b, tolerance):
    """
    Purpose:
        Check if 2 floating point values are close enough to
        be considered equal.  See the Addendum in the assignment!
    Pre-Conditions:
        :param a: a floating point value
        :param b: a floating point value
        :param tolerance: a small positive floating point value
    Post-Conditions:
        none
    Return:
        :return True if the difference between a and b is small
    """
    return abs(a - b) < tolerance

#####################################################################
# test Statistics.create()
test_item = 'Statistics.create()'
expected = 0
reason = "Initial count value"

# call the operation
stats = S.Statistics()
result = stats.count()

if result != expected:
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)


expected = 0
reason = "Initial average value"

# call the operation
stats = S.Statistics()
result = stats.mean()

if result != expected:
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

#####################################################################
# test Statistics.add()  

test_item = 'add() + count()'
data_in = 0
expected = 1
reason = "Check count after one value added"

# call the operation
stats = S.Statistics()
stats.add(data_in)
result = stats.count()

if result != expected:
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)


test_item = 'add() + count()'
data_in = [0, 0, 0, 0, 0]
expected = 5
reason = "Check count after 5 values added"

# call the operation
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.count()

if result != expected:
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + st