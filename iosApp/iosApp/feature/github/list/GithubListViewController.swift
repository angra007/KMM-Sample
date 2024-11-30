//
//  GithubListViewController.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-29.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import RxSwift

class GithubListViewController: UIViewController, StoryboardInstantiable {
    
    static var storyboard: String = "GithubStoryboard"
    var viewModel: GithubListViewModel!
    
    private var disposeBag: DisposeBag = DisposeBag()
    
    @IBOutlet weak var loadingIndicator: UIActivityIndicatorView!
    
    @IBAction func didTapOnObserveButton(_ sender: UIButton) {
        viewModel.helloWorld()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
             
        viewModel.subject
            .subscribe(
                onNext: { event in
                    self.setupUI(state: event)
                }
            )
            .disposed(by: disposeBag)
        
        viewModel.observe()

    }
    
    private func setupUI(state: GithubListViewState) {
        if (state.isLoading) {
            loadingIndicator.startAnimating()
        } else {
            loadingIndicator.stopAnimating()
        }
    }
    
}
