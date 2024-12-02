//
//  ViewControllerFactory.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-30.
//  Copyright © 2024 orgName. All rights reserved.
//

protocol ViewControllerFactory {
    func makeGithubListViewController() -> GithubListViewController
    func makeGithubDetailViewController(name: String) -> GithubDetailViewController
}

class ViewControllerFactoryImpl: ViewControllerFactory {
    
    private let viewModelFactory: ViewModelFactory
    
    init(viewModelFactory: ViewModelFactory) {
        self.viewModelFactory = viewModelFactory
    }
    
    func makeGithubListViewController() -> GithubListViewController {
        let githubListVC = GithubListViewController.instantiateViewController()
        let githubViewModel = viewModelFactory.makeGithubListViewModel()
        githubListVC.viewModel = githubViewModel
        return githubListVC
    }
    
    func makeGithubDetailViewController(name: String) -> GithubDetailViewController {
        let githubDetailVC = GithubDetailViewController.instantiateViewController()
        let githubDetailViewModel = viewModelFactory.makeGithubDetailViewModel()
        githubDetailVC.viewmodel = githubDetailViewModel
        githubDetailVC.name = name
        return githubDetailVC
    }
}
