package com.brotandos.btm

import com.brotandos.koatlib.KoatlFragment
import com.brotandos.koatlib.getString
import com.brotandos.koatlib.vBtn
import com.brotandos.koatlib.vVertical
import org.jetbrains.anko.doAsync
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class Frag: KoatlFragment() {

    private var token = ""

    override fun markup() = KUI {
        doAsync {
            with(URL("https://api.btmc.kz:1237/getToken").openConnection() as HttpURLConnection) {
                requestMethod = "GET"
                connectTimeout = 5000
                addRequestProperty("autoruzation", "login:password")
                addRequestProperty("login", "apiuser")
                addRequestProperty("password", "apihotels")
                println(BufferedInputStream(inputStream).getString())
            }
        }

        vVertical {
            vBtn("Забронировать") [row]
        }
    }
}