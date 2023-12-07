//
//  KMMViewModel.swift
//  PhotoKu
//
//  Created by Uwais Alqadri on 7/12/23.
//  Copyright © 2023 DevFest. All rights reserved.
//

import Shared
import KMMViewModelCore

//extension Kmm_viewmodel_coreKMMViewModel: KMMViewModel { }

typealias KoinApplication = Koin_coreKoinApplication
typealias Koin = Koin_coreKoin

extension KoinApplication {
  static let shared = companion.start()

  @discardableResult
  static func start() -> KoinApplication {
    shared
  }
}
