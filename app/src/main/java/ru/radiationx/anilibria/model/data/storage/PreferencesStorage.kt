package ru.radiationx.anilibria.model.data.storage

import android.content.SharedPreferences
import ru.radiationx.anilibria.model.data.holders.PreferencesHolder

/**
 * Created by radiationx on 03.02.18.
 */
class PreferencesStorage(
        private val sharedPreferences: SharedPreferences
) : PreferencesHolder {

    companion object {
        private const val RELEASE_REMIND_KEY = "release_remind"
        private const val EPISODES_IS_REVERSE_KEY = "episodes_is_reverse"
    }

    override fun getReleaseRemind(): Boolean {
        return sharedPreferences.getBoolean(RELEASE_REMIND_KEY, true)
    }

    override fun setReleaseRemind(state: Boolean) {
        sharedPreferences.edit().putBoolean(RELEASE_REMIND_KEY, state).apply()
    }

    override fun getEpisodesIsReverse(): Boolean {
        return sharedPreferences.getBoolean(EPISODES_IS_REVERSE_KEY, false)
    }
}