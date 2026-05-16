package com.antoniocostadossantos.todokmp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoModel(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo("title")
    val title: String
)