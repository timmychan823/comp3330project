import flask
import sqlite3
from flask import request


app = flask.Flask(__name__)
#app.config["DEBUG"] = True # Enable debug mode to enable hot-reloader.
@app.route('/matchrecord')
def marchrecord():
    element = request.args.to_dict()
    print(element)
    con = sqlite3.connect('Record.db')
    if element != {}:
        # Delete data from database, use after made a match
        if 'Delete' in element:
            con.execute("DELETE FROM Record WHERE User_Name = '"+str(element['Delete'])+"'")
            con.commit()
        # Insert data into database, use in creating match
        else:
            con.execute("INSERT INTO Record VALUES (:User_Name,:Restaurant,:TimeSlot)",element)
            con.commit()


    cur = con.execute("SELECT * FROM Record;")

    matchs = []
    for i in cur:
        matchs.append(i)
    con.close()


    outdata = {
        "Match":matchs
    }
    return outdata
# adds host="0.0.0.0" to make the server publicly available
app.run(host="0.0.0.0",port=8888)