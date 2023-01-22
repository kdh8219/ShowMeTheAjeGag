package io.github.kdh8219.showMeTheAjeGag.modules

import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.TickTimer
import com.lambda.client.util.TimeUnit
import com.lambda.client.util.threads.safeListener
import io.github.kdh8219.showMeTheAjeGag.Main
import io.github.kdh8219.showMeTheAjeGag.Colors
import io.github.kdh8219.showMeTheAjeGag.sendRandomMessage
import net.minecraftforge.fml.common.gameevent.TickEvent

internal object Module : PluginModule(
    name = "ShowMeTheAjeGag",
    category = Category.MISC,
    description = "Show a random aje gag",
    pluginMain = Main
) {
    val questionColor by setting("Question Color", Colors.Gray)
    val answerColor by setting("Answer Color", Colors.Gray)
    private val autoUseDelay by setting("Auto Use Delay(s)",10, 1..600, 1)

    private val timer = TickTimer(TimeUnit.SECONDS)

    init {
        safeListener<TickEvent.ClientTickEvent> {
            if (it.phase != TickEvent.Phase.START || !timer.tick(autoUseDelay.toLong())){return@safeListener}
            sendRandomMessage()
        }
    }
}