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
        
    var subject: BehaviorRelay<GithubListViewState> = .init(value: GithubListViewState.init(isLoading: false, errorMessage : nil, results: []))
    
    init(sharedViewModel: GithubListSharedViewModel) {
        self.sharedViewModel = sharedViewModel
    }
    
    func observe() {
        self.coroutineDisposableHandle = self.sharedViewModel.state.subscribe(onCollect: { newState in
            guard let state = newState else { return }
            
            let results = state.searchList.map { searchResult in
                GithubSearchResult.init(
                    profileUrl: searchResult.profileImage,
                    name: searchResult.name
                )
            }
            
            self.subject.accept(
                GithubListViewState(
                    isLoading: state.isLoading,
                    errorMessage: state.errorMessage,
                    results: results
                )
            )
        })
    }
    
    deinit {
        coroutineDisposableHandle?.dispose()
    }
    
    func search(query: String) {
        sharedViewModel.searchUser(query: query)
    }
}

struct GithubListViewState {
    let isLoading: Bool
    let errorMessage: String?
    let results: [GithubSearchResult]
}

struct GithubSearchResult {
    let profileUrl: String
    let name: String
}
