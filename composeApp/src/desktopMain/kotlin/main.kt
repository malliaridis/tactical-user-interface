import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.chipmunksmedia.helldivers.remote.ui.App

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Helldivers Remote") {
        App()
    }
}
