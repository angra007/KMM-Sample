//
//  GithubListViewController.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-29.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import RxSwift
import RxCocoa

class GithubListViewController: UIViewController, StoryboardInstantiable, UISearchBarDelegate {
    
    static var storyboard: String = "GithubStoryboard"
    var viewModel: GithubListViewModel!
    
    private var disposeBag: DisposeBag = DisposeBag()
    
    @IBOutlet weak var loadingIndicator: UIActivityIndicatorView!
    
    @IBOutlet weak var searchResultTableView: UITableView!
    @IBOutlet weak var searchBarTextField: UISearchBar!

    private var searchResults: [GithubSearchResult] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        searchBarTextField.delegate = self
        setupBindings()
        setupTableView()
        viewModel.observe()
    }
    
    private func setupUI(state: GithubListViewState) {
        if (state.isLoading) {
            loadingIndicator.startAnimating()
        } else {
            loadingIndicator.stopAnimating()
        }

        state.results.forEach { result in
            print("Found Result:")
            print(result.name)
        }
        
        // Update search results and reload the table view
        searchResults = state.results
        searchResultTableView.reloadData()
    }
    
    private func setupTableView() {
        searchResultTableView.dataSource = self
        searchResultTableView.register(UITableViewCell.self, forCellReuseIdentifier: "SearchResultCell")
    }
    
    private func setupBindings() {
        // Bind search bar text changes to the ViewModel
        searchBarTextField.rx.text.orEmpty
            .distinctUntilChanged() // Only emit distinct changes
            .debounce(.milliseconds(300), scheduler: MainScheduler.instance) // Delay for 300ms to avoid rapid calls
            .filter { $0.count >= 3 } // Only trigger for input with 3 or more characters
            .subscribe(onNext: { [weak self] query in
                self?.viewModel.search(query: query)
            })
            .disposed(by: disposeBag)
            
            // Subscribe to the ViewModel's subject to update UI
        viewModel.subject
            .subscribe(
                onNext: { [weak self] state in
                        self?.setupUI(state: state)
                }
            )
            .disposed(by: disposeBag)
    }
    
}

extension GithubListViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return searchResults.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "SearchResultCell", for: indexPath)
        let result = searchResults[indexPath.row]
        cell.textLabel?.text = result.name
        return cell
    }
}
