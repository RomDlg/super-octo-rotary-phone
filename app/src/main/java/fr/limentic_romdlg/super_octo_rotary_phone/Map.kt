package fr.limentic_romdlg.super_octo_rotary_phone

class Map(val name: String,
          var latitude: Double,
          var longitude: Double,
          var type: PointType)
{
}

enum class PointType() {
    TARGET, CHECKPOINT, ATTACK, BONUS
}