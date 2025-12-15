# Assignment Five Part Two - Jetpack Compose Demo

This Android application demonstrates 15 key Jetpack Compose concepts with clean, separated code architecture. The application is organized into individual learning modules, each accessible from a central dashboard.

## 📋 Features Implemented
- <img width="1080" height="2412" alt="Screenshot_20251215_163246" src="https://github.com/user-attachments/assets/72bfcbb0-6aee-4e1b-a98f-8946c2ecba33" />
  <img width="1080" height="2412" alt="Screenshot_20251215_163216" src="https://github.com/user-attachments/assets/533b5643-687b-4426-a5e1-76d068531b11" />

### 1. **Custom Reusable Composables** (`ProfileCardSection.kt`)
- ✅ Created `ProfileCard` composable with function parameters
- ✅ Accepts: `name`, `email`, `role`
- ✅ **Dynamic Input Form**: Add new profiles at runtime with validation
- ✅ **Persistent Data**: Profile data survives simple configuration changes
- ✅ Displays inside a Card with padding & elevation

<img width="1080" height="2412" alt="Screenshot_20251215_163326" src="https://github.com/user-attachments/assets/a883c832-28f0-4286-a5ca-df9fb1406123" />

### 2. **Slots API - Composable Lambdas** (`SlotsApiSection.kt`)
- ✅ Created `SlotCard` that accepts header and footer slots
- ✅ Uses `@Composable () -> Unit` lambdas
- ✅ Passes different contents when calling the composable
- ✅ Demonstrates how slot APIs improve reusability

<img width="1080" height="2412" alt="Screenshot_20251215_163340" src="https://github.com/user-attachments/assets/3614ce0e-5b08-4821-a668-454e4e8c93f4" />

### 3. **Advanced LazyColumn** (`StudentsListSection.kt`)
- ✅ Displays a list of 30 students using LazyColumn
- ✅ Adds HorizontalDivider between items
- ✅ Click listener on each item → shows Toast with student name
- ✅ Demonstrates efficient list scrolling

<img width="1080" height="2412" alt="Screenshot_20251215_163351" src="https://github.com/user-attachments/assets/3ec5c7f3-509d-4755-b680-89904acd1175" />

### 4. **LazyRow - Horizontal Scrolling** (`CategoriesSection.kt`)
- ✅ Creates a LazyRow showing 8 categories
- ✅ Each item inside a Card
- ✅ Click handler highlights selected item
- ✅ Maintains selected state with `remember` and `mutableStateOf`

<img width="1080" height="2412" alt="Screenshot_20251215_163402" src="https://github.com/user-attachments/assets/7aaed0fb-867c-4c9d-a00d-5b88d2dbe630" />

### 5. **Grid Layout** (`ProductsGridSection.kt`)
- ✅ Creates a 2-column grid of products
- ✅ Shows image + title + price
- ✅ Uses LazyVerticalGrid with `GridCells.Fixed(2)`
- ✅ Adds proper padding to ensure content isn't cut off

<img width="1080" height="2412" alt="Screenshot_20251215_163423" src="https://github.com/user-attachments/assets/5598a522-bb00-4023-9c07-7a508d53933b" />

### 6. **Animation Basics** (`AnimationBasicsSection.kt`)
- ✅ Demonstrates `animateFloatAsState` for simple property animations
- ✅ Features a fade-in/fade-out illustration
- ✅ Includes scale and rotation animations on toggle

<img width="1080" height="2412" alt="Screenshot_20251215_163441" src="https://github.com/user-attachments/assets/9144c343-e34b-4bff-9386-05fee46eff7e" />
<img width="1080" height="2412" alt="Screenshot_20251215_163451" src="https://github.com/user-attachments/assets/01e6aede-1515-42f4-a46d-2069a65c836a" />

### 7. **Custom Styled TextField** (`CustomTextFieldSection.kt`)
- ✅ Customized input fields with leading/trailing icons
- ✅ Styled labels and placeholders using Material Design 3 guidelines
- ✅ Demonstrates handling focus and text input state

  <img width="1080" height="2412" alt="Screenshot_20251215_163527" src="https://github.com/user-attachments/assets/a4106701-4ac7-47f6-b9f0-8ff960bf8fb2" />
  <img width="1080" height="2412" alt="Screenshot_20251215_163547" src="https://github.com/user-attachments/assets/8ef57e66-927e-4d61-a395-cb532e0f384c" />

### 8. **Form Validation** (`FormValidationSection.kt`)
- ✅ Real-time field validation for Name, Email, and Password
- ✅ Displays error messages using `supportingText`
- ✅ Dynamic submit button state (enabled/disabled based on validity)
- ✅ Regex pattern matching for email validation

  <img width="1080" height="2412" alt="Screenshot_20251215_163559" src="https://github.com/user-attachments/assets/b1c81559-07b3-49ee-9648-3ac617fddbcf" />

### 9. **Navigation** (`NavigationSection.kt`)
- ✅ Implements `NavigationComponent` with `NavHost` and `NavController`
- ✅ Demonstrates passing arguments between screens (e.g., Detail Screen)
- ✅ Handles back stack navigation properly

<img width="1080" height="2412" alt="Screenshot_20251215_163617" src="https://github.com/user-attachments/assets/28e942de-f5a4-46b9-94ff-e2b599c074db" />
<img width="1080" height="2412" alt="Screenshot_20251215_163624" src="https://github.com/user-attachments/assets/b2c48000-c51c-4352-9868-b4e5b54ca0c9" />

### 10. **Dialogs & Bottom Sheets** (`DialogsBottomSheetsSection.kt`)
- ✅ **AlertDialog**: Standard confirmation dialogs
- ✅ **ModalBottomSheet**: Slide-up sheet content
- ✅ Demonstrates state-driven visibility for overlays

<img width="1080" height="2412" alt="Screenshot_20251215_163651" src="https://github.com/user-attachments/assets/167366e9-ee69-4dfe-bcb6-dadb0e36f7a4" />
<img width="1080" height="2412" alt="Screenshot_20251215_163644" src="https://github.com/user-attachments/assets/0f382b77-57a4-4a86-b1f2-c034725d4311" />

### 11. **Tabs & Pager** (`TabsPagerSection.kt`)
- ✅ Implements `TabRow` for top navigation
- ✅ Integrates `HorizontalPager` for swipeable page content
- ✅ Synchronizes Tab selection with Pager state

<img width="1080" height="2412" alt="Screenshot_20251215_163856" src="https://github.com/user-attachments/assets/180b3aa9-eb6c-4c10-b7d6-82257e230d00" />

### 12. **List Filtering** (`ListFilteringSection.kt`)
- ✅ Search bar implementation to filter list items
- ✅ Live updating of `LazyColumn` results based on search query
- ✅ Demonstrates local filtering logic in Compose

<img width="1080" height="2412" alt="Screenshot_20251215_164801" src="https://github.com/user-attachments/assets/bdbaf6b8-d482-4804-bd21-8ae24d78f099" />
<img width="1080" height="2412" alt="Screenshot_20251215_164828" src="https://github.com/user-attachments/assets/da8e3f47-9708-4a9f-932a-eb40b0168ce9" />
<img width="1080" height="2412" alt="Screenshot_20251215_164836" src="https://github.com/user-attachments/assets/882c8cb0-d55e-4341-ac1b-98249fca5357" />

### 13. **State Hoisting** (`StateHoistingSection.kt`)
- ✅ Demonstrates "Unidirectional Data Flow" pattern
- ✅ Separates UI (stateless composable) from Logic (state holder)
- ✅ Passes events up and state down

  <img width="1080" height="2412" alt="Screenshot_20251215_164901" src="https://github.com/user-attachments/assets/254b12e4-e931-420f-b440-557561cbab16" />

### 14. **Dark Mode Support** (`DarkModeSection.kt`)
- ✅ **Global Theme Manager**: Changes theme app-wide securely
- ✅ Toggle switch for Light/Dark/System modes
- ✅ Persists theme choice across Activity navigation
- ✅ Demonstrates Material 3 dynamic color adaptation

<img width="1080" height="2412" alt="Screenshot_20251215_164916" src="https://github.com/user-attachments/assets/e359d77c-66fb-4397-9565-a65ecd46e70d" />
<img width="1080" height="2412" alt="Screenshot_20251215_164926" src="https://github.com/user-attachments/assets/27328b28-7989-4619-ac40-ae5bba2c8bfa" />

### 15. **Onboarding Screens** (`OnboardingSection.kt`)
- ✅ Multi-step welcome flow using Pager
- ✅ "Next", "Skip", and "Get Started" navigation logic
- ✅ Use of indicators to show current page position

<img width="1080" height="2412" alt="Screenshot_20251215_165359" src="https://github.com/user-attachments/assets/6703a7a9-93c7-44e7-a654-23622e4d0acc" />
<img width="1080" height="2412" alt="Screenshot_20251215_164949" src="https://github.com/user-attachments/assets/2e7f5e71-e3c3-4e6b-b086-fd5a0339a98c" />
<img width="1080" height="2412" alt="Screenshot_20251215_164944" src="https://github.com/user-attachments/assets/ab155885-4544-49a6-836b-88d749ca774d" />
<img width="1080" height="2412" alt="Screenshot_20251215_164938" src="https://github.com/user-attachments/assets/46cc4ee1-bb6d-49b8-ad68-e5ad21b65a28" />


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
