package id.codepresso.letitflow.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Crafted by Razib Kani Maulidan on 10/10/20.
 **/

data class CatFactResponse(
    @SerializedName("createdAt")
    var createdAt: String,
    @SerializedName("deleted")
    var deleted: Boolean,
    @SerializedName("_id")
    var id: String,
    @SerializedName("source")
    var source: String,
    @SerializedName("status")
    var status: Status,
    @SerializedName("text")
    var text: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("updatedAt")
    var updatedAt: String,
    @SerializedName("used")
    var used: Boolean,
    @SerializedName("user")
    var user: String,
    @SerializedName("__v")
    var v: Int
) {
    data class Status(
        @SerializedName("sentCount")
        var sentCount: Int,
        @SerializedName("verified")
        var verified: Boolean
    )
}