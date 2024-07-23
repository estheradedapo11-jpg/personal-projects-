# CMPT 145: Abstract Data Types
# Application of ADTs:  The Coupon Collector Problem
#
# Suppose there are n coupons to collect, and coupons are
# obtained randomly (with equal probability), with repeats
# allowed (replacement).
#
# How many coupons need to be obtained before all coupons
# have been seen at least once?
#
# (Not answered: how many on average?)

# The Lab03 content for this question is at the bottom of the file.
# For Lab03 you will also be supplied with the Registry ADT and wil need to modify it.

import random as random
import Registry as R

n = 10  # number of unique coupons to collect

coupon_count = 0                # total coupons collected
unique_count = 0                # unique coupons collected
coupons = R.Registry(n, False)  # which coupons have been seen

# keep collecting coupons until we collect see every coupon
while unique_count < n:

    # obtain a random new coupon
    value = random.randrange(0, n)
    coupon_count += 1

    # check if it's been seen before
    if not coupons.is_registered(value):
        unique_count += 1
        coupons.set(value)

print("Total Coupons Collected:", coupon_count)


# Continuing the problem for Lab04 Activities
# See the Activities section of the Lab04 slides for details
# You do not need to modify the below code, 
#  however you may do so to test your method implementation

m = 20  # The new number of coupons we wish to collect
new_coupon_count = 0
coupons.extend_to(m, False)  # You will need to implement this method
while unique_count < m:

    # obtain a random new coupon
    value = random.randrange(0, m)
    new_coupon_count += 1

    # check if it's been seen before
    if not coupons.is_registered(value):
        unique_count += 1
        coupons.set(value)

coupons.show()  # Use the show() method for Debugging.
print("Total Coupons Collected after expansion:", coupon_count + new_coupon_count)
