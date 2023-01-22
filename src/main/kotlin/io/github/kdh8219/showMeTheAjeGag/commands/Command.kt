package io.github.kdh8219.showMeTheAjeGag.commands

import io.github.kdh8219.showMeTheAjeGag.Main
import io.github.kdh8219.showMeTheAjeGag.colorToColorCode
import io.github.kdh8219.showMeTheAjeGag.modules.Module
import com.lambda.client.command.ClientCommand
import com.lambda.client.util.text.MessageSendHelper


object Command : ClientCommand(
    name = "aje",
    description = "Show a random aje gag"
) {

    init {
        execute("Show a random aje gag") {
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
    }
}

