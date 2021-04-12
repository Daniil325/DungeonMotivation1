package com.example.dungeonmotivation
fun main(){
    var game = Game()
    var choice = readLine()!!.toString()
    var s = game.choose_motivation(choice)
    var t = s.entries
    for ((i, j) in t)
        println("Вы выбрали $i \n  Совет: $j!")
}

class Game{
    fun choose_motivation(choose: String): Map<String?, String?> {
        var motivation: String? = ""
        var advice: String? = ""
        var mp = mapOf(
            "Сдать ЕГЭ" to "СДАЙ ЕГЭ",
            "Cаморазвитие" to "САМОРАЗВИВАЙСЯ"
        )
        for(m in mp){
            if(choose == m.key){
                motivation = choose
            }
        }
        when (choose) {
            "Сдать ЕГЭ" -> {
                advice = mp.getValue(choose)
            }
            "Cаморазвитие" -> {
                advice = mp.getValue(choose)
            }
        }
        return mapOf(motivation to advice)
    }
}