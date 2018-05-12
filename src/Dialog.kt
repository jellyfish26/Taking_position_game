import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.TextInputDialog
import org.w3c.dom.Text
import java.util.*

object Dialog {

    // input dialog function
    fun InputDialog(header: String?, title: String?, Content: String?): String? {
        val inputdialog = TextInputDialog()
        inputdialog.headerText = header
        inputdialog.title = title
        inputdialog.contentText = Content
        var outputresult = inputdialog.showAndWait()
        var result: String? = null

        outputresult.ifPresent { result = inputdialog.result }

        return result
    }

    fun AlertDialog(type: Alert.AlertType, header: String?, title: String?, Content: String?): ButtonType? {
        val alertdialog = Alert(type)
        alertdialog.headerText = header
        alertdialog.title = title
        alertdialog.contentText = Content
        var alertresult = alertdialog.showAndWait()
        var result: ButtonType? = null

        alertresult.ifPresent { result = alertdialog.result }

        return result
    }
}