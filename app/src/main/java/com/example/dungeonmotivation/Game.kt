package com.example.dungeonmotivation

fun addition_isCorrect() {
    val game = Game()
    val choice = (readLine() ?: return).toString()
    val s = game.choose_motivation(choice)
    val t = s.entries
    for ((i, j) in t)
        print("Вы выбрали $i \n Совет: $j!")
}

class Game {
    fun choose_motivation(choose: String): Map<String?, String?> {
        var motivation: String? = ""
        var advice: String? = ""
        val mp = mapOf("Сдать ЕГЭ" to "СДАЙ ЕГЭ", "Свмоазвитие" to "САМОРАЗВИВАЙСЯ")
        for ((key) in mp) {
            if (choose == key) {
                motivation = choose
            }
        }
        when (choose) {
            "Сдать ЕГЭ" -> {
                advice = mp.getValue(choose)
            }
            "Саморазвитие" -> {
                advice = mp.getValue(choose)
            }
        }
        return mapOf(motivation to advice)
    }
}