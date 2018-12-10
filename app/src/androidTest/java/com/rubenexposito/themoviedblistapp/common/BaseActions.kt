package com.rubenexposito.themoviedblistapp.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import java.lang.IllegalArgumentException

class BaseActions {
    companion object {
        fun sleep(millis: Long): ViewAction = SleepViewAction(millis)
    }

    private class SleepViewAction(private val millis: Long) : ViewAction {
        override fun getConstraints(): Matcher<View> = isRoot()
        override fun getDescription(): String = "wait $millis millis"

        override fun perform(uiController: UiController?, view: View?) {
            uiController?.loopMainThreadUntilIdle()
            uiController?.loopMainThreadForAtLeast(millis)
        }
    }
}