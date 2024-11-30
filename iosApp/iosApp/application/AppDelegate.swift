import Foundation
import shared
import UIKit

@UIApplicationMain
class AppDelegate: UIResponder,  UIApplicationDelegate, UNUserNotificationCenterDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        startKoin()
        LoggerInitilizerKt.initializeLogger()
        return true
    }

}
