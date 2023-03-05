fun main() {
    // Generate random 4-digit number without repeating digits
    val randomList = mutableListOf<Int>()
    while (randomList.size < 4) {
        val num = (1..9).random()
        if (!randomList.contains(num)) {
            randomList.add(num)
        }
    }
    val randomNum = randomList.joinToString(separator = "")
    println("A random 4-digit number without repeating digits has been generated.")

    // Play game
    var guess = ""
    var isGameOver = false
    while (!isGameOver) {
        while (guess.length != 4) {
            print("Guess the 4-digit number without repeating digits: ")
            guess = readLine() ?: ""
        }

        var n = 0
        var m = 0
        for (i in 0..3) {
            val num = guess[i].toString()
            if (num in randomNum) {
                n++
            }
            if (num == randomNum[i].toString()) {
                m++
            }
        }

        println("$n:$m")

        if (m == 4) {
            isGameOver = true
            println("Congratulations, you guessed the correct number!")
        } else {
            guess = ""
        }
    }
}
