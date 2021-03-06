package ru.radiationx.anilibria

import com.nostra13.universalimageloader.core.ImageLoader
import ru.radiationx.shared_app.di.DI
import ru.radiationx.data.datasource.holders.PreferencesHolder
import javax.inject.Inject

/**
 * Created by radiationx on 26.02.18.
 */
class AppMigration(
        private val current: Int,
        private val last: Int,
        private val history: List<Int>
) {

    @Inject
    lateinit var appPreferences: PreferencesHolder

    init {
        DI.inject(this)
    }

    fun start() {
        if (current == 20) {
            appPreferences.setReleaseRemind(true)
        }
        if (last <= 52) {
            ImageLoader.getInstance().clearDiskCache()
        }
    }
}