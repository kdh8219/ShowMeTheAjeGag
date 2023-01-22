package io.github.kdh8219.showMeTheAjeGag

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