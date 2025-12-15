# Assignment Five Part Two - Jetpack Compose Demo

This Android application demonstrates 15 key Jetpack Compose concepts with clean, separated code architecture. The application is organized into individual learning modules, each accessible from a central dashboard.

## 📋 Features Implemented

### 1. **Custom Reusable Composables** (`ProfileCardSection.kt`)
- ✅ Created `ProfileCard` composable with function parameters
- ✅ Accepts: `name`, `email`, `role`
- ✅ **Dynamic Input Form**: Add new profiles at runtime with validation
- ✅ **Persistent Data**: Profile data survives simple configuration changes
- ✅ Displays inside a Card with padding & elevation

### 2. **Slots API - Composable Lambdas** (`SlotsApiSection.kt`)
- ✅ Created `SlotCard` that accepts header and footer slots
- ✅ Uses `@Composable () -> Unit` lambdas
- ✅ Passes different contents when calling the composable
- ✅ Demonstrates how slot APIs improve reusability

### 3. **Advanced LazyColumn** (`StudentsListSection.kt`)
- ✅ Displays a list of 30 students using LazyColumn
- ✅ Adds HorizontalDivider between items
- ✅ Click listener on each item → shows Toast with student name
- ✅ Demonstrates efficient list scrolling

### 4. **LazyRow - Horizontal Scrolling** (`CategoriesSection.kt`)
- ✅ Creates a LazyRow showing 8 categories
- ✅ Each item inside a Card
- ✅ Click handler highlights selected item
- ✅ Maintains selected state with `remember` and `mutableStateOf`

### 5. **Grid Layout** (`ProductsGridSection.kt`)
- ✅ Creates a 2-column grid of products
- ✅ Shows image + title + price
- ✅ Uses LazyVerticalGrid with `GridCells.Fixed(2)`
- ✅ Adds proper padding to ensure content isn't cut off

### 6. **Animation Basics** (`AnimationBasicsSection.kt`)
- ✅ Demonstrates `animateFloatAsState` for simple property animations
- ✅ Features a fade-in/fade-out illustration
- ✅ Includes scale and rotation animations on toggle

### 7. **Custom Styled TextField** (`CustomTextFieldSection.kt`)
- ✅ Customized input fields with leading/trailing icons
- ✅ Styled labels and placeholders using Material Design 3 guidelines
- ✅ Demonstrates handling focus and text input state

### 8. **Form Validation** (`FormValidationSection.kt`)
- ✅ Real-time field validation for Name, Email, and Password
- ✅ Displays error messages using `supportingText`
- ✅ Dynamic submit button state (enabled/disabled based on validity)
- ✅ Regex pattern matching for email validation

### 9. **Navigation** (`NavigationSection.kt`)
- ✅ Implements `NavigationComponent` with `NavHost` and `NavController`
- ✅ Demonstrates passing arguments between screens (e.g., Detail Screen)
- ✅ Handles back stack navigation properly

### 10. **Dialogs & Bottom Sheets** (`DialogsBottomSheetsSection.kt`)
- ✅ **AlertDialog**: Standard confirmation dialogs
- ✅ **ModalBottomSheet**: Slide-up sheet content
- ✅ Demonstrates state-driven visibility for overlays

### 11. **Tabs & Pager** (`TabsPagerSection.kt`)
- ✅ Implements `TabRow` for top navigation
- ✅ Integrates `HorizontalPager` for swipeable page content
- ✅ Synchronizes Tab selection with Pager state

### 12. **List Filtering** (`ListFilteringSection.kt`)
- ✅ Search bar implementation to filter list items
- ✅ Live updating of `LazyColumn` results based on search query
- ✅ Demonstrates local filtering logic in Compose

### 13. **State Hoisting** (`StateHoistingSection.kt`)
- ✅ Demonstrates "Unidirectional Data Flow" pattern
- ✅ Separates UI (stateless composable) from Logic (state holder)
- ✅ Passes events up and state down

### 14. **Dark Mode Support** (`DarkModeSection.kt`)
- ✅ **Global Theme Manager**: Changes theme app-wide securely
- ✅ Toggle switch for Light/Dark/System modes
- ✅ Persists theme choice across Activity navigation
- ✅ Demonstrates Material 3 dynamic color adaptation

### 15. **Onboarding Screens** (`OnboardingSection.kt`)
- ✅ Multi-step welcome flow using Pager
- ✅ "Next", "Skip", and "Get Started" navigation logic
- ✅ Use of indicators to show current page position

## 📁 Project Structure

```
app/src/main/java/com/jetpack/assignmentfiveparttwo/
├── MainActivity.kt                  # Main entry point, dashboard navigation
├── ThemeManager.kt                  # Singleton for global theme state management
│
├── ProfileCardsActivity.kt          # Section 1: Activity
├── ProfileCardSection.kt            # Section 1: Custom composables
│
├── SlotsApiActivity.kt              # Section 2: Activity
├── SlotsApiSection.kt               # Section 2: Slots API demo
│
├── StudentsListActivity.kt          # Section 3: Activity
├── StudentsListSection.kt           # Section 3: LazyColumn with students
│
├── CategoriesActivity.kt            # Section 4: Activity
├── CategoriesSection.kt             # Section 4: LazyRow with categories
│
├── ProductsGridActivity.kt          # Section 5: Activity
├── ProductsGridSection.kt           # Section 5: Grid layout
│
├── AnimationBasicsActivity.kt       # Section 6: Activity
├── AnimationBasicsSection.kt        # Section 6: Animation basics
│
├── CustomTextFieldActivity.kt       # Section 7: Activity
├── CustomTextFieldSection.kt        # Section 7: Custom TextFields
│
├── FormValidationActivity.kt        # Section 8: Activity
├── FormValidationSection.kt         # Section 8: Form validation logic
│
├── NavigationDemoActivity.kt        # Section 9: Activity
├── NavigationSection.kt             # Section 9: Navigation demo
│
├── DialogsBottomSheetsActivity.kt   # Section 10: Activity
├── DialogsBottomSheetsSection.kt    # Section 10: Dialogs & Sheets
│
├── TabsPagerActivity.kt             # Section 11: Activity
├── TabsPagerSection.kt              # Section 11: Tabs & Pager
│
├── ListFilteringActivity.kt         # Section 12: Activity
├── ListFilteringSection.kt          # Section 12: List filtering
│
├── StateHoistingActivity.kt         # Section 13: Activity
├── StateHoistingSection.kt          # Section 13: State hoisting
│
├── DarkModeActivity.kt              # Section 14: Activity
├── DarkModeSection.kt               # Section 14: Dark mode toggle
│
├── OnboardingActivity.kt            # Section 15: Activity
├── OnboardingSection.kt             # Section 15: Onboarding screens
│
└── ui/theme/
    ├── Color.kt                     # Custom Color Palette (Ocean/Slate Theme)
    ├── Theme.kt                     # Application Theme Configuration
    └── Type.kt                      # Typography definitions
```

## 🎨 Design Features

- **Premium Aesthetics**: Custom "Ocean Blue & Slate" color palette replacing default purple.
- **Material3 Design System**: Uses latest Material Design 3 components.
- **Dynamic Theming**: Full support for Light and Dark modes with instant toggling.
- **Clean Architecture**: Each section is isolated in its own Activity and Composable file.
- **Responsive UI**: Proper spacing, padding, and elevation handling across all screens.

## 🔧 Technical Details

- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Kotlin Version**: 2.0.21
- **Compose BOM**: 2024.10.01

## 🚀 How to Run

1. Open the project in Android Studio.
2. Sync Gradle files.
3. Run the app on an emulator or physical device.
4. Use the Dashboard in `MainActivity` to navigate to any of the 15 learning modules.

## 👨‍💻 Author

Created for Assignment Five Part Two - Jetpack Compose Fundamentals
