package com.zhangws.puppy.bean

import androidx.annotation.IdRes

data class PuppyMessage(var name:String,var age:Int,var breed:String,
                        var feature:String,var character:String,@IdRes var avatar:Int)
data class PuppyMaster(var name:String,var city:String,var sex:Int)

data class PuppyPost(var content: PostContent, var status: PostStatus, var time:String)

data class PostContent(var puppy:PuppyMessage,var master:PuppyMaster)

sealed class PostStatus(){
    class Overdue(): PostStatus()
    class Normal(): PostStatus()
}