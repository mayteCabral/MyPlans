package com.example.myideas.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "plans_tbl")
data class Plan(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "plan_title")
    val title: String,
    @ColumnInfo(name = "plan_description")
    val description: String,
    @ColumnInfo(name = "plan_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)