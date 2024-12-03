# GitHub User Finder - Kotlin Multiplatform Project

🚀 Project Overview

This is a Kotlin Multiplatform project designed to search for GitHub users and display their profile details, including their profile image, name, and number of repositories. The project is a demonstration of cross-platform development using shared logic for iOS and Android while maintaining platform-specific UI experiences.

	• iOS UI: Built using UIViewController.
	• Android UI: Developed with Jetpack Compose.

🛠️ Features

	• Search for any GitHub user by their username.
	• View a user’s profile information, including:
	• Profile image
	• Name
	• Number of repositories

https://github.com/user-attachments/assets/f605b82a-94db-444c-92ad-c5d6e4528a6f

https://github.com/user-attachments/assets/a7c8a5ef-a8b8-4081-a144-d036b4f065e3

Architecture

The project follows a 3-layer Clean Architecture to ensure:

	• Separation of concerns.
	• Scalability and maintainability.
	• Testability through Dependency Injection (DI).

While unit tests are not included, the code is structured with:

	• Interfaces for dependencies to facilitate easy mocking.
	• Fully injected dependencies using DI, making unit testing straightforward to implement.

📚 Libraries and Tools

🌐 Shared Libraries (iOS and Android)

	1. Ktor: For network calls to fetch GitHub user data.
	2. kotlinx-serialization: For JSON parsing and serialization.
	3. Napier: For structured logging.
	4. Koin: For Dependency Injection.

🤖 Android-Specific Libraries

	1. Coroutines: For asynchronous programming and background operations.
	2. Coil: For efficient image loading.
	3. Compose Navigation: For handling navigation within Jetpack Compose.

🍎 iOS-Specific Libraries

	1. RxSwift: Reactive programming for managing asynchronous tasks.
	2. RxCocoa: Reactive extensions for UIKit elements.
	3. RxRelay: A lightweight tool for event-driven programming.
	4. SDWebImage: For loading and caching images.

🧩 Technical Highlights

	• Clean Architecture: The project is structured into three layers (Presentation, Domain, and Data) for modularity and testability.
	• Cross-Platform Compatibility: Shared business logic across platforms ensures consistency while leveraging platform-specific UI frameworks.
	• Dependency Injection: Used across the codebase to manage dependencies, making the app flexible and easier to test.
	• Replaceable Dependencies: Interfaces are used instead of classes, making dependencies easily mockable for unit testing.

🚧 Room for Improvement

	• Unit Testing: Although not included, the project is designed to support unit tests with its DI setup and interface-based architecture.
 	• Local Database: Even though I have not implemented a local database to cache the results, we can easily give offline support by introducing the database in the data layer inside common main
	• UI Enhancements: Future versions could include animations or more detailed GitHub profile information.

🎯 How to Run the Project

	1. Clone the repository.
	2. Follow the platform-specific instructions for Android and iOS to build and run the app.
	3. Start searching for GitHub users and view their profiles!

📖 Future Scope

	• Add support for additional GitHub user details, like followers and starred repositories.
	• Include unit and integration tests.
	• Explore shared UI using libraries like Jetpack Compose Multiplatform or SwiftUI with KMM.









