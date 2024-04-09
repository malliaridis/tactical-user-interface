import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    var appComponent: AppComponent

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(appComponent: appComponent)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var appComponent: AppComponent

    var body: some View {
        ComposeView(appComponent: appComponent)
    }
}
