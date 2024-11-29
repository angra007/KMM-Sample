//
//  Content.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ContentView: View {

    private let viewFactory = Factories.current.viewFactory
    
    var body: some View {
        viewFactory.build(screen: .githubList)
    }
}
