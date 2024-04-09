import androidx.compose.ui.window.ComposeUIViewController
import com.chipmunksmedia.helldivers.remote.App
import com.chipmunksmedia.helldivers.remote.domain.foundation.AppComponent

fun MainViewController(appComponent: AppComponent) = ComposeUIViewController {
    App(appComponent)
}
