package com.pavelwinter.myorganizer.data.db.db_entities

/** A type is a parent for most of table's types */

data class ParentType(var id:Long,
                      var title : String,
                      var priority : Int,
                      var percentDone : Int,
                      var describing : String,
                      var endTime : Long,
                      var startTime : Long)