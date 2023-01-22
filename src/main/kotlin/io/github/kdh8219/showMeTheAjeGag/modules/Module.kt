package io.github.kdh8219.showMeTheAjeGag.modules

import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import io.github.kdh8219.showMeTheAjeGag.Main
import io.github.kdh8219.showMeTheAjeGag.Colors

internal object Module : PluginModule(
    name = "ShowMeTheAjeGag",
    category = Category.MISC,
    description = "Show a random aje gag",
    pluginMain = Main
) {
    val questionColor by setting("Question Color", Colors.Gray)
    val answerColor by setting("Answer Color", Colors.Gray)
}