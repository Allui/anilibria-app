package ru.radiationx.data.di.providers

import ru.radiationx.data.datasource.remote.address.ApiConfig
import ru.radiationx.data.system.AppCookieJar
import ru.radiationx.data.system.Client
import javax.inject.Inject

class MainNetworkClient @Inject constructor(
        private val clientWrapper: MainClientWrapper,
        private val appCookieJar: AppCookieJar,
        private val apiConfig: ApiConfig
) : Client(clientWrapper, appCookieJar, apiConfig)