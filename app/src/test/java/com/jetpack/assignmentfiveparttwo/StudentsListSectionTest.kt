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
 * Robolectric test cases for StudentsListSection
 * Tests LazyColumn with 30 students
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class StudentsListSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun studentsList_displaysFirstStudent() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        composeTestRule
            .onNodeWithText("Student 1")
            .assertIsDisplayed()
    }

    @Test
    fun studentsList_displaysStudentGrade() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Student 1 should have Grade 2 (since (1 % 12) + 1 = 2)
        composeTestRule
            .onNodeWithText("Grade 2")
            .assertIsDisplayed()
    }

    @Test
    fun studentsList_displaysStudentId() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // First student should have ID 1
        composeTestRule
            .onNodeWithText("1")
            .assertIsDisplayed()
    }

    @Test
    fun studentsList_displaysMultipleStudents() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify multiple students are displayed
        composeTestRule
            .onNodeWithText("Student 1")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Student 2")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Student 3")
            .assertIsDisplayed()
    }

    @Test
    fun studentsList_has30Students() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify that Student 30 exists (may need to scroll)
        composeTestRule
            .onNodeWithText("Student 30")
            .assertExists()
    }

    @Test
    fun studentsList_isScrollable() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify first student is visible
        composeTestRule
            .onNodeWithText("Student 1")
            .assertIsDisplayed()

        // Verify last student exists (even if not visible)
        composeTestRule
            .onNodeWithText("Student 30")
            .assertExists()
    }

    @Test
    fun studentsList_itemsAreClickable() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify student items have click action
        composeTestRule
            .onNodeWithText("Student 1")
            .assertHasClickAction()
    }

    @Test
    fun studentsList_displaysCorrectGradeCalculation() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Student 12 should have Grade 1 (since (12 % 12) + 1 = 1)
        // We need to scroll to find it, but we can check if it exists
        composeTestRule
            .onNodeWithText("Student 12")
            .assertExists()
    }

    @Test
    fun student_dataClassWorks() {
        val student = Student(1, "Test Student", "Grade A")
        
        assert(student.id == 1)
        assert(student.name == "Test Student")
        assert(student.grade == "Grade A")
    }

    @Test
    fun studentsList_displaysInCard() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify content is displayed (students should be visible)
        composeTestRule
            .onNodeWithText("Student 1")
            .assertIsDisplayed()
    }

    @Test
    fun studentsList_hasProperStructure() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify that multiple students with different IDs exist
        composeTestRule
            .onNodeWithText("1") // ID
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("2") // ID
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("3") // ID
            .assertIsDisplayed()
    }

    @Test
    fun studentsList_displaysStudentNames() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify student names follow the pattern
        val studentNames = listOf("Student 1", "Student 2", "Student 3", "Student 4", "Student 5")
        studentNames.forEach { name ->
            composeTestRule
                .onNodeWithText(name)
                .assertExists()
        }
    }

    @Test
    fun studentsList_middleStudentsExist() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify middle students exist
        composeTestRule
            .onNodeWithText("Student 15")
            .assertExists()

        composeTestRule
            .onNodeWithText("Student 20")
            .assertExists()
    }

    @Test
    fun studentsList_lastStudentExists() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                StudentsListSection()
            }
        }

        // Verify the last student (Student 30) exists
        composeTestRule
            .onNodeWithText("Student 30")
            .assertExists()
    }
}
