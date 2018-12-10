package com.rubenexposito.themoviedblistapp.presentation.showlist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.BaseActions.Companion.sleep
import com.rubenexposito.themoviedblistapp.common.BaseAssertions.Companion.hasItemCount
import com.rubenexposito.themoviedblistapp.common.BaseAssertions.Companion.isNotDisplayed
import com.rubenexposito.themoviedblistapp.common.asApp
import com.rubenexposito.themoviedblistapp.di.AppComponent
import com.rubenexposito.themoviedblistapp.di.AppModule
import com.rubenexposito.themoviedblistapp.di.NetworkModule
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import io.reactivex.Single
import it.cosenonjaviste.daggermock.DaggerMock
import org.junit.Rule
import org.junit.Test

class ShowListActivityTest {

    @get:Rule
    val daggerRule = DaggerMock.rule<AppComponent>(AppModule(), NetworkModule()) {
        set {
            val app = InstrumentationRegistry.getInstrumentation().targetContext.asApp()
            app.updateComponent(it)
        }
        customizeBuilder<AppComponent.Builder> {
            it.application(InstrumentationRegistry.getInstrumentation().targetContext.asApp())
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule(ShowListActivity::class.java, false, false)

    private val theMovieDbRepository: TheMovieDbRepository = mock()


    @Test
    fun shouldLoadItemsWhenGivenSuccessfulResponse() {
        givenSuccessfulResponse()

        activityRule.launchActivity(null)

        onView(isRoot()).perform(sleep(1000))
        onView(withId(R.id.rvShowList)).check(hasItemCount(20))
        onView(withId(R.id.progressView)).check(isNotDisplayed())
        onView(withId(R.id.viewEmpty)).check(isNotDisplayed())
    }

    private fun givenSuccessfulResponse() {
        given {
            theMovieDbRepository.getPopularTvShows("es-ES", 1)
        }.willReturn(Single.just(listOf(givenTvShow())))
    }

    private fun givenTvShow() = TvShow(1, "")
}