package com.pavelwinter.myorganizer.presentation.models

import com.pavelwinter.myorganizer.presentation.utils.PriorityInterface

/**for reusing and have't copypasts*
 * @param id
 *
 * @param title
 *
 */
open class BaseModel{
    var id : Int ?= null
    var title : String ?= null
    var priority : PriorityInterface ?= null
    var lastPercent : Int ?= null
}