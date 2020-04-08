package ru.radiationx.anilibria.screen.launcher

import ru.radiationx.anilibria.screen.*
import ru.radiationx.data.SchedulersProvider
import ru.radiationx.data.datasource.remote.address.ApiConfig
import ru.radiationx.data.entity.common.AuthState
import ru.radiationx.data.repository.AuthRepository
import ru.terrakok.cicerone.Router
import toothpick.InjectConstructor

@InjectConstructor
class AppLauncherViewModel(
    private val apiConfig: ApiConfig,
    private val schedulersProvider: SchedulersProvider,
    private val router: Router,
    private val authRepository: AuthRepository
) : LifecycleViewModel() {

    private var firstLaunch = true

    override fun onCreate() {
        super.onCreate()


    }

    fun coldLaunch() {
        apiConfig
            .observeNeedConfig()
            .distinctUntilChanged()
            .observeOn(schedulersProvider.ui())
            .lifeSubscribe {
                if (it) {
                    router.newRootScreen(ConfigScreen())
                } else {
                    if (firstLaunch) {
                        initMain()
                    }
                }
            }

        if (apiConfig.needConfig) {
            router.newRootScreen(ConfigScreen())
        } else {
            initMain()
        }
        //initMain()
    }

    private fun initMain() {
        firstLaunch = false
        router.newRootScreen(MainPagesScreen())
        if (authRepository.getAuthState() == AuthState.NO_AUTH) {
            router.navigateTo(AuthGuidedScreen())
        }

        authRepository
            .loadUser()
            .lifeSubscribe({}, {})
    }

}