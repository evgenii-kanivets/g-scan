package com.tech_crunch.hackaton.vabama.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
@Dao
interface CarDao {

    @Query("SELECT * FROM car")
    fun getAll(): LiveData<List<Car>>

    @Query("SELECT * FROM car WHERE id = :id")
    fun getById(id: Long): Car

    @Insert
    fun insert(user: Car)

    @Update
    fun update(user: Car)

    @Delete
    fun delete(user: Car)

}

@Entity
data class Car(@PrimaryKey(autoGenerate = true) val id: Long, val plateNumber: String,
               val title: String, val status: String)

val OK_STATUS = "OK"
val NEED_CLEANING_STATUS = "NEED_CLEANING"
val NEED_REPAIR_STATUS = "NEED_REPAIR"