//
//  Destinations.swift
//  iosApp
//
//  Created by Ankit Angra on 2024-11-28.
//  Copyright © 2024 orgName. All rights reserved.
//

enum Screen: Identifiable, Hashable {
    case githubList
    case githubDetails
    
    var id: String {
        switch self {
            case .githubList: return "githubList"
            case .githubDetails: return "githubDetails"
        }
    }
}
