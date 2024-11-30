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
    
    @IBAction func didTapOnObserveButton(_ sender: UIButton) {
        viewModel.helloWorld()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
             
        viewModel.testRx?
            .subscribe(
                onNext: { event in
                    print(event)
                },
                onError: { _ in
                    
                },
                onCompleted: {
                    
                }
            )
            .disposed(by: disposeBag)
        
        viewModel.observe()

    }
    
}
