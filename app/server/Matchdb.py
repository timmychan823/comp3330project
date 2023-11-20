#this program is to create a Record database for COMP3330
import sqlite3

con = sqlite3.connect("Record.db")

cur = con.cursor()
#The format of the data will be {'User_Name':'username','Restaurant':'restaurant name','TimeSlot':'time'},
cur.execute("""CREATE TABLE IF NOT EXISTS Record (
            User_Name TEXT NOT NULL,
            Restaurant TEXT NOT NULL,
            TimeSlot TEXT NOT NULL
            )""")

record = [{'User_Name':'Jacky','Restaurant':'CYM Canteen','TimeSlot':'11:30'},
          {'User_Name':'Billy','Restaurant':'FSCAC Restaurant','TimeSlot':'13:30'},
          {'User_Name':'Tom','Restaurant':'27 Kebab House','TimeSlot':'12:30'},
          {'User_Name':'James','Restaurant':'CYM Canteen','TimeSlot':'11:30'},
          {'User_Name':'Kalvin','Restaurant':'Subway','TimeSlot':'11:30'},
          {'User_Name':'Timmy','Restaurant':'CYM Canteen','TimeSlot':'14:30'}
          ]

for i in record:
    cur.execute("INSERT INTO Record VALUES (:User_Name,:Restaurant,:TimeSlot)",i)

con.commit()
con.close()

