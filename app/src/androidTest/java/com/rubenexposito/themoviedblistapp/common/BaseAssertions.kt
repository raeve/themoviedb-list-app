package com.rubenexposito.themoviedblistapp.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers.not
import java.lang.IllegalArgumentException

class BaseAssertions {
    companion object {
        fun hasItemCount(count: Int): ViewAssertion = RecyclerViewItemCountAssertion(count)
        fun isNotDisplayed(): ViewAssertion = NotDisplayedAssertion()
    }

    abstract class BaseAssertion : ViewAssertion{
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            if(noViewFoundException != null) throw noViewFoundException
            if(view == null) throw NullPointerException("The asserted view is null")
        }
    }

    private class RecyclerViewItemCountAssertion(private val count: Int) : BaseAssertion() {
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            super.check(view, noViewFoundException)
            if(view !is RecyclerView) throw IllegalArgumentException("The asserted view is not a RecyclerView")
            if(view.adapter == null) throw IllegalArgumentException("No adapter assigned to RecylcerView")

            ViewMatchers.assertThat("RecyclerView item count", view.adapter?.itemCount, CoreMatchers.equalTo(count))
        }
    }

    private class NotDisplayedAssertion : BaseAssertion() {
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            super.check(view, noViewFoundException)
            ViewAssertions.matches(not(isDisplayed()))
        }
    }
}