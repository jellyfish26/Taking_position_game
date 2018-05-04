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
        // Input dialog display
        var result_square = Dialog.InputDialog(null, "Create square", "Please enter the size of the square to be generated.(5 to 12)")

        if (result_square == null) exitProcess(0) // End of program

        // judge alert
        if (result_square == "") {
            //warning dialog display
            var warning = Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number (5 to 12)")

            if (warning == ButtonType.OK) {
                // return
                initialization()
            } else {
                exitProcess(0)
            }
        } else {
            var number: Int? = 0
            try {
                number = result_square?.toInt()
            } catch (e: NumberFormatException) {
                var number_warning = Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number (5 to 12)")

                if (number_warning == ButtonType.OK) {
                    // return
                    initialization()
                } else {
                    exitProcess(0)
                }
            }

            if (!(number!! >= 5 && number!! <= 12)) {
                var out_range = Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number between 5 and 13")

                if (out_range == ButtonType.OK) {
                    // return
                    initialization()
                } else {
                    exitProcess(0)
                }
            }
        }
    }
}