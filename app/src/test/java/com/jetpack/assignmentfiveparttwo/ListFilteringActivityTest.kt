package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for ListFilteringActivity
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class ListFilteringActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ListFilteringActivity>()

    @Test
    fun listFilteringActivity_displaysTitle() {
        composeTestRule
            .onNodeWithText("List Filtering")
            .assertIsDisplayed()
    }

    @Test
    fun listFilteringActivity_displaysSectionTitle() {
        composeTestRule
            .onNodeWithText("Section 12: Search & Filter")
            .assertIsDisplayed()
    }

    @Test
    fun listFilteringActivity_hasBackButton() {
        composeTestRule
            .onNodeWithContentDescription("Back")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun listFilteringActivity_displaysSearchFeature() {
        composeTestRule
            .onNodeWithText("City Search")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Search cities...")
            .assertIsDisplayed()
    }
}
