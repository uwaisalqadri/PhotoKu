//
//  PhotoRow.swift
//  PhotoKu
//
//  Created by Uwais Alqadri on 7/12/23.
//  Copyright © 2023 DevFest. All rights reserved.
//

import SwiftUI
import SDWebImageSwiftUI
import Shared

struct PhotoRow: View {
  
  let photo: Photo
  
  var body: some View {
    WebImage(url: URL(string: photo.imageUrl))
      .resizable()
      .scaledToFill()
      .frame(maxWidth: .infinity, maxHeight: 200)
      .cornerRadius(10)
      .padding(.horizontal, 16)
      .padding(.vertical, 6)
  }
}
