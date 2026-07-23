package com.skil.app.data

object CloudinaryConfig {
    const val CLOUD_NAME = "aiz2tooi"
    const val UPLOAD_PRESET = "skilonline"
    const val API_KEY = "981773849764185"

    fun getOptimizedUrl(publicUrl: String, width: Int = 600): String {
        if (!publicUrl.contains("cloudinary.com")) return publicUrl
        return publicUrl.replace("/upload/", "/upload/f_auto,q_auto,w_$width/")
    }
}
