import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.stage.Stage
import kotlin.system.exitProcess

//gui class
class App : Application() {

    //start GUI
    override fun start(primaryStage: Stage?) {
        //title
        primaryStage?.title = "Taking position game"

        //scene (deleted)
        //primaryStage?.scene = Scene(FXMLLoader.load<Parent>(this.javaClass.getResource("App.fxml")))

        //show gui
        primaryStage?.show()

        Log.main("launch")
        initialization()
    }

    //Display a dialog for generating a square.
    private fun initialization() {
        var create_square = TextInputDialog()
        create_square.headerText = null
        create_square.title = "Crate square"
        create_square.contentText = "Please enter the size of the square to be generated."

        var result_square = create_square.showAndWait()
        var square: String? = null.toString()
        result_square.ifPresent { square = create_square.result }

        // judge alert
        if (square == "") {
            var alert_dialog = Alert(Alert.AlertType.CONFIRMATION)
            alert_dialog.headerText = null
            alert_dialog.title = "Warning"
            alert_dialog.contentText = "Please enter a number (5 to 13)"

            var alert_result = alert_dialog.showAndWait()
            if (alert_result.get() == ButtonType.OK) {
                // return
                initialization()
            } else {
                exitProcess(0)
            }
        } else {
            Log.main("make_square")
        }
    }
}