import Registry as R

# You can run this after completing Activity 4
# This test shows that extend_to adds one more register
test_extend_to = R.Registry(5, False)
test_extend_to.extend_to(6, True)
test_extend_to.show()

# This test shows that extend_by adds six more registers
test_extend_by = R.Registry(5, False)
test_extend_by.extend_by(6, True)
test_extend_by.show()
