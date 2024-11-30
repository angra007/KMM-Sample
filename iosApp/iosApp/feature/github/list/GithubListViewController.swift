//
//  GithubListViewController.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-29.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit

class GithubListViewController: UIViewController, StoryboardInstantiable {
    
    static var storyboard: String = "GithubStoryboard"
    var viewModel: GithubListViewModel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print("Here")
    }
    
}
