package io.github.kdh8219.showMeTheAjeGag

import com.google.gson.Gson
import com.lambda.client.plugin.api.Plugin
import io.github.kdh8219.showMeTheAjeGag.commands.Command
import io.github.kdh8219.showMeTheAjeGag.modules.Module
import java.io.IOException
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*

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
enum class Colors{
    Black, DarkBlue, DarkGreen, DarkAqua, DarkRed, DarkPurple, Gold, Gray, DarkGray, Blue, Green, Aqua, Red, LightPurple, Yellow, White
}

fun colorToColorCode(color:Colors):String{
    return(when(color){
        Colors.Black->"&0"
        Colors.DarkBlue->"&1"
        Colors.DarkGreen->"&2"
        Colors.DarkAqua->"&3"
        Colors.DarkRed->"&4"
        Colors.DarkPurple->"&5"
        Colors.Gold->"&6"
        Colors.Gray->"&7"
        Colors.DarkGray->"&8"
        Colors.Blue->"&9"
        Colors.Green->"&a"
        Colors.Aqua->"&b"
        Colors.Red->"&c"
        Colors.LightPurple->"&d"
        Colors.Yellow->"&e"
        Colors.White->"&f"
    })
}