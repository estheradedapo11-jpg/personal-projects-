"""Esther Adedapo
NSID: fxy319
Student Number: 11366614
Instructor: Alexander Dumais
Lecture Section: L02"""

# a3q2_testing.py
# CMPT 145 Course material
# Copyright (c) 2017-2024 Michael C Horsch
# All rights reserved.
#
# This document contains resources for homework assigned to students of
# CMPT 145 and shall not be distributed without permission.  Posting this
# file to a public or private website, or providing this file to a person
# not registered in CMPT 145, constitutes Academic Misconduct, according
# to the University of Saskatchewan Policy on Academic Misconduct.
#
# Synopsis:
#   Assignment 3: ADTs and Testing

# This script is a starter file for testing the Statistics ADT

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
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

#####################################################################
# test Statistics.mean()

test_item = 'add() + mean()'
data_in = 0
expected = 0
reason = "Check average after one value added"

# call the operation
stats = S.Statistics()
stats.add(data_in)
result = stats.mean()

# We shouldn't test the floating point values for equality, because of roundoff error
# So use the close_enough() function.

if not close_enough(expected, result, 0.0001):
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)


test_item = 'add() + mean()'
data_in = [0, 0, 0, 0, 0]
expected = 0.0
reason = "Check average after 5 values added"

# call the operation
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()

if not close_enough(expected, result, 0.0001):
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

#####################################################################
# Additional test cases for better coverage
#####################################################################

# Test add() with negative values and mean()
test_item = 'add() + mean() with negative values'
data_in = [-1, -2, -3, -4, -5]
expected = -3.0
reason = "Check average after 5 negative values added"

# call the operation
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()

if not close_enough(expected, result, 0.0001):
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

# Test add() with a mix of positive and negative values and mean()
test_item = 'add() + mean() with mixed values'
data_in = [1, -1, 2, -2, 3, -3]
expected = 0.0
reason = "Check average after mixed values added"

# call the operation
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()

if not close_enough(expected, result, 0.0001):
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

# Test add() with large values and mean()
test_item = 'add() + mean() with large values'
data_in = [1e6, 1e6, 1e6]
expected = 1e6
reason = "Check average after large values added"

# call the operation
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.mean()

if not close_enough(expected, result, 0.0001):
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

# Test count() after multiple add() calls
test_item = 'add() + count() multiple calls'
data_in = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
expected = 10
reason = "Check count after 10 values added"

# call the operation
stats = S.Statistics()
for v in data_in:
    stats.add(v)
result = stats.count()

if result != expected:
    print('Error in ' + test_item + ': expected ' + str(expected) + ' but got ' + str(result) + ' -- ' + reason)

# Test mean() with incremental additions
test_item = 'add() + mean() incremental additions'
values = [10, 20, 30, 40, 50]
expected_means = [10, 15, 20, 25, 30]
reason = "Check mean after each value is added"

# call the operation
stats = S.Statistics()
for i, v in enumerate(values):
    stats.add(v)
    result = stats.mean()
    if not close_enough(expected_means[i], result, 0.0001):
        print('Error in ' + test_item + ': expected ' + str(expected_means[i]) + ' but got ' + str(result) + ' -- ' + reason)

print('*** Test script completed ***')
