import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.stage.Stage
import java.util.*
import kotlin.system.exitProcess

//gui class
class App : Application() {

    //start GUI
    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "Taking position game"

        //scene (deleted)
        //primaryStage?.scene = Scene(FXMLLoader.load<Parent>(this.javaClass.getResource("App.fxml")))

        primaryStage?.show()

        Log.main("launch")
        var vertical = initialization(primaryStage,"Please enter the number of vertical squares. (5 to 12)")
        var width = initialization(primaryStage, "Please enter the number of width squares. (5 to 12)")

        Mass_creation.create(vertical, width, primaryStage)
    }

    //Display a dialog for generating a square.
    private fun initialization(this_stage: Stage?, content: String?): Int {
        // Input dialog display
        var resultsquare = Dialog.InputDialog(null, "Create square", content)

        var number = 0

        if (resultsquare == null) exitProcess(0) // End of program, No further processing is performed.

        // judge alerthorizontal
        if (resultsquare == "") {
            //warning dialog display
            var warning = Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number (5 to 12)")

            if (warning == ButtonType.OK) {
                // return
                initialization(this_stage, content)
            } else {
                Platform.exit()
            }
        } else {

            try {
                number = resultsquare.toInt()
            } catch (e: NumberFormatException) {
                var numberwarning = Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number (5 to 12)")

                if (numberwarning == ButtonType.OK) {
                    // return
                    initialization(this_stage, content)
                } else {
                    Platform.exit()
                }
            }

            if (!(number >= 5 && number <= 12)) {
                var outrange = Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number between 5 and 13")

                if (outrange == ButtonType.OK) {
                    // return
                    initialization(this_stage, content)
                } else {
                    Platform.exit()
                }
            }
        }

        return number
    }
}