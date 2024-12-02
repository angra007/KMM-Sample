//
//  GithubDetailViewController.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-12-02.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import RxSwift
import RxCocoa
import SDWebImage

class GithubDetailViewController: UIViewController, StoryboardInstantiable {
    
    static var storyboard: String = "GithubStoryboard"
    var viewmodel: GithubDetailViewModel!
    var name: String! = ""
    
    @IBOutlet weak var loadingIndicator: UIActivityIndicatorView!
    
    @IBOutlet weak var numberOfRepositoryLabel: UILabel!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var profileImageView: UIImageView!
    
    private var disposeBag: DisposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationItem.title = name
        
        viewmodel.subject
            .subscribe(
                onNext: { [weak self] state in
                    self?.setupUI(state: state)
                }
            )
            .disposed(by: disposeBag)
        
        viewmodel.observe()
        viewmodel.getGithubUser(user: name)
        
    }
    
    private func setupUI(state: GithubDetailViewState) {
       
        if (state.isLoading) {
            loadingIndicator.startAnimating()
        } else {
            loadingIndicator.stopAnimating()
        }
        
        profileImageView.sd_setImage(with: URL.init(string: state.user?.profileImage ?? ""))
        nameLabel.text = state.user?.name
        numberOfRepositoryLabel.text = String("\(state.user?.numberOfRepos ?? 0) Repositories")
        
    }
    
    
}
