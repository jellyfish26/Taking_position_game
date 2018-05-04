import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.TextInputDialog
import org.w3c.dom.Text
import java.util.*

object Dialog {

    // input dialog function
    fun InputDialog(header: String?, title: String?, Content: String?): String? {
        val input_dialog = TextInputDialog()
        input_dialog.headerText = header
        input_dialog.title = title
        input_dialog.contentText = Content
        var output_result = input_dialog.showAndWait()
        var result: String? = null

        output_result.ifPresent { result = input_dialog.result }

        return result
    }

    fun AlertDialog(type: Alert.AlertType, header: String?, title: String?, Content: String?): ButtonType? {
        val alert_dialog = Alert(type)
        alert_dialog.headerText = header
        alert_dialog.title = title
        alert_dialog.contentText = Content
        var alert_result = alert_dialog.showAndWait()
        var result: ButtonType? = null

        alert_result.ifPresent { result = alert_dialog.result }

        return result
    }
}