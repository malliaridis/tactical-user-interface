import androidx.compose.ui.window.ComposeUIViewController
import com.malliaridis.tui.App
import com.malliaridis.tui.domain.foundation.AppComponent

fun MainViewController(appComponent: AppComponent) = ComposeUIViewController {
    App(appComponent)
}
