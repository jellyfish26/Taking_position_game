import javafx.scene.control.Alert
import kotlin.system.exitProcess

object Set {
    open fun setting() {

        if(Debug.developer) println("Lunch App")
        Value.vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
        //check
        while (true) {
            if(Value.vertical == 0) {
                Value.vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
            } else break
        }
        Value.width = initialization("Please enter the number of width squares. (5 to 12)")

        //check
        while (true) {
            if(Value.width == 0) {
                Value.width = initialization("Please enter the number of width squares. (5 to 12)")
            } else break
        }

        Mass_creation.create(Value.vertical, Value.width)
    }

    //Display a dialog for generating a square.
    private fun initialization(content: String?): Int {

        var number = 0

        // Input dialog display
        var resultsquare = Dialog.InputDialog(null, "Create square", content)

        if (resultsquare == null) exitProcess(0) // End of program, No further processing is performed.

        try {
            number = resultsquare.toInt()

            if (!(number >= 5 && number <= 12)) {
                Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number between 5 and 12")
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