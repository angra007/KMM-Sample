//
//  GithubListViewModel.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared


class GithubListViewModel: ObservableObject {
    
    private let sharedViewModel: GithubListSharedViewModel
    
    init(sharedViewModel: GithubListSharedViewModel) {
        self.sharedViewModel = sharedViewModel
    }
    
    func helloWorld() {
        sharedViewModel.helloWorld()
    }
    
}
