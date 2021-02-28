package com.zhangws.puppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.zhangws.puppy.bean.PuppyPost
import com.zhangws.puppy.constrainlayout.learnConstraintSet
import com.zhangws.puppy.ui.theme.color333333
import com.zhangws.puppy.ui.theme.color999999
import com.zhangws.puppy.ui.theme.colorEFEFEF
import com.zhangws.puppy.util.createPuppyData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           learnConstraintSet()
        }
    }


}



@Composable
fun Content() {
    Column() {
        Row(
            Modifier
                .height(50.dp)
                .background(colorEFEFEF),verticalAlignment= Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                text = "狗狗关爱中心", textAlign = TextAlign.Left,
                style = TextStyle(fontSize = 20.sp, color = color333333)
            )
        }
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = createPuppyData()) {
                PuppyMessage(post = it)
            }
        }
    }

}



@Composable
fun PuppyMessage(post: PuppyPost) {

    val puppy = post.content.puppy
    val master = post.content.master

    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
            .background(color = colorEFEFEF, shape = RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .padding(12.dp, 12.dp, 12.dp, 12.dp)
    ) {
        val (avatar, name, age, desc, city, date) = createRefs()

        Image(painter = painterResource(id = puppy.avatar),
            contentDescription = "dog avatar",
            modifier = Modifier
                .constrainAs(avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .size(100.dp)
                .clip(shape = RoundedCornerShape(5)),
            contentScale = ContentScale.Crop)

        Text(
            text = puppy.name,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(avatar.top, 2.dp)
                    start.linkTo(avatar.end, 12.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            fontSize = 18.sp,
            maxLines = 1,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = "${puppy.age}年 | ${puppy.breed} | ${puppy.feature}", modifier = Modifier
                .constrainAs(age) {
                    top.linkTo(name.bottom, 5.dp)
                    start.linkTo(name.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(color = color999999, fontSize = 13.sp)
        )

        Text(
            text = puppy.character, modifier = Modifier
                .constrainAs(desc) {
                    top.linkTo(age.bottom, 5.dp)
                    start.linkTo(name.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(color = color999999, fontSize = 13.sp)
        )

        Text(
            text = post.time, modifier = Modifier
                .constrainAs(date) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .wrapContentWidth(),
            style = TextStyle(color = color999999, fontSize = 12.sp)
        )

        Text(
            text = master.city, modifier = Modifier
                .constrainAs(city) {
                    centerVerticallyTo(date)
                    end.linkTo(date.start, 10.dp)
                    start.linkTo(name.start)
                    width = Dimension.fillToConstraints
                },
            style = TextStyle(color = color999999, fontSize = 13.sp),
            textAlign = TextAlign.Right
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Content()
}