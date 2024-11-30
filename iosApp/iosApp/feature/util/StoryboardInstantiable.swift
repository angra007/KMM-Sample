//
//  StoryboardInstantiable.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-29.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit

protocol StoryboardInstantiable: NSObjectProtocol {
    associatedtype ViewController
    static var storyboardIdentifier: String { get }
    static var storyboard: String { get }
    static func instantiateViewController(_ bundle: Bundle?) -> ViewController
}

extension StoryboardInstantiable where Self: UIViewController {
    static var storyboardIdentifier: String {
        return NSStringFromClass(Self.self).components(separatedBy: ".").last!
    }

    static func instantiateViewController(_ bundle: Bundle? = nil) -> Self {
        let fileName = storyboard
        let storyboard = UIStoryboard(name: fileName, bundle: bundle)
        guard let vc = storyboard.instantiateViewController(withIdentifier: storyboardIdentifier) as? Self else {
            fatalError("Cannot instantiate initial view controller \(Self.self) from storyboard with name \(fileName)")
        }
        return vc
    }
}
