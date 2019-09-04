package com.pavelwinter.myorganizer.presentation.mvp.utils.main.models

import com.pavelwinter.myorganizer.presentation.mvp.utils.main.utils.PriorityInterface

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