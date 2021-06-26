package com.stambulo.testrecyclerview.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.stambulo.testrecyclerview.MainActivity
import com.stambulo.testrecyclerview.MyAdapter
import com.stambulo.testrecyclerview.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecyclerViewTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activitySearch_ScrollTo() {
        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.scrollTo<MyAdapter.ViewHolder>(
                hasDescendant(withText("Element - 40"))
            )
        )
    }

    @Test
    fun activitySearch_PerformClickAtPosition() {
        onView(withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MyAdapter.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
    }

    @After
    fun close() {
        scenario.close()
    }
}
