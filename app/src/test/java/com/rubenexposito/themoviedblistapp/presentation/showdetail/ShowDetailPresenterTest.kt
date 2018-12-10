package com.rubenexposito.themoviedblistapp.presentation.showdetail

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.domain.interactor.BaseUseCase
import com.rubenexposito.themoviedblistapp.domain.interactor.GetSimilarTvShowsUseCase
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ShowDetailPresenterTest {

    @Mock
    lateinit var view: ShowDetailContract.View

    @Mock
    lateinit var useCase: GetSimilarTvShowsUseCase

    @Mock
    lateinit var navigator: Navigator

    private val presenter by lazy {
        ShowDetailPresenter(view, useCase, navigator)
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `should display data when bind from intent`() {
        presenter.bindIntent(givenShowNotNull())
        verify(view).displayShow(any())
    }

    @Test
    fun `should clear use case on pause`() {
        presenter.onPause()
        verify(useCase).clear()
    }

    @Test
    fun `should retrieve data when given on completed request`() {
        givenOnCompletedRequest()
        presenter.bindIntent(givenShowNotNull())
        verify(view).hideLoading()

    }

    @Test
    fun `should retrieve error when given on error request`() {
        givenOnErrorRequest()
        presenter.bindIntent(givenShowNotNull())
        verify(view).hideLoading()

    }

    @Test
    fun `should navigate to detail on show select`() {
        presenter.onShowSelected(givenShowNotNull())
        verify(navigator).showDetail(any())
    }

    private fun givenOnCompletedRequest() {
        doAnswer {
            (it.arguments[0] as BaseUseCase.Callback<List<TvShow>>).onCompleted(emptyList())
        }.whenever(useCase).execute(any(), any())
    }

    private fun givenOnErrorRequest() {
        doAnswer {
            (it.arguments[0] as BaseUseCase.Callback<List<TvShow>>).onError(Throwable())
        }.whenever(useCase).execute(any(), any())
    }

    private fun givenShowNotNull() = TvShow(0, "", "", "", "", 0.0)
}