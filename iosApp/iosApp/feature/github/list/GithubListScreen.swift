//
//  GithubListScreen.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct GithubListScreen: View {

    @StateObject var githubListViewModel: GithubListViewModel
    
    var body: some View {
        VStack(spacing: 20) {
            Button(action: githubListViewModel.helloWorld) {
                HStack{
                    Text("Continue")
                }
                .foregroundColor(.white)
                .frame(maxWidth: .infinity)
                .padding()
                .background(Color.red)
                .cornerRadius(8)
            }
            .padding(.horizontal)
        }
        .task {
            githubListViewModel.observe()
        }
    }
}
