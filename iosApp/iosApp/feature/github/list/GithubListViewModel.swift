//
//  GithubListViewModel.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import RxSwift

class GithubListViewModel {
    
    private let sharedViewModel: GithubListSharedViewModel
        
    private var coroutineDisposableHandle : DisposableHandle?
    
    var testRx: Observable<String>? = nil
    
    init(sharedViewModel: GithubListSharedViewModel) {
        self.sharedViewModel = sharedViewModel
    }
    
    func observe() {
        
        self.coroutineDisposableHandle = self.sharedViewModel.state.subscribe(onCollect: { newState in
            print(newState)
        })
        
        testRx = Observable<String>.create { observer in
            observer.onNext("Hello From Event")
            observer.onNext("Hello Again Event")
            observer.onCompleted()
            return Disposables.create()
        }
    }
    
    deinit {
        coroutineDisposableHandle?.dispose()
    }
    
    func helloWorld() {
        sharedViewModel.getGithubList()
    }
    
}
