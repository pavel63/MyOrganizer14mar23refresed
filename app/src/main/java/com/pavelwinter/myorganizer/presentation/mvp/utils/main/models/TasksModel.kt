package com.pavelwinter.myorganizer.presentation.mvp.utils.main.models

import com.pavelwinter.myorganizer.presentation.mvp.utils.main.utils.PriorityInterface

data class TasksModel(
    var priority: PriorityInterface,
    var restPercent: Int
) : BaseModel()