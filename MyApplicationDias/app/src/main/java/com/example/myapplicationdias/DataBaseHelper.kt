import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.View
import android.widget.Toast
import com.example.myapplicationdias.Card
import com.example.myapplicationdias.User

val DATABASENAME = "MY_DATABASES1"
val TABLENAME = "Users"
val COL_USERNAME = "username"
val COL_PHONE = "phone"
val COL_PASSWORD = "passwords"
val COL_CODE = "code"
val COL_ID = "id"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
       val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USERNAME +
                " text, "+ COL_PHONE + " text, " + COL_PASSWORD + " text, " + COL_CODE + " text)"
        db?.execSQL(createTable)
        db?.execSQL("create table Cards (id integer primary key, username text, cardnumber text, owmer text, expired text, code text)")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(user: User) {

        val database = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_USERNAME, user.username)
        contentValues.put(COL_PHONE, user.phone)
        contentValues.put(COL_PASSWORD, user.password)
        contentValues.put(COL_CODE, user.code)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    fun updatePass(pass: String, usern: String) {

        val database = this.writableDatabase
        val contentValues = ContentValues()


        contentValues.put(COL_PASSWORD, pass)
      database.update(TABLENAME,  contentValues, "username =? " , arrayOf(usern))

    }
    fun updatePhone(phon: String, usern: String) {

        val database = this.writableDatabase
        val contentValues = ContentValues()


        contentValues.put(COL_PHONE, phon)
        database.update(TABLENAME,  contentValues, "username =? " , arrayOf(usern))

    }

    @SuppressLint("Recycle")
    fun readPass(usern: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_USERNAME + " = \'" + usern+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_PASSWORD))
        }
        result.close()
        return st
    }
    fun readPhone(usern: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_USERNAME + " = \'" + usern+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_PHONE))
        }
        result.close()
        return st
    }
    @SuppressLint("Recycle")
    fun readCode(code: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_CODE + " = \'" + code+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_PASSWORD))
        }
        result.close()
        return st
    }
    @SuppressLint("Recycle")
    fun readName(code: String): String {
        val db = this.readableDatabase
        var st = ""
        val query = "Select * from " + TABLENAME + " where " + COL_CODE + " = \'" + code+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            st=result.getString(result.getColumnIndex(COL_USERNAME))
        }
        result.close()
        return st
    }
    fun readCardNum(usern: String): String {
        val db = this.readableDatabase
        var cardn=""
        val query = "Select * from Cards where " + COL_USERNAME + " = \'" + usern+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            cardn=result.getString(result.getColumnIndex("cardnumber"))
        } else{
            cardn="NULL"
        }
        result.close()
        return cardn
    }
    fun readCardOwn(usern: String): String {
        val db = this.readableDatabase
        var cardo=""
        val query = "Select * from Cards where username= \'" + usern+"\'"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            cardo=result.getString(result.getColumnIndex("owner"))
        }
        result.close()
        return cardo
    }

}


