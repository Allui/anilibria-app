package ru.radiationx.data.system

import android.text.Html
import ru.radiationx.data.datasource.remote.IApiUtils
import javax.inject.Inject

@Suppress("DEPRECATION")
class ApiUtils  @Inject constructor(): IApiUtils {
    override fun toHtml(text: String?): CharSequence? {
        if (text == null)
            return null
        return Html.fromHtml(text)
    }

    override fun escapeHtml(text: String?): String? {
        if (text == null)
            return null
        return Html.fromHtml(text).toString()
    }
}
