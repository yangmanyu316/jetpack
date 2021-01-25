package com.kotlin.kt.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @ClassName: User
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 10:02
 */
@Entity(tableName = "user")
class User(id: Int, name: String, avatar: String, followers: Int, following: Int, blog: String, company: String, bio: String, location: String, htmlUrl: String) {
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id: Int = id

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String = name

    @ColumnInfo(name = "avatar", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar_url")
    var avatar: String = avatar

    @ColumnInfo(name = "followers", typeAffinity = ColumnInfo.INTEGER)
    var followers: Int = followers

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    var following: Int = following

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    var blog: String = blog

    @ColumnInfo(name = "company", typeAffinity = ColumnInfo.TEXT)
    var company: String = company

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    var bio: String = bio

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    var location: String = location

    @ColumnInfo(name = "htmlUrl", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("html_url")
    var htmlUrl: String = htmlUrl
    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", blog='" + blog + '\'' +
                ", company='" + company + '\'' +
                ", bio='" + bio + '\'' +
                ", location='" + location + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}'
    }

}