package ru.radiationx.anilibria.presentation.checker

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.radiationx.anilibria.BuildConfig
import ru.radiationx.anilibria.presentation.common.IErrorHandler
import ru.radiationx.data.repository.CheckerRepository
import javax.inject.Inject

/**
 * Created by radiationx on 28.01.18.
 */
@InjectViewState
class CheckerPresenter @Inject constructor(
        private val checkerRepository: CheckerRepository,
        private val errorHandler: IErrorHandler
) : MvpPresenter<CheckerView>() {

    var forceLoad = false

    private var compositeDisposable = CompositeDisposable()

    fun checkUpdate() {
        checkerRepository
                .checkUpdate(BuildConfig.VERSION_CODE, forceLoad)
                .doOnSubscribe { viewState.setRefreshing(true) }
                .subscribe({
                    viewState.setRefreshing(false)
                    viewState.showUpdateData(it)
                }, {
                    viewState.setRefreshing(false)
                    errorHandler.handle(it)
                })
                .addToDisposable()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    fun Disposable.addToDisposable() {
        compositeDisposable.add(this)
    }
}