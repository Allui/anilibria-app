package ru.radiationx.anilibria.model.system

import android.content.Context

import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream
import com.nostra13.universalimageloader.core.download.BaseImageDownloader

import java.io.IOException
import java.io.InputStream

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import java.lang.Exception
import javax.inject.Inject

class OkHttpImageDownloader @Inject constructor(
        private val context: Context,
        private val clientWrapper: ApiClientWrapper
) : BaseImageDownloader(context) {

    override fun getStreamFromNetwork(imageUri: String, extra: Any?): InputStream {
        val request = Request.Builder().url(imageUri).build()
        val response = clientWrapper.get().newCall(request).execute()
        val responseBody = response.body()
        val inputStream = responseBody!!.byteStream()
        val contentLength = responseBody.contentLength().toInt()
        return ContentLengthInputStream(inputStream, contentLength)
    }
}