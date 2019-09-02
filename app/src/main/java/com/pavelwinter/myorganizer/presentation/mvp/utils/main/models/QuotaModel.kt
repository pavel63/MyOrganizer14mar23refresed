package com.pavelwinter.myorganizer.presentation.mvp.utils.main.models

import android.view.View

 class QuotaModel(
    var describing :String,
    var percentView : View,
    var percentRest : Int,
    var percentDone : Int) : BaseModel()