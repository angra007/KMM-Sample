//
//  ViewFactory.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

protocol ViewFactory {
    
    @ViewBuilder
    func build(screen: Screen) -> AnyView
    
}

class ViewFactoryImpl: ViewFactory {
    
    let viewModelFactory: ViewModelFactory

    init(viewModelFactory: ViewModelFactory) {
        self.viewModelFactory = viewModelFactory
    }
    
    func build(screen: Screen) -> AnyView {
        switch screen {
            case .githubList:
                return AnyView(GithubListScreen(githubListViewModel: self.viewModelFactory.makeGithubListViewModel()))
            case .githubDetails:
                return AnyView(GithubDetailScreen(githubDetailViewModel: self.viewModelFactory.makeGithubDetailViewModel()))
        }
    }
}
