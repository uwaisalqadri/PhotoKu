//
//  MainApp.swift
//  PhotoKu
//
//  Created by Uwais Alqadri on 7/12/23.
//  Copyright © 2023 DevFest. All rights reserved.
//

import SwiftUI
import Shared

@main
struct MainApp: App {
  
  init() {
    KoinApplication.start()
  }
  
  var body: some Scene {
    WindowGroup {
      PhotoView()
    }
  }
}
