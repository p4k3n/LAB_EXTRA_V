package com.example.uiexamples

import java.io.Serializable

class JobForm : Serializable {
    var firstName: String? = null
    var lastName: String? = null
    var streetAddress: String? = null
    var streetAddressLineTwo: String? = null
    var city: String? = null
    var state: String? = null
    var postal: String? = null
    var country: String? = null
    var email: String? = null
    var areaCode: String? = null
    var phoneNumber: String? = null
    var position: String? = null
    var date: String? = null
    constructor(
        firstName: String?,
        lastName: String?,
        streetAddress: String?,
        streetAddressLineTwo: String?,
        city: String?,
        state: String?,
        postal: String?,
        country: String?,
        email: String?,
        areaCode: String?,
        phoneNumber: String?,
        position: String?,
        date: String?
    ) {
        this.firstName = firstName
        this.lastName = lastName
        this.streetAddress = streetAddress
        this.streetAddressLineTwo = streetAddressLineTwo
        this.city = city
        this.state = state
        this.postal = postal
        this.country = country
        this.email = email
        this.areaCode = areaCode
        this.phoneNumber = phoneNumber
        this.position = position
        this.date = date
    }

    constructor() {
        this.firstName = ""
        this.lastName = ""
        this.streetAddress = ""
        this.streetAddressLineTwo = ""
        this.city = ""
        this.state = ""
        this.postal = ""
        this.country = ""
        this.email = ""
        this.areaCode = ""
        this.phoneNumber = ""
        this.position = ""
        this.date = ""}

    override fun toString(): String {
        return "JobForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", streetAddressLineTwo='" + streetAddressLineTwo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal='" + postal + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", date='" + date + '\'' +
                '}'
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}