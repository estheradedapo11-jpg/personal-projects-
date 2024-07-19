"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""


import Statistics as S

def close_enough(a, b, tolerance):
    return abs(a - b) < tolerance

#####################################################################
# test Statistics.create()

test_item = 'Statistics.create()'
expected = 0
reason = "Initial count value"
stats = S.Statistics()
result = stats.count()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

expected = 0
reason = "Initial average value"
result = stats.mean()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

#####################################################################
# test Statistics.add() and count()

test_item = 'add() + count()'
data_in = [0, 0, 0, 0, 0]
expected = 5
reason = "Check count after 5 values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.count()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

#####################################################################
# test Statistics.mean()

test_item = 'add() + mean()'
data_in = [0, 0, 0, 0, 0]
expected = 0.0
reason = "Check average after 5 values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()
if not close_enough(expected, result, 0.0001):
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

#####################################################################
# Additional test cases for better coverage

# Test add() with negative values and mean()
test_item = 'add() + mean() with negative values'
data_in = [-1, -2, -3, -4, -5]
expected = -3.0
reason = "Check average after 5 negative values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()
if not close_enough(expected, result, 0.0001):
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test add() with a mix of positive and negative values and mean()
test_item = 'add() + mean() with mixed values'
data_in = [1, -1, 2, -2, 3, -3]
expected = 0.0
reason = "Check average after mixed values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()
if not close_enough(expected, result, 0.0001):
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test add() with large values and mean()
test_item = 'add() + mean() with large values'
data_in = [1e6, 1e6, 1e6]
expected = 1e6
reason = "Check average after large values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()
if not close_enough(expected, result, 0.0001):
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test count() after multiple add() calls
test_item = 'add() + count() multiple calls'
data_in = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
expected = 10
reason = "Check count after 10 values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.count()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test mean() with incremental additions
test_item = 'add() + mean() incremental additions'
values = [10, 20, 30, 40, 50]
expected_means = [10, 15, 20, 25, 30]
reason = "Check mean after each value is added"
stats = S.Statistics()
for i, v in enumerate(values):
    stats.add(v)
    result = stats.mean()
    if not close_enough(expected_means[i], result, 0.0001):
        print(f'Error in {test_item}: expected {expected_means[i]} but got {result} -- {reason}')

#####################################################################
# Test new methods

# Test range()
test_item = 'range()'
data_in = [1, 2, 3, 4, 5]
expected = 4
reason = "Check range after values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.range()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test mode()
test_item = 'mode()'
data_in = [1, 2, 2, 3, 4, 4, 4, 5]
expected = 4
reason = "Check mode after values added"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mode()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test max()
test_item = 'max()'
data_in = [1, 2, 3, 4, 5]
expected = 5
reason = "Check max value"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.max()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

# Test min()
test_item = 'min()'
data_in = [1, 2, 3, 4, 5]
expected = 1
reason = "Check min value"
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.min()
if result != expected:
    print(f'Error in {test_item}: expected {expected} but got {result} -- {reason}')

print('*** Test script completed ***')
