package com.example.dbdemo

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView

import com.example.dbdemo.data.MyDbHandler
import com.example.dbdemo.model.Contact

import java.lang.reflect.Array
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var contactArrayList: ArrayList<Contact>? = null
    private val arrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

/*
* In main.kt we handle our all data.
* means all the operationes of CRUD will be taken here.
* firstly i create the object of MyDbHandler class where my all function
* of db declared.*/

        val db = MyDbHandler(this)

/*INSERT CONTACT
* for insert first of all i make object of contact class where
* i have declared some constructores.
* and just use variables of this class and after that
* i call my fun addcontact jo k mny db handler me declare kia tha.
* us ko use krty hoy hum data enter krty jain gy.
* */

        val m = Contact()
        m.phoneNumber = "03044436009"
        m.name = "Harry"
        /*
        * addContact()
        * db handler.kt me bana hain function*/
        db.addContact(m)

        /*UPDATE DATA
        * hum yahan pr data ko update krain gy by using id of data
        * agr id use nahi krain gy to wo 0 set krdy ga id row me.
        * to hum id ko use krain gy or jtna data update krna hain kr dain gy.*/
        /*updateCotact()
        * ye hamara fun hai jo k humne dbhandle.kt me banaya hai*/

        m.id = 6
        m.name = "Changed Saif"
        m.phoneNumber = "00000000"
        val affectedrows = db.updateContact(m)
        Log.d("dbshoaib", "Rows are: $affectedrows")

     /* Delete Contacts
* hum data delete kr sakty hn by name bhi or by using id bhi
* name se krny k lye bhi fun bana para hai dbhandler.kt me
* id ky zarye dell kia hai to iska bhi fun bana para hain dbhandler.kt me*/
     /*   deleteContactById()
     * ye function h jo k bana hai dbhandler.kt */

        db.deleteContactById(1)
        db.deleteContactById(2)
        db.deleteContactById(3)


        /*
 Array Contacts for listview
        ArrayList<String> contacts = new ArrayList<>();
        listView = findViewById(R.id.listView);
*/

        /*Data Display
        * hum yahan pr arrayList bana kr usme display krwain gy
        * tamam data ko arrays me
        * to yahan for loop lgain hai
        * hum yahan pr sb se phly contact fetch kry gy or phr apni array me add krty
        * jain gy*/


        contactArrayList = ArrayList()
        val allContacts = db.allContacts
        for (contact in allContacts) {

            Log.d("dbshoaib", "Id: " + contact.id + "\n" +
                    "Name: " + contact.name + "\n" +
                    "PhoneNumber: " + contact.phoneNumber + "\n")

            //AFTER GETTING NUMBERS ADD INTO OUR ARRAY CONTACTS.

            // ListView            contacts.add(contact.getId()+"  "+contact.getName() + " (" + contact.getPhoneNumber() + ")" );
            contactArrayList!!.add(contact)
        }
        recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity, contactArrayList!!)
        recyclerView!!.adapter = recyclerViewAdapter

        /*ListView       ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
  ListView      listView.setAdapter(arrayAdapter);
*/
       /*Count All Data
       *
       * */

        Log.d("dbshoaib","You have  " + db.count + " in your data base");

    }
}
