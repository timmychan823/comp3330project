import sqlite3

con = sqlite3.connect("Record.db")
cur = con.cursor()
cur.execute("SELECT * FROM Record")

results = cur.fetchall()

for i in results:
    print(i)

con.close()
