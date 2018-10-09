package tz.co.hosannahighertech.emailapp.models

data class Email(val isRead: Boolean = false,
                 val subject: String = "",
                 val photo: String = "",
                 val from: String = "",
                 val id: Int = 0,
                 val time: String = "",
                 val message: String = "",
                 val email: String = "")