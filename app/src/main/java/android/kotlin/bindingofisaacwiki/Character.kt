package android.kotlin.bindingofisaacwiki

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Character(
    var name: String = "",
    var damage: Float,
    var tears: Int,
    var shotSpeed: Int,
    var range: Float,
    var speed: Float,
    var luck: Int,
    var startingItem: String,
    var icon: Int,
    var heartNumber: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(damage)
        parcel.writeInt(tears)
        parcel.writeInt(shotSpeed)
        parcel.writeFloat(range)
        parcel.writeFloat(speed)
        parcel.writeInt(luck)
        parcel.writeString(startingItem)
        parcel.writeInt(icon)
        parcel.writeInt(heartNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}