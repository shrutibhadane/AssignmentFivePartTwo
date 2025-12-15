package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for FormValidationActivity
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class FormValidationActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<FormValidationActivity>()

    @Test
    fun formValidationActivity_displaysTitle() {
        composeTestRule
            .onNodeWithText("Form Validation")
            .assertIsDisplayed()
    }

    @Test
    fun formValidationActivity_displaysSectionTitle() {
        composeTestRule
            .onNodeWithText("Section 8: Form Validation")
            .assertIsDisplayed()
    }

    @Test
    fun formValidationActivity_hasBackButton() {
        composeTestRule
            .onNodeWithContentDescription("Back")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun formValidationActivity_displaysForm() {
        composeTestRule
            .onNodeWithText("Registration Form")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Full Name")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Email Address")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Password")
            .assertIsDisplayed()
    }
}
