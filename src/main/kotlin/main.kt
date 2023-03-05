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

    var guess = ""
    var guessRight = false
    while (!guessRight) {
        while (guess.length != 4) {
            print("Guess the 4-digit number without repeating digits: ")
            guess = readLine() ?: ""
        }

        var n = 0
        var m = 0
        for (i in 0..3) {
            val num = guess[i].toString()
            if (num in randomNum) {
                n += 1
            }
            if (num == randomNum[i].toString()) {
                m += 1
            }
        }

        println("Output $n : $m ")

        if (m == 4) {
            guessRight = true
            println("Congratulations, you guessed the correct number!")
        } else {
            guess = ""
        }
    }
}