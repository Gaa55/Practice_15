package com.example.mypractice_15

import android.os.Parcel
import android.os.Parcelable

class Pet():Parcelable {
    private var breed:String=""
    private  var year:Int=1993
    private var month:Int=1

    constructor(parcel: Parcel) : this() {
        breed = parcel.readString().toString()
        year = parcel.readInt()
        month = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel?.writeString(breed)
        parcel?.writeInt(year)
        parcel?.writeInt(month)
    }

    constructor(_breed:String, _year:Int, _month:Int) : this(){
        breed = _breed
        year = _year
        month = _month
    }

    fun getBreed() : String{
        return breed
    }
    fun getYear() : Int{
        return year
    }

    fun getMonth() : Int{
        return month
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }
}