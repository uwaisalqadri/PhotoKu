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

  @StateViewModel private var viewModel = PhotoViewModel()
  
  private var viewState: PhotoState {
    viewModel.state
  }

  var body: some View {
    NavigationView {
      ScrollView {
        VStack {
          if !viewState.errorMessage.isEmpty {
            Text(viewState.errorMessage)
          } else {
            ForEach(Array(viewState.photos.enumerated()), id: \.offset) { _, photo in
              PhotoRow(photo: photo)
            }
          }
        }
      }.navigationBarTitle("Photo")
    }.onAppear {
      viewModel.onTriggerEvent(event: PhotoEvent.GetPhotos())
    }
  }
}

struct ContentView_Previews: PreviewProvider {
  static var previews: some View {
    PhotoView()
  }
}
