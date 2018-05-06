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

        //primaryStage?.show()

        setting(primaryStage)
    }

    private fun setting(this_stage: Stage?) {

        Log.main("launch")
        var vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
        //check
        while (true) {
            if(vertical == 0) {
                vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
            } else break
        }
        var width = initialization("Please enter the number of width squares. (5 to 12)")

        //check
        while (true) {
            if(vertical == 0) {
                vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
            } else break
        }

        Mass_creation.create(vertical, width, this_stage)
    }

    //Display a dialog for generating a square.
    private fun initialization(content: String?): Int {

        var number = -1

        // Input dialog display
        var resultsquare = Dialog.InputDialog(null, "Create square", content)

        if (resultsquare == null) exitProcess(0) // End of program, No further processing is performed.

        try {
            number = resultsquare.toInt()

            if (!(number >= 5 && number <= 12)) {
                Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number between 5 and 13")
                number = 0
            }

        } catch (e: NumberFormatException) {
            Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number (5 to 12)")
            number = 0
        }

        if(Debug.developer) println(number)
        return number //number == 0, false
    }
}