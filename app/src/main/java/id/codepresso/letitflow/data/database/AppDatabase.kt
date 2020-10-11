package id.codepresso.letitflow.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.codepresso.letitflow.data.database.dao.CatFactDao
import id.codepresso.letitflow.data.database.entity.CatFact

/**
 * Crafted by Razib Kani Maulidan on 11/10/20.
 **/

@Database(entities = [CatFact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun catFactDao(): CatFactDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "quotes.db"
            ).build()
    }
}