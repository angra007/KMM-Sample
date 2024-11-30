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
    let viewControllerFactory: ViewControllerFactory
    
    init( viewModelFactory: ViewModelFactory, viewControllerFactory : ViewControllerFactory) {
        self.viewModel = viewModelFactory
        self.viewControllerFactory = viewControllerFactory
    }
    
    static var current: Factories = {
        let viewModelFactory = ViewModelFactoryImpl(sharedViewModelProvider: SharedViewModelProvider.shared)
        let viewControllerFactory = ViewControllerFactoryImpl(viewModelFactory: viewModelFactory)
        return Factories(viewModelFactory: viewModelFactory, viewControllerFactory: viewControllerFactory)
    }()
    
}
