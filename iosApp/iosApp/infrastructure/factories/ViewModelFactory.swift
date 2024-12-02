//
//  Untitled.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

protocol ViewModelFactory {
    func makeGithubListViewModel() -> GithubListViewModel
    func makeGithubDetailViewModel() -> GithubDetailViewModel
}

class ViewModelFactoryImpl: ViewModelFactory {
    
    let sharedViewModelProvider : SharedViewModelProvider
    
    init(sharedViewModelProvider: SharedViewModelProvider) {
        self.sharedViewModelProvider = sharedViewModelProvider
    }
    
    func makeGithubListViewModel() -> GithubListViewModel {
        return GithubListViewModel(sharedViewModel: sharedViewModelProvider.getGithubListSharedViewModel())
    }
    
    func makeGithubDetailViewModel() -> GithubDetailViewModel {
        return GithubDetailViewModel(sharedViewModel: sharedViewModelProvider.getGithubListSharedViewModel())
    }
}
