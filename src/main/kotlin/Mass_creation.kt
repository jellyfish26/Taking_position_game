import Value.point
import java.util.*

object Mass_creation {
    fun create(vertical: Int, width: Int) {
        random(vertical, width)
    }

    //random number
    fun random(vertical: Int, width: Int) {
        for(ver_length in 0..((vertical / 2))) {
            for(wid_length in 0..((width / 2))) {
                //point[ver_length][wid_length] = Random().nextInt(32) - 16
                point[ver_length][wid_length] = Random_number_generation()

                // Line symmetry
                point[vertical - ver_length - 1][width - wid_length - 1] = point[ver_length][wid_length]
                point[vertical - ver_length - 1][wid_length] = point[ver_length][wid_length]
                point[ver_length][width - wid_length - 1] = point[ver_length][wid_length]
            }
        }

        // debug
        if(Debug.developer) {
            for(ver_length in 0..(vertical - 1)) {
                for(wid_length in 0..(width - 1)) {
                    print(point[ver_length][wid_length].toString() + " ")
                }
                println()
            }
        }
    }

    fun Random_number_generation() : Int{
        var multiplied = Random().nextInt(6) - 1
        if(multiplied >= 0) {
            multiplied = 1
        }
        var return_number = Random().nextInt(16) * multiplied

        return return_number
    }
}