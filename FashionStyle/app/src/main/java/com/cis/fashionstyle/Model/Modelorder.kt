package com.cis.fashionstyle.Model

class Modelorder {
    companion object Factory{ // สร้างเมดทอนแบบย่อ ๆ
        fun create():Modelorder = Modelorder()
    }
    var id:String?=null
    var nameorder:String?=null
    var nameaddress:String?=null
    var namecount:String?=null
}