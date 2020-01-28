package com.example.dbdemo.params

object Params {
    /*
* HERE WE DECLARE OUR ALL PARAMETERS THAT WE WILL USED IN OUR APP.
* SO THAT WHEN WE HAVE NEED TO CHANGE ANY VARIABLE THEN IT WILL CHANGE
* AUTOMATICALLY IN ALL OF OUR APP.
* BELOW WE HAVE DECLARED SOME PARAMATERS LIKE VERSION OF DB WILL BE 1.
* DATA BASE NAME WILL BE CONTACTS MEANS WE MAKE DB OF CONTACTS.
* TABLE NAME WILL BE CONTACTS TABLE IN WHICH WE SAVE OUR ALL CONTACTS.
*
* JUST WRITE PSFI AND PSFS VAR AUTOMATICALLY WILL BE DONE.
* MAKE VARIABLE WITH CAPITAL LETTERS SO THAT WE CAN UNDERSTAND IT IS OUR PSFS VAR.
* */

    /* in
    * sb ko use krty hoy hum apni database create krain gy jtny bhi method use hon
    * gy wo yahan pry hn
    * */

    val DB_VERSION = 1
    val DB_NAME = "contacts_db"
    val TABLE_NAME = "contacts_table"


    /*
    * KEYS OF OUR TABLE.
    *
    * */

    val KEY_ID = "id"
    val KEY_NAME = "name"
    val KEY_PHONE = "phone_number"

}
