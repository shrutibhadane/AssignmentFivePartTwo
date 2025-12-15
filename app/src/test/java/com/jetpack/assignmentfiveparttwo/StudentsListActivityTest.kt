package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for StudentsListActivity
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class StudentsListActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<StudentsListActivity>()

    @Test
    fun studentsListActivity_displaysTitle() {
        composeTestRule
            .onNodeWithText("Students List")
            .assertIsDisplayed()
    }

    @Test
    fun studentsListActivity_displaysSectionTitle() {
        composeTestRule
            .onNodeWithText("Section 3: LazyColumn with 30 Students")
            .assertIsDisplayed()
    }

    @Test
    fun studentsListActivity_hasBackButton() {
        composeTestRule
            .onNodeWithContentDescription("Back")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun studentsListActivity_displaysStudents() {
        composeTestRule
            .onNodeWithText("Student 1")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Student 2")
            .assertIsDisplayed()
    }
}
