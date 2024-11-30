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
    
    @Published
    var state: GithubListSharedViewState = GithubListSharedViewState.companion.initial()
    
    private var disposableHandle : DisposableHandle?
    
    init(sharedViewModel: GithubListSharedViewModel) {
        self.sharedViewModel = sharedViewModel
    }
    
    func observe() {
        self.disposableHandle = sharedViewModel.state.subscribe(onCollect: { newState in
            print("New State")
            print(newState)
        })
    }
    
    func helloWorld() {
        sharedViewModel.getGithubList()
    }
    
}
