package com.pavelwinter.myorganizer.presentation.models

data class ProjectModel(
    var createDate : Long,
    var endTime : Long,
    var tasksList : List<TasksModel>
    ) : BaseModel()