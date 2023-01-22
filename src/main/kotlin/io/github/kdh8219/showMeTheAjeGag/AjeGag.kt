package io.github.kdh8219.showMeTheAjeGag

import com.lambda.client.util.text.MessageSendHelper
import io.github.kdh8219.showMeTheAjeGag.modules.Module
import java.io.IOException
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*

class AjeGag(val quiz: String, val answer: Array<String>)
class AjeGags(private val problems:Array<AjeGag>) {
    fun getRandom(): AjeGag {
        val rnd: Int = Random().nextInt(this.problems.size)
        return this.problems[rnd]
    }
}

@Throws(IOException::class)
fun readStringFromURL(requestURL: String?): String? {
    Scanner(
        URL(requestURL).openStream(),
        StandardCharsets.UTF_8.toString()
    ).use { scanner ->
        scanner.useDelimiter("\\A")
        return if (scanner.hasNext()) scanner.next() else ""
    }
}
fun sendRandomMessage(){
    val quizzes = Main.quizzes
    val prefix = Main.prefix
    val questionColor = colorToColorCode(Module.questionColor)
    val answerColor = colorToColorCode(Module.answerColor)
    if(quizzes != null){
        val quiz =quizzes.getRandom()
        MessageSendHelper.sendChatMessage("$prefix ${questionColor}${quiz.quiz} ${answerColor}${quiz.answer[0]}")
    } else {
        MessageSendHelper.sendErrorMessage("$prefix quizzes is null: something wrong")
    }
}