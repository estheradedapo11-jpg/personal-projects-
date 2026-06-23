# Day 2 - pandas basics: DataFrames, Series, loc, iloc, selecting

import pandas as pd

# create a dataframe
animals = pd.DataFrame({'Cows': [12, 20], 'Goats': [22, 19]}, index=['Year 1', 'Year 2'])

# save to csv
animals.to_csv("cows_and_goats.csv")

# loc - select by label
# df.loc[[0, 1, 10, 100], ['country', 'province']]

# iloc - select by position
# df.iloc[0]
# df.iloc[0, 1]

# filter rows
# df[df.country == 'Italy']