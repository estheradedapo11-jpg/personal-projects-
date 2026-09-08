import pandas as pd
import numpy as np
import matplotlib.pyplot as plt 

basics = pd.read_csv('title.basics.tsv', sep='\t', on_bad_lines='skip', na_values='\\N')
ratings = pd.read_csv('title.ratings.tsv', sep='\t',on_bad_lines='skip', na_values='\\N')

"merges both datafiles"
df = basics.merge(ratings, on='tconst')

"drops rows with missing values in the specified columns"
df = df.dropna(subset=['primaryTitle', 'originalTitle', 'genres'])


for col in ['startYear', 'endYear', 'runtimeMinutes']:
    "Converts valid numbers and turns text/errors into NaN"
    df[col] = pd.to_numeric(df[col], errors='coerce')

    "Converts data types to integers"
    df[col] = df[col].astype('Int64')


" filters out movies with runtime greater than 240 minutes" 
df = df[~((df['titleType'] == 'movie') & (df['runtimeMinutes'] > 240))]

"marks TV series with runtime greater than 500 minutes as unreliable "
df['runtime_reliable'] = True
df.loc[(df['titleType'] == 'tvSeries') & (df['runtimeMinutes'] > 500), 'runtime_reliable'] = False

"filters out movies with startYear before 1880 and endYear after 2026"
df = df[ ((df['startYear'] >= 1880) & (df['endYear'] <= 2026)) | (df['endYear'].isna()) ]

"splits the 'genres' column into a list of genres"
df['genres'] = df['genres'].str.split(',')

"explodes the DataFrame so that each genre has its own row"
df = df.explode('genres')



"print(df['genres'].value_counts())"
"print(df['titleType'].value_counts())"


'print(df.shape)'
'print(df.head())'

'print(df.info())'

''''
print(df['runtimeMinutes'].describe())
print(df['averageRating'].describe())
print(df['numVotes'].describe())
'''


'print(df.isnull().sum())'

'print(df.duplicated().sum())'
'''
pd.set_option('display.max_columns', None)
print(df[df['runtimeMinutes'] > 1000].groupby('titleType')['runtimeMinutes'].describe())
print(df['runtimeMinutes'].dtype)
'''

'''
print(df['startYear'].describe())
print(df['endYear'].describe())
'''
'print(df.columns.tolist())'


"print(df.groupby('titleType')['averageRating'].mean().sort_values(ascending=False))"
"print(df.groupby('genres')['averageRating'].mean().sort_values(ascending=False))"

genre_avg = df.groupby('genres')['averageRating'].mean().sort_values(ascending=False)

plt.figure(figsize=(10,6))
genre_avg.plot(kind='bar')
plt.title('Average IMDb Rating by Genre')
plt.ylabel('Average Rating')
plt.xlabel('Genre')
plt.tight_layout()
plt.savefig('genre_avg_rating.png')
plt.show()

title_type_avg = df.groupby('titleType')['averageRating'].mean().sort_values(ascending=False)

plt.figure(figsize=(10,6))
title_type_avg.plot(kind='bar')
plt.title('Average IMDb Rating by Title Type')
plt.ylabel('Average Rating')
plt.xlabel('Title Type')
plt.tight_layout()
plt.savefig('title_type_avg_rating.png')
plt.show()

df['decade'] = (df['startYear'] // 10) * 10
decade_avg = df.groupby('decade')['averageRating'].mean()

plt.figure(figsize=(10,6))
decade_avg.plot(kind='line', marker='o')
plt.title('Average IMDb Rating by Decade')
plt.ylabel('Average Rating')
plt.xlabel('Decade')
plt.tight_layout()
plt.savefig('decade_avg_rating.png')
plt.show()