package com.zhangws.puppy.constrainlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.zhangws.puppy.Content
import com.zhangws.puppy.R
import com.zhangws.puppy.ui.theme.color999999
import com.zhangws.puppy.ui.theme.colorEFEFEF

@Composable
fun learnConstraintLayout() {

    ConstraintLayout(Modifier
        .padding(16.dp, 0.dp, 16.dp, 0.dp)
        .background(color = colorEFEFEF, shape = RoundedCornerShape(5.dp))
        .fillMaxWidth()
        .padding(12.dp, 12.dp, 12.dp, 12.dp)) {
        //通过createRefs创建三个引用
        val (imageRef, nameRef, descRef,ageRef,colorRef,timeRef) = createRefs()

        Image(painter = painterResource(id = R.mipmap.dog_avatar),
            contentDescription = "dog avatar",
            modifier = Modifier
                .constrainAs(imageRef) {//通过constrainAs将Image与imageRef绑定,并增加约束
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .size(100.dp)
                .clip(shape = RoundedCornerShape(5)),
            contentScale = ContentScale.Crop)

        Text(
            text = "泰迪",
            modifier = Modifier
                .constrainAs(nameRef) {
                    top.linkTo(imageRef.top, 2.dp)
                    start.linkTo(imageRef.end, 12.dp)
                    end.linkTo(parent.end)
                    width=Dimension.fillToConstraints
                },
            fontSize = 18.sp,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,

        )

        Text(text = "描述", modifier = Modifier
            .constrainAs(descRef) {
                top.linkTo(nameRef.bottom, 5.dp)
                start.linkTo(nameRef.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            .fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(color = color999999, fontSize = 13.sp)
        )

        Text(text = "年龄", modifier = Modifier
            .constrainAs(ageRef) {
                top.linkTo(descRef.bottom, 5.dp)
                start.linkTo(nameRef.start)
                bottom.linkTo(timeRef.top)
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(color = color999999, fontSize = 13.sp)
        )

        Text(text = "颜色", modifier = Modifier
            .constrainAs(colorRef) {
                start.linkTo(ageRef.end,10.dp)
                centerVerticallyTo(ageRef)
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(color = color999999, fontSize = 13.sp)
        )

        Text(text = "2021-02-28", modifier = Modifier
            .constrainAs(timeRef) {
                start.linkTo(nameRef.start)
                top.linkTo(ageRef.bottom)
                bottom.linkTo(parent.bottom)
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(color = color999999, fontSize = 13.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        learnConstraintLayout()
    }
}