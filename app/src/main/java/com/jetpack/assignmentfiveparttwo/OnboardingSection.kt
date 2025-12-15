package com.jetpack.assignmentfiveparttwo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

/**
 * Section 15: Intro UI Design With Onboarding Screens
 * Demonstrates onboarding flow with HorizontalPager and navigation
 */

data class OnboardingPage(
    val title: String,
    val description: String,
    val emoji: String,
    val backgroundColor: Color
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingSection() {
    val pages = listOf(
        OnboardingPage(
            title = stringResource(R.string.welcome_to_our_app),
            description = stringResource(R.string.discover_amazing_features_and_boost_your_productivity_with_our_intuitive_interface),
            emoji = "👋",
            backgroundColor = Color(0xFF6200EE)
        ),
        OnboardingPage(
            title = stringResource(R.string.stay_organized),
            description = stringResource(R.string.keep_track_of_all_your_tasks_and_projects_in_one_place_never_miss_a_deadline_again),
            emoji = "📋",
            backgroundColor = Color(0xFF03DAC5)
        ),
        OnboardingPage(
            title = stringResource(R.string.get_started),
            description = stringResource(R.string.you_re_all_set_let_s_begin_your_journey_to_better_productivity_and_organization),
            emoji = "🚀",
            backgroundColor = Color(0xFFFF6B6B)
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val coroutineScope = rememberCoroutineScope()
    var completed = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }

    if (completed.value) {
        // Home Screen after onboarding
        OnboardingCompleteScreen(onRestart = { completed.value = false })
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            // Horizontal Pager
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                OnboardingPageContent(pages[page])
            }

            // Bottom Controls
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                // Page Indicators
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pages.size) { index ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(
                                    width = if (pagerState.currentPage == index) 24.dp else 8.dp,
                                    height = 8.dp
                                )
                                .clip(CircleShape)
                                .background(
                                    if (pagerState.currentPage == index)
                                        colorResource(R.color.white)
                                    else
                                        colorResource(R.color.white).copy(alpha = 0.5f)
                                )
                        )
                    }
                }

                // Navigation Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Skip Button
                    if (pagerState.currentPage < pages.size - 1) {
                        TextButton(
                            onClick = { completed.value = true },
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = colorResource(R.color.white)
                            )
                        ) {
                            Text("Skip", fontSize = 16.sp)
                        }
                    } else {
                        Spacer(modifier = Modifier.width(1.dp))
                    }

                    // Next/Get Started Button
                    Button(
                        onClick = {
                            if (pagerState.currentPage < pages.size - 1) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            } else {
                                completed.value = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.white),
                            contentColor = pages[pagerState.currentPage].backgroundColor
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (pagerState.currentPage < pages.size - 1) stringResource(R.string.next) else stringResource(R.string.get_started) ,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                        Icon(
                            imageVector = if (pagerState.currentPage < pages.size - 1)
                                Icons.Default.ArrowForward
                            else
                                Icons.Default.Check,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(page.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Emoji/Image
            Text(
                text = page.emoji,
                fontSize = 120.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Title
            Text(
                text = page.title,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.white),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Description
            Text(
                text = page.description,
                fontSize = 16.sp,
                color = colorResource(R.color.white).copy(alpha = 0.9f),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun OnboardingCompleteScreen(onRestart: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🎉",
                        fontSize = 80.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Welcome!",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "You've completed the onboarding!",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onRestart,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Restart Onboarding",
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Onboarding Features:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("✓ 3 onboarding screens", fontSize = 12.sp)
                    Text("✓ HorizontalPager with swipe", fontSize = 12.sp)
                    Text("✓ Page indicators", fontSize = 12.sp)
                    Text("✓ Next & Skip buttons", fontSize = 12.sp)
                    Text("✓ Navigation to home screen", fontSize = 12.sp)
                    Text("✓ State control", fontSize = 12.sp)
                }
            }
        }
    }
}
