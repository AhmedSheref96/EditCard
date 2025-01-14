# EditCard Library

EditCard is an Android library that simplifies the process of editing and formatting card information in your applications.

[![](https://jitpack.io/v/AhmedSheref96/EditCard.svg)](https://jitpack.io/#AhmedSheref96/EditCard)

## Features
- User-friendly card editing UI.
- Supports formatting for various card types.
- Easy integration with Android projects.

## Installation

To include EditCard in your project, follow these steps:

1. Add the JitPack repository to your root `build.gradle` file:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. Add the dependency to your module `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.AhmedSheref96:EditCard:1.1.5'
}
```

## Usage

### Basic Setup
1. Add the EditCard view to your XML layout:

```xml
<com.yourpackage.EditCardView
    android:id="@+id/editCardView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

2. Initialize and configure it in your activity or fragment:

```java
EditCardView editCardView = findViewById(R.id.editCardView);
editCardView.setCardDetailsListener(new CardDetailsListener() {
    @Override
    public void onCardDetailsEntered(CardDetails details) {
        // Handle card details here
    }
});
```
