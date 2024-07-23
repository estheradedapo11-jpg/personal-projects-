# CMPT 145: Assignment nodechain check_chains, copync, double_up testing
# test script

import a4q3 as nc_ts
import a4q4 as nc_ccd
import node as N


####################################################################################################
#### UNIT TEST CASE: check_chains() ####
test_item = "check_chains()"

data_in1 = None
data_in2 = None
expected = 'same chain'
reason = 'Two empty node chains'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1)
data_in2 = None
expected = 'different'
reason = 'One empty node chain'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

#### UNIT TEST CASE: check_chains() ####
data_in1 = None
data_in2 = N.node(1)
expected = 'different'
reason = 'One empty node chain'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1)
data_in2 = N.node(1)
expected = 'same values'
reason = 'Simple node chains, same values'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1)
data_in2 = data_in1
expected = 'same chain'
reason = 'Simple node chain, two copies of the same reference'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1, N.node(2, N.node(3)))
data_in2 = data_in1
expected = 'same chain'
reason = 'longer node chain, two copies of the same reference'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1, N.node(2, N.node(3)))
data_in2 = N.node(1, N.node(2, N.node(3)))
expected = 'same values'
reason = 'longer node chain, two copies of the same chain'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1, N.node(2, N.node(3)))
data_in2 = N.node(1, N.node(2, N.node(1)))
expected = 'different'
reason = 'longer node chain, similar, last value different'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1, N.node(2, N.node(3)))
data_in2 = N.node(1, N.node(2, N.node(3, N.node(4))))
expected = 'different'
reason = 'longer node chain, similar, second chain longer'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1, N.node(2, N.node(3, N.node(4))))
data_in2 = N.node(1, N.node(2, N.node(3)))
expected = 'different'
reason = 'longer node chain, similar, first chain longer'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


#### UNIT TEST CASE: check_chains() ####
data_in1 = N.node(1, N.node(2, N.node(3, N.node(4))))
data_in2 = N.node(2, N.node(3, N.node(4)))
expected = 'different'
reason = 'longer node chain, very different'

result = nc_ccd.check_chains(data_in1, data_in2)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))











####################################################################################################
#### UNIT TEST CASE: copync() ####
test_item = "copync()"

data_in = None
expected = 'same chain'
reason = 'Empty node chain'

result = nc_ccd.check_chains(data_in, nc_ccd.copync(data_in))
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


data_in = N.node(1)
expected = 'same values'
reason = 'Singleton node chain'

result = nc_ccd.check_chains(data_in, nc_ccd.copync(data_in))
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

data_in = N.node(1, N.node(2, N.node(3)))
expected = 'same values'
reason = 'Longer node chain'

temp = nc_ccd.copync(data_in)
result = nc_ccd.check_chains(data_in, temp)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


####################################################################################################
#### UNIT TEST CASE: copync() ####
test_item = "double_up()"

data_in = None
expected = None
reason = 'Empty node chain'

nc_ccd.double_up(data_in)
result_str = nc_ts.to_string(data_in)
expected_str = nc_ts.to_string(expected)
if expected_str != expected_str:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result_str, expected_str, reason))


data_in = N.node('a')
expected = N.node('a', N.node('a'))
reason = 'singleton node chain'

nc_ccd.double_up(data_in)
result_str = nc_ts.to_string(data_in)
expected_str = nc_ts.to_string(expected)
if result_str != expected_str:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result_str, expected_str, reason))


data_in = N.node('a', N.node('b', N.node('see')))
expected = N.node('a', N.node('a', N.node('b', N.node('b', N.node('see', N.node('see'))))))
reason = 'longer node chain'

nc_ccd.double_up(data_in)
result_str = nc_ts.to_string(data_in)
expected_str = nc_ts.to_string(expected)
if result_str != expected_str:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result_str, expected_str, reason))




####################################################################################################
print('*** testing complete ***')



