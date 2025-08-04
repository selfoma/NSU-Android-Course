# NSU-Android-Course

## Lab 1: Navigation

Create 3 distinguishable screens (you can use different text or background colors). Each screen should have a button to navigate to the next screen. Let the screens be named A, B, and C. Organize navigation as follows:

* The button opens the next screen (A -> B -> C)
* On screen A, the system back button should exit the app; on other screens, it should return to the previous screen
* The navigation flow should be: A <-> B <-> C -> A

> **Note**: Do not use fragments. Launch activities using `activityLaunchMode`. Intercepting the system back button or manually finishing the activity will not be accepted.

## Lab 2: Layout

Practice layout design by creating a mock-up of a music player. You need to build a track list from a design using any suitable layout tools. Use **RecyclerView** to implement the list.

The design includes images; you can replace them with a static 48x48 vector icon. Working with images is out of scope for this lab. The resulting list must be scrollable, and you can choose how many items to display.

> The design is available [here](https://www.figma.com/design/B1RxFRYcflOqhxVX9WipJ0/%D0%A0%D0%BE%D0%BC%D0%B0%D0%BD-%D0%A2%D0%B8%D1%82%D0%BE%D0%B2's-team-library?node-id=2312-1185&t=rPpuixaqgsco3Xgv-1)

## Lab 3: Currency Converter

Implement a currency converter with the following functionality:

* Download the [list of currencies](https://www.cbr-xml-daily.ru) from the Central Bank website and display it as a list
* Provide the ability to convert a specified amount in rubles to the selected currency

Both features are **required**. You may use libraries.

> The app design is up to you.
