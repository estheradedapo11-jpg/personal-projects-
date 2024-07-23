# CMPT 145: Assignment nodechain tostring testing
# test script

import a4q3 as nc_tostring
import node as N

#### UNIT TEST CASES
test_item = 'to_string()'
data_in = None
expected = 'EMPTY'
reason = 'Empty node chain'

result = nc_tostring.to_string(data_in)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


data_in = N.node(1)
expected = '[ 1 | / ]'
reason = 'node chain with one node'

result = nc_tostring.to_string(data_in)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


data_in = N.node(1, N.node('two'))
expected = '[ 1 | *-]-->[ two | / ]'
reason = 'node chain with two nodes'

result = nc_tostring.to_string(data_in)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))


data_in = N.node(1, N.node('two', N.node(3)))
expected = '[ 1 | *-]-->[ two | *-]-->[ 3 | / ]'
reason = 'node chain with three nodes'

result = nc_tostring.to_string(data_in)
if result != expected:
    print('Test failed: {}: got "{}" expected "{}" -- {}'.format(test_item, result, expected, reason))

print('*** testing complete ***')
