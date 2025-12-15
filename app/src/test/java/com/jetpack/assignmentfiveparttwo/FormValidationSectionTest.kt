package com.jetpack.assignmentfiveparttwo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.jetpack.assignmentfiveparttwo.ui.theme.AssignmentFivePartTwoTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Robolectric test cases for FormValidationSection
 * Tests form validation logic and UI interactions
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class FormValidationSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun formValidation_displaysTitle() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        composeTestRule
            .onNodeWithText("Registration Form")
            .assertIsDisplayed()
    }

    @Test
    fun formValidation_displaysAllFields() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

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

    @Test
    fun formValidation_submitButtonDisabledInitially() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        composeTestRule
            .onNodeWithText("Fill all fields correctly")
            .assertIsDisplayed()
            .assertIsNotEnabled()
    }

    @Test
    fun formValidation_nameFieldValidation_tooShort() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter a name that's too short
        composeTestRule
            .onNodeWithText("Full Name")
            .performTextInput("Jo")

        // Verify error message appears
        composeTestRule
            .onNodeWithText("Name must be at least 3 characters")
            .assertIsDisplayed()
    }

    @Test
    fun formValidation_nameFieldValidation_valid() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter a valid name
        composeTestRule
            .onNodeWithText("Full Name")
            .performTextInput("John Doe")

        // Verify no error message
        composeTestRule
            .onNodeWithText("Name must be at least 3 characters")
            .assertDoesNotExist()
    }

    @Test
    fun formValidation_emailFieldValidation_invalid() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter an invalid email
        composeTestRule
            .onNodeWithText("Email Address")
            .performTextInput("invalidemail")

        // Verify error message appears
        composeTestRule
            .onNodeWithText("Invalid email format")
            .assertIsDisplayed()
    }

    @Test
    fun formValidation_emailFieldValidation_valid() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter a valid email
        composeTestRule
            .onNodeWithText("Email Address")
            .performTextInput("test@example.com")

        // Verify no error message
        composeTestRule
            .onNodeWithText("Invalid email format")
            .assertDoesNotExist()
    }

    @Test
    fun formValidation_passwordFieldValidation_tooShort() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter a password that's too short
        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("12345")

        // Verify error message appears
        composeTestRule
            .onNodeWithText("Password must be at least 6 characters")
            .assertIsDisplayed()
    }

    @Test
    fun formValidation_passwordFieldValidation_noDigit() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter a password without digits
        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("abcdefgh")

        // Verify error message appears
        composeTestRule
            .onNodeWithText("Password must contain at least one digit")
            .assertIsDisplayed()
    }

    @Test
    fun formValidation_passwordFieldValidation_valid() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Enter a valid password
        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("password123")

        // Verify no error messages
        composeTestRule
            .onNodeWithText("Password must be at least 6 characters")
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithText("Password must contain at least one digit")
            .assertDoesNotExist()
    }

    @Test
    fun formValidation_submitButtonEnabledWhenFormValid() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Fill all fields with valid data
        composeTestRule
            .onNodeWithText("Full Name")
            .performTextInput("John Doe")

        composeTestRule
            .onNodeWithText("Email Address")
            .performTextInput("john@example.com")

        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("password123")

        // Verify submit button is enabled
        composeTestRule
            .onNodeWithText("Submit Form")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun formValidation_successMessageDisplayedAfterSubmit() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        // Fill all fields with valid data
        composeTestRule
            .onNodeWithText("Full Name")
            .performTextInput("John Doe")

        composeTestRule
            .onNodeWithText("Email Address")
            .performTextInput("john@example.com")

        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("password123")

        // Click submit button
        composeTestRule
            .onNodeWithText("Submit Form")
            .performClick()

        // Verify success message
        composeTestRule
            .onNodeWithText("✓ Form submitted successfully!")
            .assertIsDisplayed()
    }

    @Test
    fun formValidation_displaysValidationRules() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                FormValidationSection()
            }
        }

        composeTestRule
            .onNodeWithText("Validation Rules:")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("• Name: min 3 characters")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("• Email: must contain @ and .")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("• Password: min 6 chars + 1 digit")
            .assertIsDisplayed()
    }
}
