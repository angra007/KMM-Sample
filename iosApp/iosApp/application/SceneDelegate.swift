//
//  SceneDelegate.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-29.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import SwiftUI

final class SceneDelegate: UIResponder, UIWindowSceneDelegate {
    var window: UIWindow?
    func scene(
        _ scene: UIScene,
        willConnectTo session: UISceneSession,
        options connectionOptions: UIScene.ConnectionOptions
    ) {
        let githubListVC = Factories.current.viewControllerFactory.makeGithubListViewController()
        if let windowScene = scene as? UIWindowScene {
            let window = UIWindow(windowScene: windowScene)
            window.rootViewController = UINavigationController(rootViewController: githubListVC)
            self.window = window
            window.makeKeyAndVisible()
        }
    }
}
