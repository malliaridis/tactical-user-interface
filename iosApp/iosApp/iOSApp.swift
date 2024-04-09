import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate

	var body: some Scene {
		WindowGroup {
			ComposeView(appComponent: appDelegate.appComponent)
                .ignoresSafeArea() // Compose has own keyboard handler
		}
	}
}

class AppDelegate: NSObject, UIApplicationDelegate {
    let appComponent: AppComponent = DefaultAppComponent(
        componentContext: DefaultAppComponentContext(
            componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
        ),
        storeFactory: DefaultStoreFactory()
    )
}
