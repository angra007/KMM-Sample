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
    @IBOutlet weak var searchResultTableView: UITableView! {
        didSet {
            searchResultTableView.dataSource = self
            searchResultTableView.delegate = self
            searchResultTableView.register(UITableViewCell.self, forCellReuseIdentifier: "SearchResultCell")
        }
    }
    
    @IBOutlet weak var searchBarTextField: UISearchBar!

    private var searchResults: [GithubSearchResult] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        searchBarTextField.delegate = self
        setupBindings()
        viewModel.observe()
    }
    
    private func setupUI(state: GithubListViewState) {
        if (state.isLoading) {
            loadingIndicator.startAnimating()
        } else {
            loadingIndicator.stopAnimating()
        }

        searchResults = state.results
        searchResultTableView.reloadData()
    }
    
    private func setupBindings() {
        
        searchBarTextField.rx.text.orEmpty
            .distinctUntilChanged()
            .debounce(.milliseconds(300), scheduler: MainScheduler.instance)
            .filter { $0.count >= 3 }
            .subscribe(onNext: { [weak self] query in
                self?.viewModel.search(query: query)
            })
            .disposed(by: disposeBag)
            
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

extension GithubListViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let result = searchResults[indexPath.row]
        let vc = Factories.current.viewControllerFactory.makeGithubDetailViewController(name: result.name)
        self.navigationController?.pushViewController(vc, animated: true)
    }
}
