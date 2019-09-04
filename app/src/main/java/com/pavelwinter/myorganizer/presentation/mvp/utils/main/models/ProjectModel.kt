package com.pavelwinter.myorganizer.presentation.mvp.utils.main.models

data class ProjectModel(
    var createDate : Long,
    var endTime : Long,
    var tasksList : List<TasksModel>
    ) : BaseModel()