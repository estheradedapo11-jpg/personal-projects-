

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt 

df = pd.read_csv('dataset.csv', sep=',')

"drop null values in the specified columns"
df = df.dropna(subset=['artists', 'album_name', 'track_name'])

" drop rows with no tempo value"
df = df[df['tempo'] != 0]
df = df.drop_duplicates(subset=['track_id'])

import sqlite3

conn = sqlite3.connect('spotify.db')
df.to_sql('tracks', conn, if_exists='replace', index=False)
conn.close()




conn = sqlite3.connect('spotify.db')
result = pd.read_sql_query("SELECT track_genre, AVG(popularity) AS avg_popularity FROM tracks GROUP BY track_genre ORDER BY avg_popularity DESC", conn)
conn.close()

plt.figure(figsize=(16,8))  # wider figure
result.plot(kind='bar', x='track_genre', y='avg_popularity', legend=False, ax=plt.gca())
plt.title('Average Popularity by Genre')
plt.ylabel('Average Popularity')
plt.xlabel('Genre')
plt.xticks(rotation=90, fontsize=6)  # rotate and shrink labels so they fit
plt.tight_layout()
plt.savefig('average_popularity_by_genre.png')
plt.show()

"print(df.info())"

"print(df.index)"
"print(df.duplicated().sum())"

'''print(df[df['tempo'] == 0].shape)
print(df[df['tempo'] == 0][['track_name', 'track_genre', 'tempo']].head(10))'''


"print(df['track_genre'].value_counts().sort_values())"
"print(df['duration_ms'].describe())"
"print(df['popularity'].describe())"
"print(df['explicit'].describe()) "
"print(df['danceability'].describe())"  'max is 0.985000'
"print(df['energy'].describe())"
"print(df['key'].describe())"
"print(df['loudness'].describe())" " min is -49 or so max is 4"
"print(df['mode'].describe())"
"print(df['speechiness'].describe())" ' max is 0.965000'
"print(df['acousticness'].describe())"  ' max is 0.996000'
"print(df['instrumentalness'].describe())"
"print(df['liveness'].describe())"
"print(df['valence'].describe())" ' valence max is 0.996000'
"print(df['tempo'].describe())" 'maybe chnage tempo max to 250 on dot'
"print(df['time_signature'].describe())"

"print(df['track_genre'].value_counts())"
"print(df['track_genre'].describe())"

",track_id,artists,album_name,track_name,popularity,duration_ms,explicit,danceability,energy,key,loudness,mode,"
"speechiness,acousticness,instrumentalness,liveness,valence,tempo,time_signature,track_genre  "