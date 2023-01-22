package io.github.kdh8219.showMeTheAjeGag.commands

import io.github.kdh8219.showMeTheAjeGag.sendRandomMessage
import com.lambda.client.command.ClientCommand


object Command : ClientCommand(
    name = "aje",
    description = "Show a random aje gag"
) {
    init {
        execute("Show a random aje gag") {
            sendRandomMessage()
        }
    }
}

