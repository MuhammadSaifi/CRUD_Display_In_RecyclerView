package com.example.dbdemo.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

import com.example.dbdemo.model.Contact
import com.example.dbdemo.params.Params

import java.util.ArrayList

class MyDbHandler(context: Context) : SQLiteOpenHelper(context, Params.DB_NAME, null, Params.DB_VERSION) {

    /*
    * HERE WE WILL HANDLE OUR DATABASE BY USING SQLITE HELPER METHODS.
    * HERE WE WILL DECLARE OUR SOME OVERRIDES FUNCTIONES OF ITS.
    * BUT BEFORE WE WILL MAKE THE CONSTRUCTOR OF THIS CLASS.
    * CONTEXT THIS
    * ANDROID NEED FROM WHERE WE INVOKE  IN APP SO THAT WHY WE USE THE CONTEXT.
    * IN CONSTRUCTOR WE CALL THE CONSTRUCTOR OF SUPER CLASS MEANS OUR HELPER CLASS.
    * 2ND PARAMETERS OF SUPER IS OUR DATABASE NAME.
    * 3RD PARAMETERS OF SUPER IS NULL.
    * 4TH PARAMETERS IS OUR DB VERSIONS.
    * */

    /*Here we create our data base by passing somw
    * queries in our onCreate override functiones
    * all the objects like table name and id and phone are declared
    * in our params.kt file check there.
    * */

    override fun onCreate(db: SQLiteDatabase) {
        val create = ("CREATE TABLE " + Params.TABLE_NAME
                + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY,"
                + Params.KEY_NAME
                + " TEXT, " + Params.KEY_PHONE + " TEXT" + ")")


        Log.d("dbshoaib", "Query being run is : $create")
        db.execSQL(create)

    }

    /*onUpgrade fun is empty now we not used any code in it.
* it will used for upgrade
* */

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {

    }

    /*Now in addContact function many add krny ki method write ki hain ta k
    * jb hum main.kt me is fun ko call krain to ye hamara data
    * hamary database me automaticalyy add krta rahy.
    * values ky ander jo kuch bhi add hai ye sb params.kt me declared hn.
    * to pareshan mat hona k kahan se ai ye.
    * ye sara code ab hamesha same hi rahy ga bs db ka name wagera hi change krna
    * parry ga.
    * */

    fun addContact(contact: Contact) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(Params.KEY_NAME, contact.name)
        values.put(Params.KEY_PHONE, contact.phoneNumber)


        db.insert(Params.TABLE_NAME, null, values)
        Log.d("dbshoaib", "Successfully inserted")
        db.close()
    }

    /*Data ko fetch krny k lye ya usko display krwany k lye hum ne ye function create
    * kia hai jo k na to string type ka hai or na hi int type ka
    * blky ye ak list type ka hai.
    * jis ky ander mny select krny ki query likhi hai or cursor use kia hai
    * cursor hamary database me check krny ga k koi aisi value to
    * nahi reh gi jo us ne display ni krwai.
    * cursor.getstring(2)
    * yahan 2 ka mtlb iska coulmn hai.
    * 1 coulmn me hamari id hai
    * 2 coulmn me hamara name hai
    * 3 coulmn me hamara phone save hoga
    * basically table create hoa hai.
    *
    * */

    val allContacts: List<Contact> get() {
            val contactList = ArrayList<Contact>()
            val db = this.readableDatabase
            val select = "SELECT * FROM " + Params.TABLE_NAME

            val cursor = db.rawQuery(select, null)

            if (cursor.moveToFirst()) {
                do {
                    val contact = Contact()
                    contact.id = Integer.parseInt(cursor.getString(0))
                    contact.name = cursor.getString(1)
                    contact.phoneNumber = cursor.getString(2)
                    contactList.add(contact)
                } while (cursor.moveToNext())
            }
            return contactList

        }

    /* Count waly function me hum ne ye likha hai k
    * hamaray db me total ktna contents maoujood hai
    * to hum ne id pr count lagaya ta k cursor jo hai wo total id
    * jtni bhi hn humy display krwa dy  k bhai apky db me itna content paraa hai.
    * */

    val count: Int get() {
            val query = "SELECT * FROM " + Params.TABLE_NAME
            val db = this.writableDatabase
            val cursor = db.rawQuery(query, null)
            return cursor.count
        }

/* update me hum apny data ko update kr skty hain
* uska sara code hai lkn ye sb fun
* main.kt me call hoty hain or wahan se data update hoga .*/

    fun updateContact(contact: Contact): Int {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put(Params.KEY_NAME, contact.name)
        values.put(Params.KEY_PHONE, contact.phoneNumber)

        // UPDATE OUR VALUES

        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                arrayOf(contact.id.toString()))
    }
/*
* delete me hum data ko delete krain gy by id or jo is ky nechy h usko use krty
*
* hoy hum by name bhi delete kr sakty hain.*/

    fun deleteContactById(id: Int) {
        val db = this.writableDatabase
        db.delete(Params.TABLE_NAME, Params.KEY_ID + "=?", arrayOf(id.toString()))
        db.close()
    }

    fun deleteContactByName(contact: Contact) {
        val db = this.writableDatabase
        db.delete(Params.TABLE_NAME, Params.KEY_ID + "=?", arrayOf(contact.name.toString()))
        db.close()
    }
}
