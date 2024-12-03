//
//  GithubDetailViewModel.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-12-02.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import shared
import RxSwift
import RxRelay

class GithubDetailViewModel {
    
    private let sharedViewModel: GithubDetailSharedViewModel
    private var coroutineDisposableHandle : DisposableHandle?
    
    var subject: BehaviorRelay<GithubDetailViewState> = .init(value: GithubDetailViewState.init(isLoading: false, errorMessage : nil, user: nil))

    init(sharedViewModel: GithubDetailSharedViewModel) {
        self.sharedViewModel = sharedViewModel
    }
    
    func getGithubUser(user: String) {
        sharedViewModel.getGithubUser(name: user)
    }
    
    func observe() {
        self.coroutineDisposableHandle = self.sharedViewModel.state.subscribe(onCollect: { newState in
            guard let state = newState else { return }
        
            self.subject.accept(
                GithubDetailViewState(
                    isLoading: state.isLoading,
                    errorMessage: state.errorMessage,
                    user: GithubUser(
                        name: state.githubUser?.name ?? "",
                        profileImage: state.githubUser?.profileImage ?? "",
                        numberOfRepos: Int(state.githubUser?.numberOfRepo ?? 0)
                    )
                )
            )
        })
    }
}

struct GithubDetailViewState {
    let isLoading: Bool
    let errorMessage: String?
    let user: GithubUser?
}

struct GithubUser {
    let name: String
    let profileImage: String
    let numberOfRepos: Int
}
