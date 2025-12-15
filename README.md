# Assignment Five Part Two - Jetpack Compose Demo

This Android application demonstrates 5 key Jetpack Compose concepts with clean, separated code architecture.

## 📋 Features Implemented

### 1. **Custom Reusable Composables** (`ProfileCardSection.kt`)
- ✅ Created `ProfileCard` composable with function parameters
- ✅ Accepts: `name`, `email`, `image`, `role`
- ✅ Displays inside a Card with padding & elevation
- ✅ Called 3 times with different data
- ✅ Demonstrates component reusability

**Key Concepts:**
- Function parameters for composables
- Material3 Card with elevation
- Circular avatar with first letter
- Reusable component pattern

### 2. **Slots API - Composable Lambdas** (`SlotsApiSection.kt`)
- ✅ Created `SlotCard` that accepts header and footer slots
- ✅ Uses `@Composable () -> Unit` lambdas
- ✅ Passes different contents when calling the composable
- ✅ Demonstrates how slot APIs improve reusability

**Key Concepts:**
- `@Composable () -> Unit` lambda parameters
- Flexible content composition
- Header/Footer slot pattern
- Enhanced reusability through slots

### 3. **Advanced LazyColumn** (`StudentsListSection.kt`)
- ✅ Displays a list of 30 students using LazyColumn
- ✅ Adds Divider between each item
- ✅ Click listener on each item → shows Toast with student name
- ✅ Uses LazyColumn, items, and Divider

**Key Concepts:**
- LazyColumn for efficient scrolling
- `items()` function for list rendering
- HorizontalDivider between items
- Click handling with Toast

### 4. **LazyRow - Horizontal Scrolling** (`CategoriesSection.kt`)
- ✅ Creates a LazyRow showing 8 categories
- ✅ Each item inside a Card
- ✅ Click handler highlights selected item
- ✅ Maintains selected state with `remember` and `mutableStateOf`

**Key Concepts:**
- LazyRow for horizontal scrolling
- State management with `remember` and `mutableStateOf`
- Dynamic styling based on state
- Click handling with state updates

### 5. **Grid Layout** (`ProductsGridSection.kt`)
- ✅ Creates a 2-column grid of products
- ✅ Shows image + title + price
- ✅ Uses LazyVerticalGrid
- ✅ Adds spacing, padding, and shape clipping

**Key Concepts:**
- LazyVerticalGrid with GridCells.Fixed(2)
- Aspect ratio for consistent card sizes
- Spacing and padding
- Shape clipping with RoundedCornerShape

## 📁 Project Structure

```
app/src/main/java/com/jetpack/assignmentfiveparttwo/
├── MainActivity.kt              # Main entry point, coordinates all sections
├── ProfileCardSection.kt        # Section 1: Custom composables
├── SlotsApiSection.kt          # Section 2: Slots API demo
├── StudentsListSection.kt      # Section 3: LazyColumn with students
├── CategoriesSection.kt        # Section 4: LazyRow with categories
├── ProductsGridSection.kt      # Section 5: Grid layout
└── ui/theme/
    ├── Color.kt                # Material3 color definitions
    ├── Theme.kt                # App theme configuration
    └── Type.kt                 # Typography definitions
```

## 🎨 Design Features

- **Material3 Design System**: Uses latest Material Design 3 components
- **Dynamic Theming**: Supports light/dark themes and dynamic colors (Android 12+)
- **Clean Architecture**: Each section in separate file for maintainability
- **Responsive UI**: Proper spacing, padding, and elevation
- **Interactive Elements**: Click handlers, state management, and visual feedback

## 🔧 Technical Details

- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Kotlin Version**: 2.0.21
- **Compose BOM**: 2024.10.01
- **AGP Version**: 8.7.3

## 🚀 How to Run

1. Open the project in Android Studio
2. Sync Gradle files
3. Run the app on an emulator or physical device
4. Scroll through the app to see all 5 sections

## 📱 Features to Test

1. **Profile Cards**: View 3 different profile cards with different data
2. **Slots API**: See two cards with different header/footer content
3. **Students List**: 
   - Scroll through 30 students
   - Click any student to see a Toast with their name
4. **Categories**: 
   - Scroll horizontally through categories
   - Click to select and see visual highlighting
5. **Products Grid**: 
   - View products in 2-column grid
   - Scroll through 12 products

## 📚 Learning Outcomes

This project demonstrates:
- ✅ Creating reusable composables with parameters
- ✅ Using composable lambdas for flexible layouts
- ✅ Efficient list rendering with LazyColumn
- ✅ Horizontal scrolling with LazyRow
- ✅ Grid layouts with LazyVerticalGrid
- ✅ State management in Compose
- ✅ Click handling and user interaction
- ✅ Material3 theming and components
- ✅ Clean code organization

## 👨‍💻 Author

Created for Assignment Five Part Two - Jetpack Compose Fundamentals
