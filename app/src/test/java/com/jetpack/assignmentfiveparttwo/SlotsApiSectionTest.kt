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
 * Robolectric test cases for SlotsApiSection
 * Tests the Slots API pattern with composable lambdas
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class SlotsApiSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun slotsApi_displaysFirstCard() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("Welcome Card")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApi_displaysFirstCardContent() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("This demonstrates the Slots API pattern. The header and footer are passed as composable lambdas!")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApi_displaysFirstCardFooter() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("Footer: Learn More →")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApi_displaysSecondCard() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("Special Offer")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApi_displaysSecondCardEmoji() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("🎉")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApi_displaysSecondCardContent() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("Get 50% off on your next purchase! This slot contains completely different content.")
            .assertIsDisplayed()
    }

    @Test
    fun slotsApi_displaysClaimOfferButton() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        composeTestRule
            .onNodeWithText("Claim Offer")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun slotCard_displaysCustomHeader() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotCard(
                    header = {
                        androidx.compose.material3.Text("Custom Header")
                    },
                    footer = {
                        androidx.compose.material3.Text("Custom Footer")
                    },
                    content = {
                        androidx.compose.material3.Text("Custom Content")
                    }
                )
            }
        }

        composeTestRule
            .onNodeWithText("Custom Header")
            .assertIsDisplayed()
    }

    @Test
    fun slotCard_displaysCustomFooter() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotCard(
                    header = {
                        androidx.compose.material3.Text("Custom Header")
                    },
                    footer = {
                        androidx.compose.material3.Text("Custom Footer")
                    },
                    content = {
                        androidx.compose.material3.Text("Custom Content")
                    }
                )
            }
        }

        composeTestRule
            .onNodeWithText("Custom Footer")
            .assertIsDisplayed()
    }

    @Test
    fun slotCard_displaysCustomContent() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotCard(
                    header = {
                        androidx.compose.material3.Text("Custom Header")
                    },
                    footer = {
                        androidx.compose.material3.Text("Custom Footer")
                    },
                    content = {
                        androidx.compose.material3.Text("Custom Content")
                    }
                )
            }
        }

        composeTestRule
            .onNodeWithText("Custom Content")
            .assertIsDisplayed()
    }

    @Test
    fun slotCard_acceptsComplexHeaderContent() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotCard(
                    header = {
                        androidx.compose.foundation.layout.Row {
                            androidx.compose.material3.Text("Icon: ")
                            androidx.compose.material3.Text("Title")
                        }
                    },
                    footer = {
                        androidx.compose.material3.Text("Footer")
                    },
                    content = {
                        androidx.compose.material3.Text("Content")
                    }
                )
            }
        }

        composeTestRule
            .onNodeWithText("Icon: ")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Title")
            .assertIsDisplayed()
    }

    @Test
    fun slotCard_acceptsButtonInFooter() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotCard(
                    header = {
                        androidx.compose.material3.Text("Header")
                    },
                    footer = {
                        androidx.compose.material3.Button(onClick = {}) {
                            androidx.compose.material3.Text("Action Button")
                        }
                    },
                    content = {
                        androidx.compose.material3.Text("Content")
                    }
                )
            }
        }

        composeTestRule
            .onNodeWithText("Action Button")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun slotsApi_bothCardsDisplayedTogether() {
        composeTestRule.setContent {
            AssignmentFivePartTwoTheme {
                SlotsApiSection()
            }
        }

        // Verify both cards are present
        composeTestRule
            .onNodeWithText("Welcome Card")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Special Offer")
            .assertIsDisplayed()
    }
}
