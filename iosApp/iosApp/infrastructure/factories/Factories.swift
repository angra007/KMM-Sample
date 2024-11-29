//
//  Factories.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//
import Foundation
import shared

class Factories {
    
    let viewModel: ViewModelFactory
    let viewFactory: ViewFactory
    
    init( viewModelFactory: ViewModelFactory, viewFactory : ViewFactory) {
        self.viewModel = viewModelFactory
        self.viewFactory = viewFactory
    }
    
    static var current: Factories = {
        let viewModelFactory = ViewModelFactoryImpl(sharedViewModelProvider: SharedViewModelProvider.shared)
        let viewFactory = ViewFactoryImpl(viewModelFactory: viewModelFactory)
        return Factories(viewModelFactory: viewModelFactory, viewFactory: viewFactory)
    }()
    
}
