package com.brotandos.btm


data class Booking(
    val id: Int,
    val cityID: Int,
    val cityCode: Any,
    val hotelID: Int,
    val roomID: Int,
    val roomNum: Int,
    val paxNum: Int,
    val roomType: String,
    val startDate: String,
    val endDate: String,
    val Amount: Any,
    val NetAmount: String,
    val PenaltyRefundAmount: Any,
    val DaysForAutoCancel: Any,
    val Currency: String,
    val GUID: String,
    val ReservationIdContentinn: Any,
    val special_fare_id: Any,
    val room: Room,
    val hotel: Hotel,
    val bookingNumber: String
)

data class PrebookingDetails(
    val id: Int,
    val cityID: Int,
    val cityCode: Any,
    val hotelID: Int,
    val roomID: Int,
    val roomNum: Int,
    val paxNum: Int,
    val roomType: String,
    val startDate: String,
    val endDate: String,
    val Amount: Any,
    val NetAmount: String,
    val PenaltyRefundAmount: Any,
    val DaysForAutoCancel: Any,
    val Currency: String,
    val GUID: String,
    val ReservationIdContentinn: Any,
    val special_fare_id: Any,
    val room: Room,
    val hotel: Hotel,
    val services: Services,
    val rules: Rules,
    val images: List<Image>
)

data class Image(
    val id: Int,
    val imageName: String,
    val hotelID: Int,
    val roomID: Int
)

data class Hotel(
    val id: Int,
    val countryIso: String,
    val cityID: Int,
    val hotelID: Int,
    val hotelName: String,
    val stars: Int,
    val address: String,
    val telephone: String,
    val fax: String,
    val email: String,
    val latitude: String,
    val longitude: String,
    val lastUpdateDate: String,
    val accommodationType: String,
    val rating: String,
    val description: String,
    val link: Any
)

data class Rules(
    val id: Int,
    val hotelID: Int,
    val cancelPenalty: String,
    val extraBedAndChilds: String,
    val internet: String,
    val parking: String,
    val animals: String,
    val additionalServices: String,
    val earlyArrivalPercent: Int,
    val lateDeparturePercent: Int
)

data class Services(
    val id: Int,
    val hotelID: Int,
    val general: String,
    val facilities: String,
    val mealDrinks: String,
    val health: String,
    val transfer: String,
    val reception: String,
    val cleaning: String,
    val services: String,
    val other: String
)

data class Room(
    val id: Int,
    val Type: String,
    val TypeDescription: String,
    val Bedsnum: Int,
    val RoomDescription: String,
    val IsSpecialOffer: String,
    val RoomTypeId: Int,
    val NeedNationality: String,
    val Name: Any,
    val BoardBasisID: Int,
    val CancellationPolicyID: Int,
    val hotelID: Int,
    val accomodationTypeID: Int,
    val CheckInTime: String,
    val CheckOutTime: String
)