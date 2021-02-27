package com.zhangws.puppy.util

import com.zhangws.puppy.R
import com.zhangws.puppy.bean.*

fun createPuppyData():MutableList<PuppyPost>{
    val list = mutableListOf<PuppyPost>()

    list.add(
        PuppyPost(
            PostContent(
                PuppyMessage("小贝sdfa舒服舒服舒服舒服舒服法dfafafdasfa诉讼费", 2, "泰迪", "白毛", "温顺，可爱，粘人", R.mipmap.dog_avatar),
                PuppyMaster("张三", "深圳", 1)
            ),
            PostStatus.Overdue(), "2012-12-12"
        )
    )
    list.add(
        PuppyPost(
            PostContent(
                PuppyMessage("阿欢", 1, "金毛", "白毛", "温顺，可爱，粘人",R.mipmap.jinmao),
                PuppyMaster("张三", "深圳", 1)
            ),
            PostStatus.Normal(), "2012-12-12"
        )
    )
    list.add(
        PuppyPost(
            PostContent(
                PuppyMessage("呼啦啦", 2, "萨摩耶", "白色毛，毛绒绒的", "聪明，可爱，跑步快",R.mipmap.samoye),
                PuppyMaster("老王", "上海", 1)
            ),
            PostStatus.Normal(), "2020-11-12"
        )
    )
    list.add(
        PuppyPost(
            PostContent(
                PuppyMessage("哈哈", 2, "哈士奇", "白毛", "逗逗的，呆呆的",R.mipmap.hashiqi2),
                PuppyMaster("晓红", "杭州", 0)
            ),
            PostStatus.Normal(), "2021-2-12"
        )
    )

    list.add(
        PuppyPost(
            PostContent(
                PuppyMessage("娃娃", 1, "哈士奇", "黑毛,身体白色", "可爱，呆呆的",R.mipmap.hashiqi),
                PuppyMaster("小白", "日本", 1)
            ),
            PostStatus.Normal(), "2021-2-12"
        )
    )

    for (i in 1..10){
        list.add(
            PuppyPost(
                PostContent(
                    PuppyMessage("牧羊犬$i 号", i%3, "牧羊犬", "黄色毛，颈部黑毛", "聪明，喜欢吃肉肉",R.mipmap.muyan),
                    PuppyMaster("咸鱼", "北京", i%2+1)
                ),
                PostStatus.Normal(), "2020-12-4"
            )
        )
    }



    return list
}