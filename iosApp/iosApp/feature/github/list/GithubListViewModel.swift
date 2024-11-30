//
//  GithubListViewModel.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import RxSwift
import RxRelay

class GithubListViewModel {
    
    private let sharedViewModel: GithubListSharedViewModel
        
    private var coroutineDisposableHandle : DisposableHandle?
        
    var subject: BehaviorRelay<GithubListViewState> = .init(value: GithubListViewState.init(isLoading: false))
    
    init(sharedViewModel: GithubListSharedViewModel) {
        self.sharedViewModel = sharedViewModel
    }
    
    func observe() {
        self.coroutineDisposableHandle = self.sharedViewModel.state.subscribe(onCollect: { newState in
            guard let state = newState else { return }            
            self.subject.accept(GithubListViewState(isLoading: state.isLoading))
        })
    }
    
    deinit {
        coroutineDisposableHandle?.dispose()
    }
    
    func helloWorld() {
        sharedViewModel.getGithubList()
    }
}

struct GithubListViewState {
    let isLoading: Bool
}
