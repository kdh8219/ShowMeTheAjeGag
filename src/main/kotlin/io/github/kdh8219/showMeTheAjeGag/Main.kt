package io.github.kdh8219.showMeTheAjeGag

import com.google.gson.Gson
import com.lambda.client.plugin.api.Plugin
import io.github.kdh8219.showMeTheAjeGag.commands.Command
import io.github.kdh8219.showMeTheAjeGag.modules.Module
internal object Main : Plugin() {
    private val gson = Gson()
    const val prefix = "[아재개그]"
    var quizzes: AjeGags? = null
    override fun onLoad() {
         quizzes = gson.fromJson(
            readStringFromURL("https://raw.githubusercontent.com/Team-WAVE-x/Stop-uncle/master/src/ajegag.json").toString(),
            AjeGags::class.java)
        commands.add(Command)
        modules.add(Module)
    }
}