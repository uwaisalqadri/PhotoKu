//
//  PhotoView.swift
//  PhotoKu
//
//  Created by Uwais Alqadri on 7/12/23.
//  Copyright © 2023 DevFest. All rights reserved.
//

import SwiftUI
import Shared
import KMMViewModelSwiftUI

struct PhotoView: View {

  var body: some View {
    Text("Hello, " + Platform_iosKt.getPlatform().appPlatform)
  }
}

struct ContentView_Previews: PreviewProvider {
  static var previews: some View {
    PhotoView()
  }
}
